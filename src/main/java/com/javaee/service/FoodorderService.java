package com.javaee.service;

import com.javaee.entity.FoodorderEntity;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午7:55 2019/3/10
 */
public interface FoodorderService {

    FoodorderEntity findCertainFoodorderByOrderId(int orderId);

    void callOrder(FoodorderEntity foodorder);

    void cancelOrder(int orderId, String cardCode);

    void payForOrder(int orderId, String cardCode);

    void arriveForOrder(int orderId);

    void overdueForOrder(int orderId);

    void OnRoadForOrder(int orderId);
}
