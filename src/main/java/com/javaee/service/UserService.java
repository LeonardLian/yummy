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

    void modifyUserName(UserEntity user, String newName);

    void modifyUserAddress(UserEntity user, String newAddress);

    void changeUserLevel(UserEntity user);

    UserEntity findCertainUserByUserId(String userId);

    double calculateUserConsume(UserEntity user);

    void callOrder(FoodorderEntity foodorder);

    void cancelOrder(FoodorderEntity foodorder, Timestamp presentTime);

    void payForOrder(FoodorderEntity foodorder, Timestamp presentTime);
}
