package com.javaee.dao.impl;

import com.javaee.dao.OrderstateDao;
import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.OrderstateEntity;
import com.javaee.utility.TimeUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:28 2019/3/5
 */

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class OrderstateDaoImpl extends HibernateDaoSupport implements OrderstateDao {

    public void createOrderstate() {
        Timestamp timestamp= TimeUtils.getCurrentTime();

        OrderstateEntity orderstateEntity=new OrderstateEntity();
        orderstateEntity.setOrderstate("未支付");
        orderstateEntity.setArrivetime(timestamp);
        orderstateEntity.setCanceltime(timestamp);
        orderstateEntity.setPaytime(timestamp);

        this.getHibernateTemplate().save(orderstateEntity);
    }

    public OrderstateEntity retrieveByOrderstateId(int orderId) {
        return this.getHibernateTemplate().get(OrderstateEntity.class, orderId);
    }

    //0未支付，1已支付，2已过期，3在路上，4已送达  5已退订
    public void updateOrderstate(int orderId, String newOrderState, Timestamp time) {
        OrderstateEntity oldOrderState=this.getHibernateTemplate().get(OrderstateEntity.class, orderId);
        oldOrderState.setOrderstate(newOrderState);
        if(newOrderState.equals("已支付")){
            oldOrderState.setPaytime(time);
        }
        else if(newOrderState.equals("已送达")){
            oldOrderState.setArrivetime(time);
        }
        else if(newOrderState.equals("已退订")){
            oldOrderState.setCanceltime(time);
        }
        else {}

        this.getHibernateTemplate().update(oldOrderState);
    }
}
