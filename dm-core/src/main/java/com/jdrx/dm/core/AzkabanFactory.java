package com.jdrx.dm.core;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Created by 赵少泉 on 2016-07-12.
 */
public class AzkabanFactory {
    private Client client;
    private String sessionId;
    private static final String url = "https://192.168.10.124:8443";
//    private static final String url = "http://192.168.50.128:8080";


    private AzkabanFactory(){
        client = ClientBuilder.newClient();
    }

    public static AzkabanFactory newAzkaban(){
        return new AzkabanFactory();
    }

    public AzkabanFactory login(){
        Client client = ClientBuilder.newClient();
        Entity entity = Entity.form(new Form("action", "login").param("username", "azkaban").param("password", "azkaban"));
        Cookie cookie = Cookie.valueOf("azkaban.browser.session.id=bb31e2c0-3111-473c-97d0-cffadd2c7c03");
        Map<String,String> result = client.target(url).path("/").request(MediaType.TEXT_PLAIN).cookie(cookie).accept(MediaType.APPLICATION_JSON).post(entity, Map.class);
        System.out.println(result.get("session.id"));
        sessionId = result.get("session.id");
        return this;
    }

    public AzkabanFactory uploadJob(){
        ResteasyClient client = new ResteasyClientBuilder().build();
        MultipartFormDataOutput form = new MultipartFormDataOutput();
        form.addFormData("action", "upload", MediaType.TEXT_PLAIN_TYPE);
        form.addFormData("project", "dm-demo", MediaType.TEXT_PLAIN_TYPE);
        MediaType fileMediaType = new MediaType("application", "x-zip-compressed");
        File file = new File("C:\\Users\\Administrator\\Desktop\\job\\job.zip");
        try {
            form.addFormData("file", new FileInputStream(file), fileMediaType, file.getName());
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        Cookie cookie = new Cookie("azkaban.browser.session.id", sessionId);
        Entity entity = Entity.entity(new GenericEntity<>(form, MultipartFormDataOutput.class), MediaType.MULTIPART_FORM_DATA_TYPE);
        String result = client.target(url).path("/manager").request(MediaType.MULTIPART_FORM_DATA).cookie(cookie).accept(MediaType.WILDCARD).post(entity, String.class);
        System.out.println(result);
        return this;
    }

    public static void main(String[] args) {
        newAzkaban().login();
//        newAzkaban().uploadJob();
//        newAzkaban().login().uploadJob();
    }

}
