package com.javaee.service.impl;

import com.javaee.dao.OrderstateDao;
import com.javaee.dao.RestaurantDao;
import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.RestaurantEntity;
import com.javaee.entity.UserEntity;
import com.javaee.service.SystemService;

import java.sql.Timestamp;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午2:40 2019/3/5
 */
public class SystemServiceImpl implements SystemService {

    RestaurantDao restaurantDao;
    OrderstateDao orderstateDao;
    //审核餐厅
    public void checkRestaurant(String code, int result) {
        restaurantDao.changeRestaurantCheckState(code,result);
    }

    //取消超过15分钟未付款的订单
    public void deleteUnpayOrder(int orderId, Timestamp timestamp) {
        orderstateDao.updateOrderstate(orderId,"已过期",timestamp);
    }
}
