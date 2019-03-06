package com.javaee.dao;

import com.javaee.entity.FoodEntity;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:56 2019/3/5
 */
public interface FoodDao {

    void createFood(FoodEntity food);

    void updateFood(FoodEntity food);

    FoodEntity retrieveByFoodId(int foodId);

    void deleteFood(FoodEntity food);

}
