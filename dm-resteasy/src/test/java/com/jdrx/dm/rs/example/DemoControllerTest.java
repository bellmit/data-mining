package com.jdrx.dm.rs.example;

import com.jdrx.dm.rs.TestSupport;
import com.jdrx.dm.baseinfo.commons.Message;
import com.jdrx.dm.rs.domain.Demo;
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
        String result = client.target(url).path("/index/hello/world").request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void test02_save(){
        Demo demo = new Demo(100, "abc", "def");
        Message result = client.target(url).path("/save").request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).post(Entity.entity(demo, MediaType.APPLICATION_JSON), Message.class);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void test03_get1(){
        Message result = client.target(url).path("/get/100").request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).get(Message.class);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void test04_update(){
        Demo demo = new Demo(100, "abc11", "def11");
        Message result = client.target(url).path("/update").request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).put(Entity.entity(demo, MediaType.APPLICATION_JSON), Message.class);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void test05_get2(){
        Message result = client.target(url).path("/get/100").request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).get(Message.class);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void test06_delete(){
        Message result = client.target(url).path("/delete/100").request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).delete(Message.class);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void test07_upload(){
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
        Entity entity = Entity.entity(new GenericEntity<>(form, MultipartFormDataOutput.class), MediaType.MULTIPART_FORM_DATA_TYPE);
        Message result = client.target(url).path("/upload").request(MediaType.MULTIPART_FORM_DATA).cookie(cookie).accept(MediaType.WILDCARD).post(entity, Message.class);
        System.out.println(result);
    }
}
