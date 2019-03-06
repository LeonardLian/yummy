package com.javaee.service.impl;

import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.UserEntity;
import com.javaee.service.UserService;

import java.sql.Timestamp;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:54 2019/3/5
 */
public class UserServiceImpl implements UserService {

    //注册用户
    public void addNewUser(UserEntity user) {

    }

    //注销用户
    public void deleteUser(UserEntity user) {

    }

    //修改用户姓名
    public void modifyUserName(UserEntity user, String newName) {

    }

    //修改用户地址
    public void modifyUserAddress(UserEntity user, String newAddress) {

    }

    //修改用户等级
    public void changeUserLevel(UserEntity user) {

    }

    //检索特定用户的信息
    public UserEntity findCertainUserByUserId(String userId) {
        return null;
    }


    public double calculateUserConsume(UserEntity user) {
        return 0;
    }

    //订餐
    public void callOrder(FoodorderEntity foodorder) {

    }

    //支付订单
    public void payForOrder(FoodorderEntity foodorder, Timestamp presentTime) {

    }

    //退订订单
    public void cancelOrder(FoodorderEntity foodorder, Timestamp presentTime) {

    }
}
