package com.javaee.dao;

import com.javaee.entity.RestaurantEntity;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:57 2019/3/5
 */
public interface RestaurantDao {

    void createRestaurant(RestaurantEntity restaurant);

    RestaurantEntity retrieveByRestaurantId(String code);

    void changeRestaurantCheckState(String code, int newState);

    void updateRestaurant(String restCode, String name, String address, String kind);

    List getAllRestaurantList();

    List getAllFoodOfOneRestaurant(String code);

    List getAllPackageOfOneRestaurant(String code);

    List getUncheckRestaurant();
}
