package com.jdrx.dm.bean.domain;

import java.io.Serializable;

/**
 * 比较类业务
 * Created by 赵少泉 on 2016-07-08.
 */
public class Business implements Serializable {
    private String businessId;                      // 业务ID
    private String algorithmType;                   // 算法类型:LR(逻辑回归)、DT(决策树)
    private String algorithmContent;                // 算法内容


    public Business() {

    }

    public Business(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(String algorithmType) {
        this.algorithmType = algorithmType;
    }

    public String getAlgorithmContent() {
        return algorithmContent;
    }

    public void setAlgorithmContent(String algorithmContent) {
        this.algorithmContent = algorithmContent;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId='" + businessId + '\'' +
                ", algorithmType='" + algorithmType + '\'' +
                ", algorithmContent='" + algorithmContent + '\'' +
                '}';
    }
}
