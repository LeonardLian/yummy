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

    void deleteUser(UserEntity user);


    void changeUserLevel(int userId);

    UserEntity findCertainUserByUserId(int userId);

    void callOrder(FoodorderEntity foodorder);

    void cancelOrder(int orderId, Timestamp presentTime);

    void payForOrder(int orderId, String cardcode, Timestamp presentTime);

    void arriveForOrder(int orderId, Timestamp presentTime);
}
