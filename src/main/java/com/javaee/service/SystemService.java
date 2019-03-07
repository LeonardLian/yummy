package com.javaee.service;

import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.RestaurantEntity;
import com.javaee.entity.UserEntity;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午2:32 2019/3/5
 */
public interface SystemService {

    void checkRestaurant(RestaurantEntity restaurantEntity, int result);

    void deleteUnpayOrder(FoodorderEntity foodorder);
}
