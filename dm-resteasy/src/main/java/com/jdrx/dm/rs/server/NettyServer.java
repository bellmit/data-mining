package com.jdrx.dm.rs.server;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import javax.annotation.PreDestroy;
import javax.ws.rs.ext.Provider;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.jdrx.dm.baseinfo.commons.GlobalConfig.get;

@Component
public class NettyServer {
    @Autowired
    private ApplicationContext appContext;
    private int port = Integer.parseInt(get("request.port", "8080"));
    private String rootResourcePath = get("request.context.path", "/");
    private NettyJaxrsServer netty;

    public void start() {
        ResteasyDeployment deployment = new ResteasyDeployment();
        Collection<Object> providers = appContext.getBeansWithAnnotation(Provider.class).values();
        Collection<Object> controllers = appContext.getBeansWithAnnotation(Controller.class).values();
        //断言controllers不为空
        Assert.notEmpty(controllers);
        //设置providers
        if(providers != null){
            deployment.setProviders(Arrays.asList(providers.toArray()));
        }
        //设置controllers到deployment中
        deployment.setResources(Arrays.asList(controllers.toArray()));
        //设置bootstrap的参数
        Map<String, Object> channelOptions = new HashMap<>();
        channelOptions.put("reuseAddress", true);
        channelOptions.put("allowHalfClosure", true);

        netty = new NettyJaxrsServer();
        netty.setPort(port);
        netty.setDeployment(deployment);
        netty.setChannelOptions(channelOptions);
        netty.setRootResourcePath(rootResourcePath);
        netty.setSecurityDomain(null);
        netty.start();
    }

    @PreDestroy
    public void shutdown() {
        netty.stop();
    }

    public String getRootResourcePath() {
        return rootResourcePath;
    }

    public int getPort() {
        return port;
    }

}