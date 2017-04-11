package com.jdrx.dm.rs;

import com.jdrx.dm.rs.server.NettyServer;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Created by 赵少泉 on 2016-07-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:META-INF/spring/module-*.xml")
public class TestSupport {
    @Autowired
    protected NettyServer server;
    protected String url = "http://192.168.50.128:8080";
    protected Client client;

    @Before
    public void init() {
        server.start();
        client = ClientBuilder.newClient();
    }

    @After
    public void destroy(){
        server.shutdown();
        client.close();
    }
}
