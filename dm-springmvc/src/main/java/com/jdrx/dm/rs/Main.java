package com.jdrx.dm.rs;

import com.evercreative.jetty.JettyUtil;

import static com.jdrx.dm.baseinfo.commons.GlobalConfig.get;

public class Main {

	public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(get("request.port", "8080"));
        String contextPath = get("request.context.path", "/");
        JettyUtil.newJettyUtil().createServer(contextPath, port).start();
	}

}
