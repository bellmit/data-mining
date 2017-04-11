package com.jdrx.dm.rs;

import com.evercreative.jetty.JettyUtil;
import org.eclipse.jetty.server.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import static com.jdrx.dm.baseinfo.commons.GlobalConfig.get;

/**
 * Created by 赵少泉 on 2016-07-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:META-INF/spring/module-*.xml")
public class TestSupport {
    protected Server server;
    protected Client client;
    protected int port = Integer.parseInt(get("request.port", "8080"));
    protected String contextPath = get("request.context.path", "/");
    protected String url = String.format("http://localhost:%s%s", 8080, contextPath);

    @Before
    public void init()throws Exception{
        server = JettyUtil.createServer(contextPath, port);
        server.start();
        client = ClientBuilder.newClient();
    }

    @After
    public void destroy()throws Exception{
        server.stop();
        client.close();
    }
}
