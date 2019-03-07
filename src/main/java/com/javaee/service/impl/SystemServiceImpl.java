package com.javaee.service.impl;

import com.javaee.dao.OrderstateDao;
import com.javaee.dao.RestaurantDao;
import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.RestaurantEntity;
import com.javaee.entity.UserEntity;
import com.javaee.service.SystemService;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午2:40 2019/3/5
 */
public class SystemServiceImpl implements SystemService {

    private RestaurantDao restaurantDao;
    private OrderstateDao orderstateDao;
    //审核餐厅
    public void checkRestaurant(String code, int result) {
        restaurantDao.changeRestaurantCheckState(code,result);
    }

    //取消超过15分钟未付款的订单
    public void deleteUnpayOrder(int orderId, Timestamp timestamp) {
        orderstateDao.updateOrderstate(orderId,"已过期",timestamp);
    }

    //得到所有餐厅信息
    public List getAllRestaurantList() {
        return restaurantDao.getAllRestaurantList();
    }

    //得到餐厅菜单
    public List getAllFoodOfOneRestaurant(String code) {
        return restaurantDao.getAllFoodOfOneRestaurant(code);
    }

    //得到餐厅所有套餐
    public List getAllPackageOfOneRestaurant(String code) {
        return restaurantDao.getAllPackageOfOneRestaurant(code);
    }


    public void setOrderstateDao(OrderstateDao orderstateDao) {
        this.orderstateDao = orderstateDao;
    }

    public OrderstateDao getOrderstateDao() {
        return orderstateDao;
    }

    public RestaurantDao getRestaurantDao() {
        return restaurantDao;
    }

    public void setRestaurantDao(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }
}
