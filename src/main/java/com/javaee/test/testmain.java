package com.javaee.test;

import com.javaee.dao.BankcardDao;
import com.javaee.entity.BankcardEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午8:58 2019/3/5
 */
public class testmain {
    public static void main(String[] args){
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("config.xml");

        BankcardDao bankcardDao=(BankcardDao) applicationContext.getBean("bankcardDao");

        BankcardEntity bankcardEntity=new BankcardEntity();
        bankcardEntity.setCardcode("111");
        bankcardEntity.setMoney(120);
        bankcardEntity.setUserid(2);


        //bankcardDao.createBankcard(bankcardEntity);
        bankcardDao.updateBankcard("111",11,0);
    }
}
