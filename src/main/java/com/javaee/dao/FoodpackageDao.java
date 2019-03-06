package com.javaee.dao;

import com.javaee.entity.FoodpackageEntity;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:59 2019/3/5
 */
public interface FoodpackageDao {

    void createFoodpackage(FoodpackageEntity foodpackage);

    void updateFoodpackage(FoodpackageEntity foodpackage);

    FoodpackageEntity retrieveByFoodpackageId(int packageId);

    void deleteFoodpackage(FoodpackageEntity foodpackage);

}
