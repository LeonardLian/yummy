package com.javaee.service;

import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.OrderstateEntity;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午7:55 2019/3/10
 */
public interface FoodorderService {

    FoodorderEntity findCertainFoodorderByOrderId(int orderId);

    OrderstateEntity findCertainOrderstateByOrderId(int orderId);

    void callOrder(FoodorderEntity foodorder);

    void cancelOrder(int orderId, String email);

    void payForOrder(int orderId, String email);

    void arriveForOrder(int orderId);

    void overdueForOrder(int orderId);

    void OnRoadForOrder(int orderId);

    List getAllOrderOfOneUser(String email);

    List getAllOrderOfOneRest(String restCode);
}
