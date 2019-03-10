package com.javaee.service;

import com.javaee.entity.FoodEntity;
import com.javaee.entity.FoodorderEntity;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午7:53 2019/3/10
 */
public interface FoodService {

    void releaseFood(FoodEntity food);

    void changeFoodNum(FoodorderEntity foodorder, int state);

    List getAllFoodOfOneRestaurant(String restCode);
}
