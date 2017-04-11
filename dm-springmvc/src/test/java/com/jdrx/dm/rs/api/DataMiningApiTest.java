package com.jdrx.dm.rs.api;

import com.jdrx.dm.baseinfo.commons.JsonUtils;
import com.jdrx.dm.baseinfo.commons.Message;
import com.jdrx.dm.bean.Arithmetic;
import com.jdrx.dm.bean.domain.DbInstance;
import com.jdrx.dm.bean.domain.Dt;
import com.jdrx.dm.bean.domain.Lr;
import com.jdrx.dm.bean.domain.Source;
import com.jdrx.dm.bean.input.InParam;
import com.jdrx.dm.rs.TestSupport;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 赵少泉 on 2016-07-11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataMiningApiTest extends TestSupport {

    @Test
    public void test01_input(){
        InParam in = new InParam();
        in.setType("dt,lr");

        DbInstance instance = new DbInstance();
        instance.setInstanceId("0");
        instance.setInstanceType("hive");
        instance.setInstanceIp("192.168.10.121");
        instance.setInstancePort(10000);
        instance.setInstanceName("hive2");
        instance.setInstanceUser("hive");
        instance.setInstancePasswd("hive");
        in.setInstance(instance);

        Source source = new Source();
        source.setSourceId("0");
        source.setInstanceId("0");
        source.setSourceDb("dm_demo");
        source.setSourceTable("brand");
        in.setSource(source);

        Dt dt = new Dt();
        dt.setDtId("0");
        dt.setDtImpurity("gini");
        dt.setDtMaxDepth(5);
        dt.setTargetIdx(0);
        Lr lr = new Lr();
        lr.setLrId("0");
        lr.setIntercept(false);
        lr.setNumIteration(100);
        lr.setTargetIdx(0);
        StringBuilder str = new StringBuilder();
        str.append(JsonUtils.object2json(dt)).append((char)1).append(JsonUtils.object2json(lr));
        in.setArithmetic(str.toString());

        Entity<InParam> entity = Entity.entity(in, MediaType.APPLICATION_JSON);

        Message result = client.target(url).path("/input").request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).post(entity, Message.class);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

}
