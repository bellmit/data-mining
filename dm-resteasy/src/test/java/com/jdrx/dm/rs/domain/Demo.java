package com.jdrx.dm.rs.domain;

import java.io.Serializable;

/**
 * Created by 赵少泉 on 2016-07-04.
 */
public class Demo implements Serializable {
    private Integer id;
    private String name;
    private String pass;

    public Demo() {

    }

    public Demo(Integer id) {
        this.id = id;
    }

    public Demo(Integer id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
