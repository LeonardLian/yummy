package com.javaee.service.impl;

import com.javaee.dao.FoodorderDao;
import com.javaee.dao.OrderstateDao;
import com.javaee.dao.UserDao;
import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.OrderstateEntity;
import com.javaee.entity.UserEntity;
import com.javaee.service.UserService;
import com.javaee.utility.EntityUtils;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午8:18 2019/3/10
 */
public class UserServiceImpl implements UserService {

    UserDao userDao;
    FoodorderDao foodorderDao;
    OrderstateDao orderstateDao;
    //完善用户信息
    public void addOrModifyUser(UserEntity user) {

    }

    //注销用户
    public void deleteUser(String email) {
        userDao.deleteUser(email);
    }


    //修改用户等级 0未支付，1已支付，2已过期，3在路上，4已送达  5已退订
    public void changeUserLevel(String email) {
        double cost=0;
        List orderList=foodorderDao.getAllOrderOfOneUser(email);
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
            userDao.changeUserLevel(email,newLevel);
        }
    }

    //检索特定用户的信息
    public UserEntity findCertainUserByUserEmail(String email) {
        return userDao.retrieveByUserEmail(email);
    }

    //生成邮箱验证码
    public String generateRandomEmailCode() {
        return EntityUtils.randomCodeGenerater();
    }



    public void setFoodorderDao(FoodorderDao foodorderDao) {
        this.foodorderDao = foodorderDao;
    }

    public FoodorderDao getFoodorderDao() {
        return foodorderDao;
    }

    public OrderstateDao getOrderstateDao() {
        return orderstateDao;
    }

    public void setOrderstateDao(OrderstateDao orderstateDao) {
        this.orderstateDao = orderstateDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
