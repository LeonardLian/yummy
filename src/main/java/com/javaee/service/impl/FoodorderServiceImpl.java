package com.javaee.service.impl;

import com.javaee.dao.BankcardDao;
import com.javaee.dao.FoodorderDao;
import com.javaee.dao.OrderstateDao;
import com.javaee.entity.FoodorderEntity;
import com.javaee.service.FoodorderService;
import com.javaee.utility.TimeUtils;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午8:15 2019/3/10
 */
public class FoodorderServiceImpl implements FoodorderService{

    private FoodorderDao foodorderDao;
    private OrderstateDao orderstateDao;
    private BankcardDao bankcardDao;

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
        orderstateDao.updateOrderstate(orderId,"已支付", TimeUtils.getCurrentTime());
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



    public void setOrderstateDao(OrderstateDao orderstateDao) {
        this.orderstateDao = orderstateDao;
    }

    public OrderstateDao getOrderstateDao() {
        return orderstateDao;
    }

    public void setBankcardDao(BankcardDao bankcardDao) {
        this.bankcardDao = bankcardDao;
    }

    public BankcardDao getBankcardDao() {
        return bankcardDao;
    }

    public FoodorderDao getFoodorderDao() {
        return foodorderDao;
    }

    public void setFoodorderDao(FoodorderDao foodorderDao) {
        this.foodorderDao = foodorderDao;
    }
}
