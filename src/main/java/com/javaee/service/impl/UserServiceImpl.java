package com.javaee.service.impl;

import com.javaee.dao.BankcardDao;
import com.javaee.dao.FoodorderDao;
import com.javaee.dao.OrderstateDao;
import com.javaee.dao.UserDao;
import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.OrderstateEntity;
import com.javaee.entity.UserEntity;
import com.javaee.service.UserService;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:54 2019/3/5
 */
public class UserServiceImpl implements UserService {

    UserDao userDao;
    FoodorderDao foodorderDao;
    OrderstateDao orderstateDao;
    BankcardDao bankcardDao;
    //注册用户
    public void addNewUser(UserEntity user) {
        userDao.createUser(user);
    }

    //注销用户
    public void deleteUser(UserEntity user) {
        userDao.deleteUser(user);
    }


    //修改用户等级 0未支付，1已支付，2已过期，3在路上，4已送达  5已退订
    public void changeUserLevel(int userId) {
        double cost=0;
        List orderList=foodorderDao.getAllOrderOfOneUser(userId);
        for (int i=0;i<orderList.size();i++){

            FoodorderEntity foodorder=(FoodorderEntity)orderList.get(i);

            int orderId=foodorder.getOrderid();
            OrderstateEntity orderstateEntity=orderstateDao.retrieveByOrderstateId(orderId);
            String state=orderstateEntity.getOrderstate();

            if(state.equals("已支付")||state.equals("在路上")||state.equals("已送达")){
                cost=cost+foodorder.getTotalprice();
            }
            else {}

            int newLevel=(int)(cost/100);
            userDao.changeUserLevel(userId,newLevel);
        }


    }

    //检索特定用户的信息
    public UserEntity findCertainUserByUserId(int userId) {
        return userDao.retrieveByUserId(userId);
    }


    //订餐 0未支付，1已支付，2已过期，3在路上，4已送达  5已退订
    public void callOrder(FoodorderEntity foodorder) {
        foodorderDao.createFoodOrder(foodorder);
    }

    //支付订单
    public void payForOrder(int orderId, String cardCode, Timestamp presentTime) {
        FoodorderEntity order=foodorderDao.retrieveOrderById(orderId);
        double price=order.getTotalprice();
        bankcardDao.updateBankcard(cardCode,price,0);
        orderstateDao.updateOrderstate(orderId,"已支付",presentTime);
    }

    //退订订单
    public void cancelOrder(int orderId, Timestamp presentTime) {

    }

    //订单已送达
    public void arriveForOrder(int orderId, Timestamp presentTime) {
        FoodorderEntity order=foodorderDao.retrieveOrderById(orderId);

    }


}
