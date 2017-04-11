package com.jdrx.dm.bean.domain;

import com.jdrx.dm.bean.Arithmetic;

import java.io.Serializable;

/**
 * 决策树
 * Created by 赵少泉 on 2016-07-08.
 */
public class Dt implements Arithmetic, Serializable {
    private String dtId;                       // 决策树ID
    private String dtImpurity;                 // 算法因子：gini,entropy
    private Integer dtMaxDepth;                // 树的深度
    private Integer targetIdx;                 // 目标变量的索引号（从0开始）

    public Dt() {

    }

    public Dt(String dtId) {
        this.dtId = dtId;
    }

    public String getDtId() {
        return dtId;
    }

    public void setDtId(String dtId) {
        this.dtId = dtId;
    }

    public String getDtImpurity() {
        return dtImpurity;
    }

    public void setDtImpurity(String dtImpurity) {
        this.dtImpurity = dtImpurity;
    }

    public Integer getDtMaxDepth() {
        return dtMaxDepth;
    }

    public void setDtMaxDepth(Integer dtMaxDepth) {
        this.dtMaxDepth = dtMaxDepth;
    }

    public Integer getTargetIdx() {
        return targetIdx;
    }

    public void setTargetIdx(Integer targetIdx) {
        this.targetIdx = targetIdx;
    }

    @Override
    public String toString() {
        return "Dt{" +
                "dtId='" + dtId + '\'' +
                ", dtImpurity='" + dtImpurity + '\'' +
                ", dtMaxDepth=" + dtMaxDepth +
                ", targetIdx=" + targetIdx +
                '}';
    }
}
