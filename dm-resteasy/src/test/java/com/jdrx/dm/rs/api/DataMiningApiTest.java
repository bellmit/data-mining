package com.jdrx.dm.rs.api;

import com.jdrx.dm.baseinfo.commons.Message;
import com.jdrx.dm.bean.domain.Source;
import com.jdrx.dm.bean.input.InParam;
import com.jdrx.dm.rs.TestSupport;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

/**
 * Created by 赵少泉 on 2016-07-11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataMiningApiTest extends TestSupport {

    @Test
    public void test01_input(){
        InParam in = new InParam();
        in.setArithmetic("dt");

        Source source = new Source();
        source.setSourceId("1");
        source.setInstanceId("1");
        source.setSourceDb("test");
        source.setSourceTable("t_demo");
        in.setSource(source);

        Entity<InParam> entity = Entity.entity(in, MediaType.APPLICATION_JSON);

        Message result = client.target(url).path("/input").request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(entity, Message.class);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

}
