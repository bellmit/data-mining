package com.jdrx.dm.rs.example;

import com.jdrx.dm.baseinfo.commons.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 赵少泉 on 2016-07-06.
 */
@Controller
@RequestMapping("/")
public class DemoController {

    @RequestMapping("home")
    public String home(){
        return "home";
    }

    @RequestMapping(value="index")
    public @ResponseBody Map<String, Object> index(String name)throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("name", String.format("%s，欢迎到来！", name));
        return map;
    }

    @RequestMapping(value="save",method=RequestMethod.POST)
    public @ResponseBody Message save()throws Exception{
        return new Message("保存成功", true);
    }

    @RequestMapping(value="upload",method=RequestMethod.POST)
    public @ResponseBody Message upload(HttpServletRequest request){
        try{
            Part part = request.getPart("file");
            InputStream in = part.getInputStream();
            OutputStream out = new FileOutputStream(new File("F:\\bb", part.getSubmittedFileName()));
            int length;
            byte[] buffer = new byte[1024];
            while((length = in.read(buffer)) != -1){
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
            return new Message("上传成功", true);
        }catch(Exception e){
            e.printStackTrace();
            return new Message("上传失败", false);
        }
    }

}
