package com.kelvin.goodsagent.common.idgenerator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/9 17:26
 * @description:
 */
public class OrderGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return getId();
    }


    private String getId(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime dateTime =  LocalDateTime.now();
        String dateStr = dtf.format(dateTime)+ ((int)((Math.random()*9+1)*10000));
        return dateStr;
    }
}
