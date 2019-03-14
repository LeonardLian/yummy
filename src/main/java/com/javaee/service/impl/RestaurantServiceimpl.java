package com.javaee.service.impl;

import com.javaee.dao.RestaurantDao;
import com.javaee.entity.RestaurantEntity;
import com.javaee.service.RestaurantService;
import com.javaee.utility.EntityUtils;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午8:18 2019/3/10
 */
public class RestaurantServiceimpl implements RestaurantService {

    private RestaurantDao restaurantDao;

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
    public RestaurantEntity retrieveByrestCode(String code) {
        return restaurantDao.retrieveByRestaurantId(code);
    }

    //判断餐厅登录密码
    public boolean judgeRestaurantPassword(String code, String password) {
        RestaurantEntity restaurantEntity=restaurantDao.retrieveByRestaurantId(code);
        String correctPassword=restaurantEntity.getPassword();
        return correctPassword.equals(password);
    }

    //审核餐厅
    public void checkRestaurant(String code, int result) {
        restaurantDao.changeRestaurantCheckState(code,result);
    }

    //得到所有餐厅信息
    public List getAllRestaurantList() {
        return restaurantDao.getAllRestaurantList();
    }

    //得到餐厅注册码
    public String generateRandomrestCode() {
        return EntityUtils.randomCodeGenerater();
    }

    //更新餐厅信息
    public void updateRestaurant(String restCode, String name, String address, String kind) {
        restaurantDao.updateRestaurant(restCode,name,address,kind);
    }

    //返回未审核的餐厅
    public List getUncheckRest() {
        return restaurantDao.getUncheckRestaurant();
    }

    public void setRestaurantDao(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public RestaurantDao getRestaurantDao() {
        return restaurantDao;
    }
}
