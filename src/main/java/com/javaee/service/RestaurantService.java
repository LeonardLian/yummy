package com.javaee.service;

import com.javaee.entity.RestaurantEntity;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午7:52 2019/3/10
 */
public interface RestaurantService {

    void addNewRestaurant(RestaurantEntity restaurant);

    RestaurantEntity retrieveByrestCode(String code);

    int getCheckResult(String code);

    void checkRestaurant(String code, int result);

    boolean judgeRestaurantPassword(String code,String password);

    List getAllRestaurantList();

    String generateRandomrestCode();
}
