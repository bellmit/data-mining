package com.jdrx.dm.bean.domain;

import java.io.Serializable;

/**
 * 源数据
 * Created by 赵少泉 on 2016-07-08.
 */
public class Source implements Serializable {
    private String sourceId;                       // 源数据ID
    private String instanceId;                     // 数据实例ID
    private String sourceDb;                       // 源数据的库名
    private String sourceTable;                    // 源数据的表名

    public Source() {

    }

    public Source(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getSourceDb() {
        return sourceDb;
    }

    public void setSourceDb(String sourceDb) {
        this.sourceDb = sourceDb;
    }

    public String getSourceTable() {
        return sourceTable;
    }

    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable;
    }

    @Override
    public String toString() {
        return "Source{" +
                "sourceId='" + sourceId + '\'' +
                ", instanceId='" + instanceId + '\'' +
                ", sourceDb='" + sourceDb + '\'' +
                ", sourceTable='" + sourceTable + '\'' +
                '}';
    }
}
