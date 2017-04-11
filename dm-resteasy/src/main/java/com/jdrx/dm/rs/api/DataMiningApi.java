package com.jdrx.dm.rs.api;

import com.jdrx.dm.baseinfo.commons.Message;
import com.jdrx.dm.bean.input.InParam;
import com.jdrx.dm.core.service.DataMiningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by 赵少泉 on 2016-07-11.
 */
@Path("/")
@Controller
@Consumes(MediaType.APPLICATION_JSON)
@Produces("application/json;charset=UTF-8")
public class DataMiningApi {
    private final Logger logger = LoggerFactory.getLogger(DataMiningApi.class);
    @Autowired
    private DataMiningService dataMiningService;

    @POST
    @Path("/input")
    public Message inputParam(InParam in){
        try{
            dataMiningService.input(in);
            return new Message("操作成功", true);
        }catch(Exception e){
            logger.error(e.getMessage(), e);
            return new Message("操作失败", false, e.getMessage());
        }
    }

}
