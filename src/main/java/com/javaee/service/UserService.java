package com.javaee.service;

import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.UserEntity;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:35 2019/3/5
 */
public interface UserService {

    void addNewUser(UserEntity user);

    void deleteUser(int userId);

    void changeUserLevel(int userId);

    UserEntity findCertainUserByUserId(int userId);

    FoodorderEntity findCertainFoodorderByOrderId(int orderId);

    void callOrder(FoodorderEntity foodorder);

    void cancelOrder(int orderId, String cardCode);

    void payForOrder(int orderId, String cardCode);

    void arriveForOrder(int orderId);

    void overdueForOrder(int orderId);

    void OnRoadForOrder(int orderId);
}
