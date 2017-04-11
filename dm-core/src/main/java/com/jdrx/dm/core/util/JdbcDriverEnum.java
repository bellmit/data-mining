package com.jdrx.dm.core.util;

/**
 * jdbc类型枚举
 * @author 赵少泉
 * @date 2016年3月3日 上午10:03:59
 */
public enum JdbcDriverEnum {
	ORACLE("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@<host>:<port>:<dbname>"),
	MYSQL("com.mysql.jdbc.Driver", "jdbc:mysql://<host>:<port>/<dbname>"),
	MARIADB("org.mariadb.jdbc.Driver", "jdbc:mariadb://<host>:<port>/<dbname>"),
	DB2("com.ibm.db2.jcc.DB2Driver", "jdbc:db2://<host>:<port>/<dbname>"),
	HIVE("org.postgresql.Driver", "jdbc:postgresql://<host>:<port>/<dbname>"),
	POSTGRESQL("org.postgresql.Driver", "jdbc:postgresql://<host>:<port>/<dbname>"),
	SQLSERVER2000("com.microsoft.jdbc.sqlserver.SQLServerDriver", "jdbc:microsoft:sqlserver://<host>:<port>"),
	SQLSERVER2005("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://<host>:<port>");
//	SYBASE("com.sybase.jdbc3.jdbc.SybDriver", "jdbc:sybase:Tds:<host>:<port>"),
//	NETEZZA("org.netezza.Driver", "jdbc:netezza://<host>:<port>/<dbname>"),
//	INFORMIX("com.informix.jdbc.IfxDriver", "jdbc:informix-sqli://<host>:<port>/<dbname>:INFORMIXSERVER=<dbname>");

	private final String driver;
	private final String jdbcurl;

	JdbcDriverEnum(String driver, String jdbcurl){
		this.driver = driver;
		this.jdbcurl = jdbcurl;
	}

	public String getDriver(){
		return driver;
	}

	public String getUrl(String host, int port, String dbname){
		return jdbcurl.replace("<host>", host).replace("<port>", String.valueOf(port)).replace("<dbname>", dbname);
	}

}