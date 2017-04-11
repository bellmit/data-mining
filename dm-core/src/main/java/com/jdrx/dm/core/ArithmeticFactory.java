package com.jdrx.dm.core;

import com.jdrx.dm.baseinfo.commons.JsonUtils;
import com.jdrx.dm.bean.Arithmetic;
import com.jdrx.dm.bean.ArithmeticEnum;
import com.jdrx.dm.core.util.GeneralMapper;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.jdrx.dm.core.util.SpringBean.applicationContext;

/**
 * Created by 赵少泉 on 2016-07-12.
 */
public class ArithmeticFactory {

    public static char SPLIT = (char)1;
    private static String mapperPackage = "com.jdrx.dm.core.mapper";

    public static <T>T str2arithmetic(String json, String type){
        return JsonUtils.json2object(json, ArithmeticEnum.valueOf(type).value());
    }

    public static void saveArithmetic(String json, String type)throws Exception{
        Class<?> entity = ArithmeticEnum.valueOf(type).value();
        Arithmetic arithmetic = JsonUtils.json2object(json, entity);
        Class<?> mapperClass = Class.forName(String.format("%s.%sMapper", mapperPackage, entity.getSimpleName()));
        GeneralMapper mapper = applicationContext.getBean(mapperClass.asSubclass(GeneralMapper.class));
        mapper.save(arithmetic);
    }

    public static void saveArithmetic2(String json, String type)throws Exception{
        String[] types = type.split(",");
        List<String> list = new ArrayList<>();
        if(types.length > 1){
            for(String str : StringUtils.split(json, SPLIT)){
                list.add(str);
            }
        }else{
            list.add(json);
        }
        for(int i=0;i<types.length;i++){
            Class<?> entity = ArithmeticEnum.valueOf(types[i]).value();
            Arithmetic arithmetic = JsonUtils.json2object(list.get(i), entity);
            Class<?> mapperClass = Class.forName(String.format("%s.%sMapper", mapperPackage, entity.getSimpleName()));
            GeneralMapper mapper = applicationContext.getBean(mapperClass.asSubclass(GeneralMapper.class));
            mapper.save(arithmetic);
        }
    }

}
