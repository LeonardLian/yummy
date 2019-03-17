package com.javaee.service.impl;

import com.javaee.dao.FoodorderDao;
import com.javaee.dao.OrderstateDao;
import com.javaee.dao.UserDao;
import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.OrderstateEntity;
import com.javaee.service.FoodorderService;
import com.javaee.utility.TimeUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午8:15 2019/3/10
 */
public class FoodorderServiceImpl implements FoodorderService{

    private ApplicationContext applicationContext=
            new ClassPathXmlApplicationContext("config.xml");

    private FoodorderDao foodorderDao=(FoodorderDao) applicationContext.getBean("foodorderDao");
    private OrderstateDao orderstateDao=(OrderstateDao)applicationContext.getBean("orderstateDao");
    private UserDao userDao=(UserDao)applicationContext.getBean("userDao");

    //检索特定订单信息
    public FoodorderEntity findCertainFoodorderByOrderId(int orderId) {
        return foodorderDao.retrieveOrderById(orderId);
    }

    //检索特定订单状态
    public OrderstateEntity findCertainOrderstateByOrderId(int orderId) {
        return orderstateDao.retrieveByOrderstateId(orderId);
    }

    //订餐 0未支付，1已支付，2已过期，3在路上，4已送达  5已退订
    public void callOrder(FoodorderEntity foodorder) {
        foodorderDao.createFoodOrder(foodorder);
        orderstateDao.createOrderstate();
    }

    //支付订单
    public void payForOrder(int orderId, String username) {
        FoodorderEntity order=foodorderDao.retrieveOrderById(orderId);
        double price=order.getTotalprice();
        userDao.changeMoney(username,price,0);
        orderstateDao.updateOrderstate(orderId,"已支付", TimeUtils.getCurrentTime());
    }

    //退订订单
    public void cancelOrder(int orderId, String username) {
        FoodorderEntity order=foodorderDao.retrieveOrderById(orderId);
        double price=order.getTotalprice();
        userDao.changeMoney(username,price,1);
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

    //得到特定用户的所有订单
    public List getAllOrderOfOneUser(String username) {
        return foodorderDao.getAllOrderOfOneUser(username);
    }

    //得到特定餐厅的所有订单
    public List getAllOrderOfOneRest(String restCode) {
        return foodorderDao.getAllOrderOfOneRest(restCode);
    }

}
