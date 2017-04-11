package com.jdrx.dm.bean.domain;

import java.io.Serializable;

/**
 * 源数据列
 * Created by 赵少泉 on 2016-07-08.
 */
public class SourceColumn implements Serializable {
    private String sourceId;                      // 源数据列ID
    private String oldName;                       // 旧列名
    private String newName;                       // 新列名
    private Integer oldIdx;                       // 旧索引位（从0开始）
    private Integer newIdx;                       // 新索引位（从0开始）
    private String colType;                       // 数据类型

    public SourceColumn() {

    }

    public SourceColumn(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public Integer getOldIdx() {
        return oldIdx;
    }

    public void setOldIdx(Integer oldIdx) {
        this.oldIdx = oldIdx;
    }

    public Integer getNewIdx() {
        return newIdx;
    }

    public void setNewIdx(Integer newIdx) {
        this.newIdx = newIdx;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    @Override
    public String toString() {
        return "SourceColumn{" +
                "sourceId='" + sourceId + '\'' +
                ", oldName='" + oldName + '\'' +
                ", newName='" + newName + '\'' +
                ", oldIdx=" + oldIdx +
                ", newIdx=" + newIdx +
                ", colType='" + colType + '\'' +
                '}';
    }
}
