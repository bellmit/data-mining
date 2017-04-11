package com.jdrx.dm.bean.domain;

import java.io.Serializable;

/**
 * 结果集的列
 * Created by 赵少泉 on 2016-07-08.
 */
public class ResultColumn implements Serializable {
    private String resultId;                        // 结果集ID
    private String colName;                         // 列名
    private String colType;                         // 数据类型
    private Integer colIdx;                         // 列索引号（从0开始）

    public ResultColumn() {

    }

    public ResultColumn(String resultId) {
        this.resultId = resultId;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public Integer getColIdx() {
        return colIdx;
    }

    public void setColIdx(Integer colIdx) {
        this.colIdx = colIdx;
    }

    @Override
    public String toString() {
        return "ResultColumn{" +
                "resultId='" + resultId + '\'' +
                ", colName='" + colName + '\'' +
                ", colType='" + colType + '\'' +
                ", colIdx=" + colIdx +
                '}';
    }
}
