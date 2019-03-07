package com.javaee.dao;

import com.javaee.entity.OrderstateEntity;

import java.sql.Timestamp;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:58 2019/3/5
 */
public interface OrderstateDao {

    void updateOrderstate(int orderId, String newOrderState, Timestamp time);

    OrderstateEntity retrieveByOrderstateId(int orderId);

}
