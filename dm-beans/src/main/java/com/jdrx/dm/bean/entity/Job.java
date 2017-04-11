package com.jdrx.dm.bean.entity;

import java.io.Serializable;

/**
 * Created by 赵少泉 on 2016-07-22.
 */
public class Job implements Serializable {
    private String id;
    private String name;
    private Integer num;
    private Integer status;
    private String inType;
    private String outType;
    private String dependencies;
    private String sql;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInType() {
        return inType;
    }

    public void setInType(String inType) {
        this.inType = inType;
    }

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    public String getDependencies() {
        return dependencies;
    }

    public void setDependencies(String dependencies) {
        this.dependencies = dependencies;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", status=" + status +
                ", inType='" + inType + '\'' +
                ", outType='" + outType + '\'' +
                ", dependencies='" + dependencies + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }
}
