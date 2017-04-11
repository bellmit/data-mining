package com.jdrx.dm.bean.entity;

import java.io.Serializable;

/**
 * Created by 赵少泉 on 2016-07-22.
 */
public class Table implements Serializable {
    private String id;
    private String jobId;
    private Integer num;
    private String name;
    private String alias;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id='" + id + '\'' +
                ", jobId='" + jobId + '\'' +
                ", num=" + num +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
