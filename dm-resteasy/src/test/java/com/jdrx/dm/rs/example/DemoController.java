package com.jdrx.dm.rs.example;

import com.jdrx.dm.baseinfo.commons.Message;
import com.jdrx.dm.rs.domain.Demo;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 赵少泉 on 2016-07-01.
 */
@Path("/")
@Controller
@Consumes(MediaType.APPLICATION_JSON)
@Produces("application/json;charset=UTF-8")
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GET
    @Path("/index/{name}/{pass}")
    public Map<String, Object> index(@PathParam("name")String name, @PathParam("pass")String pass){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("pass", pass);
        logger.info(map.toString());
        return map;
    }

    @GET
    @Path("/get/{id}")
    public Message get(@PathParam("id")Integer id){
        try{
            Demo demo = new Demo(100, "a", "b");
            return new Message("查询成功", true, demo);
        }catch(Exception e){
            e.printStackTrace();
            return new Message("查询失败", false, e.getMessage());
        }
    }

    @POST
    @Path("/save")
    public Message save(Demo demo){
        try{
            return new Message("保存成功", true, 1);
        }catch(Exception e){
            return new Message("保存失败", false, e.getMessage());
        }
    }

    @PUT
    @Path("/update")
    public Message update(Demo demo){
        try{
            return new Message("修改成功", true, 1);
        }catch(Exception e){
            return new Message("修改失败", false, e.getMessage());
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Message delete(@PathParam("id")@DefaultValue("0")Integer id){
        try{
            return new Message("删除成功", true, 1);
        }catch(Exception e){
            return new Message("删除失败", false, e.getMessage());
        }
    }

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Message upload(MultipartFormDataInput input){
        Map<String, List<InputPart>> formParts = input.getFormDataMap();
        try{
            System.out.println(formParts.get("file").get(0));
            System.out.println(formParts.get("action").get(0).getBodyAsString());
            System.out.println(formParts.get("project").get(0).getBodyAsString());
            return new Message("上传成功", true);
        }catch(IOException e){
            logger.error(e.getMessage(), e);
            return new Message("上传失败", false);
        }
    }

}
