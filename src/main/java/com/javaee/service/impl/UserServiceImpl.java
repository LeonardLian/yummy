package com.javaee.service.impl;

import com.javaee.dao.BankcardDao;
import com.javaee.dao.FoodorderDao;
import com.javaee.dao.OrderstateDao;
import com.javaee.dao.UserDao;
import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.OrderstateEntity;
import com.javaee.entity.UserEntity;
import com.javaee.service.UserService;
import com.javaee.utility.TimeUtils;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:54 2019/3/5
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private FoodorderDao foodorderDao;
    private OrderstateDao orderstateDao;
    private BankcardDao bankcardDao;

    //完善用户信息
    public void addOrModifyUser(UserEntity user) {

    }

    //注销用户
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
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

    //检索特定订单信息
    public FoodorderEntity findCertainFoodorderByOrderId(int orderId) {
        return foodorderDao.retrieveOrderById(orderId);
    }


    //订餐 0未支付，1已支付，2已过期，3在路上，4已送达  5已退订
    public void callOrder(FoodorderEntity foodorder) {
        foodorderDao.createFoodOrder(foodorder);
        orderstateDao.createOrderstate();
    }

    //支付订单
    public void payForOrder(int orderId, String cardCode) {
        FoodorderEntity order=foodorderDao.retrieveOrderById(orderId);
        double price=order.getTotalprice();
        bankcardDao.updateBankcard(cardCode,price,0);
        orderstateDao.updateOrderstate(orderId,"已支付",TimeUtils.getCurrentTime());
    }

    //退订订单
    public void cancelOrder(int orderId, String cardCode) {
        FoodorderEntity order=foodorderDao.retrieveOrderById(orderId);
        double price=order.getTotalprice();
        bankcardDao.updateBankcard(cardCode,price,1);
        orderstateDao.updateOrderstate(orderId,"已退订",TimeUtils.getCurrentTime());
    }

    //订单已送达
    public void arriveForOrder(int orderId) {
        orderstateDao.updateOrderstate(orderId,"已送达",TimeUtils.getCurrentTime());
    }

    //订单已过期
    public void overdueForOrder(int orderId) {
        orderstateDao.updateOrderstate(orderId,"已过期", TimeUtils.getCurrentTime());
    }

    //订单在路上
    public void OnRoadForOrder(int orderId) {
        orderstateDao.updateOrderstate(orderId,"在路上",TimeUtils.getCurrentTime());
    }



    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setFoodorderDao(FoodorderDao foodorderDao) {
        this.foodorderDao = foodorderDao;
    }

    public FoodorderDao getFoodorderDao() {
        return foodorderDao;
    }

    public BankcardDao getBankcardDao() {
        return bankcardDao;
    }

    public OrderstateDao getOrderstateDao() {
        return orderstateDao;
    }

    public void setBankcardDao(BankcardDao bankcardDao) {
        this.bankcardDao = bankcardDao;
    }

    public void setOrderstateDao(OrderstateDao orderstateDao) {
        this.orderstateDao = orderstateDao;
    }
}
