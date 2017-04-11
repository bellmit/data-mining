package com.jdrx.dm.rs.api;

import com.jdrx.dm.baseinfo.commons.Message;
import com.jdrx.dm.bean.input.InParam;
import com.jdrx.dm.core.service.DataMiningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 赵少泉 on 2016-07-11.
 */
@Controller
@RequestMapping("/")
public class DataMiningApi {
    private final Logger logger = LoggerFactory.getLogger(DataMiningApi.class);
    @Autowired
    private DataMiningService dataMiningService;

    @RequestMapping(value="input",method=RequestMethod.POST)
    public @ResponseBody Message inputParam(@RequestBody InParam in){
        try{
            dataMiningService.input(in);
            return new Message("操作成功", true);
        }catch(Exception e){
            logger.error(e.getMessage(), e);
            return new Message("操作失败", false, e.getMessage());
        }
    }

}
