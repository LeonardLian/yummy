package com.javaee.service.impl;

import com.javaee.dao.FoodDao;
import com.javaee.dao.FoodpackageDao;
import com.javaee.dao.RestaurantDao;
import com.javaee.entity.FoodEntity;
import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.FoodpackageEntity;
import com.javaee.service.FoodService;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午8:17 2019/3/10
 */
public class FoodServiceImpl implements FoodService{

    FoodDao foodDao;
    FoodpackageDao foodpackageDao;
    RestaurantDao restaurantDao;

    //发布新菜品
    public void releaseFood(FoodEntity food) {
        foodDao.createFood(food);
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

    //得到餐厅菜单
    public List getAllFoodOfOneRestaurant(String code) {
        return restaurantDao.getAllFoodOfOneRestaurant(code);
    }




    public RestaurantDao getRestaurantDao() {
        return restaurantDao;
    }

    public void setRestaurantDao(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public FoodpackageDao getFoodpackageDao() {
        return foodpackageDao;
    }

    public void setFoodpackageDao(FoodpackageDao foodpackageDao) {
        this.foodpackageDao = foodpackageDao;
    }

    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public FoodDao getFoodDao() {
        return foodDao;
    }
}
