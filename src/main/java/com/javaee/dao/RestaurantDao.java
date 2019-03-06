package com.javaee.dao;

import com.javaee.entity.RestaurantEntity;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:57 2019/3/5
 */
public interface RestaurantDao {

    void createRestaurant(RestaurantEntity restaurant);

    void updateRestaurant(RestaurantEntity restaurant);

    RestaurantEntity retrieveByRestaurantId(String code);

    void deleteRestaurant(RestaurantEntity restaurant);

}
