package com.jdrx.dm.bean.entity;

import java.io.Serializable;

/**
 * Created by 赵少泉 on 2016-07-22.
 */
public class Column implements Serializable {
    private String id;
    private String tabId;
    private Integer num;
    private String name;
    private String alias;
    private String type;
    private Integer precision;
    private Integer scale;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "Column{" +
                "id='" + id + '\'' +
                ", tabId='" + tabId + '\'' +
                ", num=" + num +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", type='" + type + '\'' +
                ", precision=" + precision +
                ", scale=" + scale +
                '}';
    }
}
