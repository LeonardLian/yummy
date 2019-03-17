package com.javaee.service.impl;


import com.javaee.dao.FoodpackageDao;
import com.javaee.dao.RestaurantDao;
import com.javaee.entity.FoodpackageEntity;
import com.javaee.service.FoodpackageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午8:17 2019/3/10
 */
public class FoodpackageServiceImpl implements FoodpackageService{

    private ApplicationContext applicationContext=
            new ClassPathXmlApplicationContext("config.xml");

    private FoodpackageDao foodpackageDao=(FoodpackageDao) applicationContext.getBean("foodpackageDao");
    private RestaurantDao restaurantDao=(RestaurantDao)applicationContext.getBean("restaurantDao");

    //发布新套餐
    public void releaseFoodpackage(FoodpackageEntity foodpackage) {
        foodpackageDao.createFoodpackage(foodpackage);
    }

    //得到餐厅所有套餐
    public List getAllPackageOfOneRestaurant(String code) {
        return restaurantDao.getAllPackageOfOneRestaurant(code);
    }


}
