package com.javaee.dao;

import com.javaee.entity.FoodorderEntity;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:56 2019/3/5
 */
public interface FoodorderDao {

    List getAllOrderOfOneUser(int userId);

    void createFoodOrder(FoodorderEntity foodorder);

    FoodorderEntity retrieveOrderById(int orderId);

}
