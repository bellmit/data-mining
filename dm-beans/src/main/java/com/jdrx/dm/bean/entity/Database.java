package com.jdrx.dm.bean.entity;

import java.io.Serializable;

/**
 * 数据库信息
 * Created by 赵少泉 on 2016-07-22.
 */
public class Database implements Serializable {
    private String id;
    private String jobId;
    private String type;
    private String host;
    private Integer port;
    private String user;
    private String pass;
    private String instance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    @Override
    public String toString() {
        return "Database{" +
                "id='" + id + '\'' +
                ", jobId='" + jobId + '\'' +
                ", type='" + type + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", instance='" + instance + '\'' +
                '}';
    }
}
