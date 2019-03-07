package com.javaee.service.impl;

import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.RestaurantEntity;
import com.javaee.entity.UserEntity;
import com.javaee.service.SystemService;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午2:40 2019/3/5
 */
public class SystemServiceImpl implements SystemService {

    //审核餐厅
    public void checkRestaurant(RestaurantEntity restaurantEntity, int result) {

    }

    //取消超过15分钟未付款的订单
    public void deleteUnpayOrder(FoodorderEntity foodorder) {

    }
}
