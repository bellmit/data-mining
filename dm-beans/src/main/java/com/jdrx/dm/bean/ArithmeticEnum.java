package com.jdrx.dm.bean;

import com.jdrx.dm.bean.domain.Dt;
import com.jdrx.dm.bean.domain.Lr;

/**
 * Created by 赵少泉 on 2016-07-11.
 */
public enum ArithmeticEnum {

    dt(Dt.class),
    lr(Lr.class);

    private Class<?> clazz;

    ArithmeticEnum(Class<?> clazz){
        this.clazz = clazz;
    }

    public Class<?> value(){
        return clazz;
    }

}
