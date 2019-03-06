package com.javaee.service;

import com.javaee.entity.FoodEntity;
import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.FoodpackageEntity;
import com.javaee.entity.RestaurantEntity;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:58 2019/3/5
 */
public interface RestaurantService {

    void addNewRestaurant(RestaurantEntity restaurant);

    int getCheckResult(RestaurantEntity restaurant);

    void releaseFood(FoodEntity food);

    void releaseFoodpackage(FoodpackageEntity foodpackage);

    void handleOrderState(FoodorderEntity foodorder, String newOrderstate);

    void changeFoodNum(FoodorderEntity foodorder);

}
