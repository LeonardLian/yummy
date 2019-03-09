package com.javaee.service.impl;

import com.javaee.dao.*;
import com.javaee.entity.*;
import com.javaee.service.RestaurantService;
import com.javaee.utility.TimeUtils;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午11:41 2019/3/5
 */
public class RestaurantServiceimpl implements RestaurantService {

    private RestaurantDao restaurantDao;
    private FoodDao foodDao;
    private FoodpackageDao foodpackageDao;
    private OrderstateDao orderstateDao;

    //注册新餐厅
    public void addNewRestaurant(RestaurantEntity restaurant) {
        restaurantDao.createRestaurant(restaurant);
    }

    //得到餐厅注册审核结果(0审核中 1通过 2未通过)
    public int getCheckResult(String code) {
        RestaurantEntity restaurant=restaurantDao.retrieveByRestaurantId(code);
        return restaurant.getState();
    }

    //搜索特定餐厅
    public RestaurantEntity retrieveByCode(String code) {
        return restaurantDao.retrieveByRestaurantId(code);
    }

    //发布新菜品
    public void releaseFood(FoodEntity food) {
        foodDao.createFood(food);
    }

    //发布新套餐
    public void releaseFoodpackage(FoodpackageEntity foodpackage) {
        foodpackageDao.createFoodpackage(foodpackage);
    }


    //订单支付或退订后，更改相关菜品数量
    public void changeFoodNum(FoodorderEntity foodorder, int state) {
        String[] packageIds=(foodorder.getPackageids()).split(",");
        String[] packageNums=(foodorder.getPackagenums()).split(",");
        String[] foodCodes=(foodorder.getFoodCodes()).split(",");
        String[] foodNums=(foodorder.getFoodNums()).split(",");

        for(int i=0;i<foodCodes.length;i++){
            int foodId=Integer.valueOf(foodCodes[i]);
            int foodNum=Integer.valueOf(foodNums[i]);
            foodDao.changeFoodNum(foodId,foodNum,state);
        }

        for(int i=0;i<packageIds.length;i++){
            int packageId=Integer.valueOf(packageIds[i]);
            int packageNum=Integer.valueOf(packageNums[i]);

            FoodpackageEntity foodpackage=foodpackageDao.retrievePackageByPackageId(packageId);
            String[] packageFoodCodes=foodpackage.getFoodCodes().split(",");
            String[] packageFoodNums=foodpackage.getFoodNums().split(",");

            for (int j=0;j<packageFoodCodes.length;j++) {
                int foodId=Integer.valueOf(packageFoodCodes[j]);
                int foodNum=Integer.valueOf(packageFoodNums[j])*packageNum;
                foodDao.changeFoodNum(foodId,foodNum,state);
            }
        }
    }

    public boolean judgeRestaurantPassword(String code, String password) {
        RestaurantEntity restaurantEntity=restaurantDao.retrieveByRestaurantId(code);
        String correctPassword=restaurantEntity.getPassword();
        return correctPassword.equals(password);
    }




    public void setRestaurantDao(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public RestaurantDao getRestaurantDao() {
        return restaurantDao;
    }

    public OrderstateDao getOrderstateDao() {
        return orderstateDao;
    }

    public void setOrderstateDao(OrderstateDao orderstateDao) {
        this.orderstateDao = orderstateDao;
    }

    public FoodDao getFoodDao() {
        return foodDao;
    }

    public FoodpackageDao getFoodpackageDao() {
        return foodpackageDao;
    }

    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public void setFoodpackageDao(FoodpackageDao foodpackageDao) {
        this.foodpackageDao = foodpackageDao;
    }
}
