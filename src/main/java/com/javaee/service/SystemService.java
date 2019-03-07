package com.javaee.service;

import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.RestaurantEntity;
import com.javaee.entity.UserEntity;

import java.sql.Timestamp;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午2:32 2019/3/5
 */
public interface SystemService {

    void checkRestaurant(String code, int result);

    void deleteUnpayOrder(int orderId, Timestamp timestamp);
}
