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

    RestaurantDao restaurantDao;
    FoodDao foodDao;
    FoodpackageDao foodpackageDao;
    OrderstateDao orderstateDao;

    //注册新餐厅
    public void addNewRestaurant(RestaurantEntity restaurant) {
        restaurantDao.createRestaurant(restaurant);
    }

    //得到餐厅注册审核结果
    public int getCheckResult(String code) {
        RestaurantEntity restaurant=restaurantDao.retrieveByRestaurantId(code);
        return restaurant.getState();
    }

    //发布新菜品
    public void releaseFood(FoodEntity food) {
        foodDao.createFood(food);
    }

    //发布新套餐
    public void releaseFoodpackage(FoodpackageEntity foodpackage) {
        foodpackageDao.createFoodpackage(foodpackage);
    }


    //处理订单状态，0未支付，1已支付，2已过期，3在路上，4已送达
    public void handleOrderState(int orderId, String newOrderstate) {
        orderstateDao.updateOrderstate(orderId,newOrderstate, TimeUtils.getCurrentTime());
    }

    //订单支付后，更改相关菜品数量
    public void changeFoodNum(FoodorderEntity foodorder) {
        String[] packageIds=(foodorder.getPackageids()).split(",");
        String[] packageNums=(foodorder.getPackagenums()).split(",");
        String[] foodCodes=(foodorder.getFoodCodes()).split(",");
        String[] foodNums=(foodorder.getFoodNums()).split(",");

        for(int i=0;i<foodCodes.length;i++){
            int foodId=Integer.valueOf(foodCodes[i]);
            int foodNum=Integer.valueOf(foodNums[i]);
            foodDao.changeFoodNum(foodId,foodNum,0);
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
                foodDao.changeFoodNum(foodId,foodNum,0);
            }
        }
    }
}
