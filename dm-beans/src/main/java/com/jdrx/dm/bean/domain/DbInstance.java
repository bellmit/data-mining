package com.jdrx.dm.bean.domain;

import java.io.Serializable;

/**
 * 数据库配置
 * Created by 赵少泉 on 2016-07-08.
 */
public class DbInstance implements Serializable {
    private String instanceId;                      // 数据实例ID
    private String instanceType;                    // 数据实例类型：HIVE
    private String instanceIp;                      // 数据实例IP
    private Integer instancePort;                   // 数据实例端口
    private String instanceName;                    // 数据实例名
    private String instanceUser;                    // 用户
    private String instancePasswd;                  // 用户密码

    public DbInstance() {

    }

    public DbInstance(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getInstanceIp() {
        return instanceIp;
    }

    public void setInstanceIp(String instanceIp) {
        this.instanceIp = instanceIp;
    }

    public Integer getInstancePort() {
        return instancePort;
    }

    public void setInstancePort(Integer instancePort) {
        this.instancePort = instancePort;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getInstanceUser() {
        return instanceUser;
    }

    public void setInstanceUser(String instanceUser) {
        this.instanceUser = instanceUser;
    }

    public String getInstancePasswd() {
        return instancePasswd;
    }

    public void setInstancePasswd(String instancePasswd) {
        this.instancePasswd = instancePasswd;
    }

    @Override
    public String toString() {
        return "DbInstance{" +
                "instanceId='" + instanceId + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", instanceIp='" + instanceIp + '\'' +
                ", instancePort=" + instancePort +
                ", instanceName='" + instanceName + '\'' +
                ", instanceUser='" + instanceUser + '\'' +
                ", instancePasswd='" + instancePasswd + '\'' +
                '}';
    }
}
