package com.jdrx.dm.bean.input;

import com.jdrx.dm.bean.domain.DbInstance;
import com.jdrx.dm.bean.domain.Result;
import com.jdrx.dm.bean.domain.Source;

/**
 * 接收挖掘的输入参数
 * Created by 赵少泉 on 2016-07-08.
 */
public class InParam {
    private DbInstance instance;
    private Source source;
    private Result result;
    private String type;
    private String arithmetic;

    public DbInstance getInstance() {
        return instance;
    }

    public void setInstance(DbInstance instance) {
        this.instance = instance;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArithmetic() {
        return arithmetic;
    }

    public void setArithmetic(String arithmetic) {
        this.arithmetic = arithmetic;
    }

    @Override
    public String toString() {
        return "InParam{" +
                "instance=" + instance +
                ", source=" + source +
                ", result=" + result +
                ", type='" + type + '\'' +
                ", arithmetic='" + arithmetic + '\'' +
                '}';
    }
}
