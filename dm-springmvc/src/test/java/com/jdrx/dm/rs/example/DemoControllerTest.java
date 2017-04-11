package com.jdrx.dm.rs.example;

import com.jdrx.dm.baseinfo.commons.Message;
import com.jdrx.dm.rs.TestSupport;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by 赵少泉 on 2016-07-04.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoControllerTest extends TestSupport {

    @Test
    public void test01_index(){
        String result = client.target(url).path("/index").request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void test02_save(){
        Entity entity = Entity.entity("hello", MediaType.TEXT_PLAIN);
        Message result = client.target(url).path("/save").request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).post(entity, Message.class);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void test03_upload(){
        ResteasyClient client = new ResteasyClientBuilder().build();
        MultipartFormDataOutput form = new MultipartFormDataOutput();
        form.addFormData("action", "upload", MediaType.TEXT_PLAIN_TYPE);
        form.addFormData("project", "IQ", MediaType.TEXT_PLAIN_TYPE);
        MediaType fileMediaType = new MediaType("application", "x-zip-compressed");
        File file = new File("C:\\Users\\Administrator\\Desktop\\azkadan\\hello_test4.zip");
        try {
            form.addFormData("file", new FileInputStream(file), fileMediaType, file.getName());
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        Cookie cookie = new Cookie("azkaban.browser.session.id", "bb31e2c0-3111-473c-97d0-cffadd2c7c03");
        Entity entity = Entity.entity(new GenericEntity<>(form, MultipartFormDataOutput.class), MediaType.MULTIPART_FORM_DATA);
        Message result = client.target(url).path("/upload").request(MediaType.MULTIPART_FORM_DATA).cookie(cookie).accept(MediaType.APPLICATION_JSON).post(entity, Message.class);
        System.out.println(result);
    }
}
