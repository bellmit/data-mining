package com.jdrx.dm.rs;

import com.jdrx.dm.rs.server.NettyServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

public class Main {

	public static void main(String[] args) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/module-*.xml");
		Assert.notNull(appContext);
	    appContext.getBean(NettyServer.class).start();
	}

}
