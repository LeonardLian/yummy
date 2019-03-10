package com.javaee.service.impl;

import com.javaee.dao.FoodpackageDao;
import com.javaee.dao.RestaurantDao;
import com.javaee.entity.FoodpackageEntity;
import com.javaee.service.FoodpackageService;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午8:17 2019/3/10
 */
public class FoodpackageServiceImpl implements FoodpackageService{

    FoodpackageDao foodpackageDao;
    RestaurantDao restaurantDao;
    //发布新套餐
    public void releaseFoodpackage(FoodpackageEntity foodpackage) {
        foodpackageDao.createFoodpackage(foodpackage);
    }

    //得到餐厅所有套餐
    public List getAllPackageOfOneRestaurant(String code) {
        return restaurantDao.getAllPackageOfOneRestaurant(code);
    }



    public void setFoodpackageDao(FoodpackageDao foodpackageDao) {
        this.foodpackageDao = foodpackageDao;
    }

    public FoodpackageDao getFoodpackageDao() {
        return foodpackageDao;
    }

    public RestaurantDao getRestaurantDao() {
        return restaurantDao;
    }

    public void setRestaurantDao(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }
}
