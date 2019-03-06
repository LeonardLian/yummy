package com.javaee.dao;

import com.javaee.entity.FoodorderEntity;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:56 2019/3/5
 */
public interface FoodorderDao {

    void createFoodorder(FoodorderEntity foodorder);

    void updateFoodorder(FoodorderEntity foodorder);

    FoodorderEntity retrieveByFoodorderId(int orderId);

    void deleteFoodorder(FoodorderEntity foodorder);

}
