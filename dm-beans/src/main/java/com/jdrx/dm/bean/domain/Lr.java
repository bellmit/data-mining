package com.jdrx.dm.bean.domain;

import com.jdrx.dm.bean.Arithmetic;

import java.io.Serializable;

/**
 * 逻辑回归
 * Created by 赵少泉 on 2016-07-08.
 */
public class Lr implements Arithmetic, Serializable {
    private String lrId;                        // 逻辑回归ID
    private Boolean intercept;                  // 是否截距
    private Integer numIteration;               // 迭代次数
    private Integer targetIdx;                  // 目标变量索引号（从0开始）

    public Lr() {

    }

    public Lr(String lrId) {
        this.lrId = lrId;
    }

    public String getLrId() {
        return lrId;
    }

    public void setLrId(String lrId) {
        this.lrId = lrId;
    }

    public Boolean getIntercept() {
        return intercept;
    }

    public void setIntercept(Boolean intercept) {
        this.intercept = intercept;
    }

    public Integer getNumIteration() {
        return numIteration;
    }

    public void setNumIteration(Integer numIteration) {
        this.numIteration = numIteration;
    }

    public Integer getTargetIdx() {
        return targetIdx;
    }

    public void setTargetIdx(Integer targetIdx) {
        this.targetIdx = targetIdx;
    }

    @Override
    public String toString() {
        return "Lr{" +
                "lrId='" + lrId + '\'' +
                ", intercept=" + intercept +
                ", numIteration=" + numIteration +
                ", targetIdx=" + targetIdx +
                '}';
    }
}
