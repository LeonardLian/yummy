package com.javaee.service;

import com.javaee.entity.FoodpackageEntity;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午7:54 2019/3/10
 */
public interface FoodpackageService {

    void releaseFoodpackage(FoodpackageEntity foodpackage);

    List getAllPackageOfOneRestaurant(String restCode);
}
