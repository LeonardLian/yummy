package com.javaee.dao.impl;

import com.javaee.dao.RestaurantDao;
import com.javaee.entity.RestaurantEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:28 2019/3/5
 */

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class RestaurantDaoImpl extends HibernateDaoSupport  {
    public void createRestaurant(RestaurantEntity restaurant) {

    }

    public void updateRestaurant(RestaurantEntity restaurant) {

    }

    public RestaurantEntity retrieveByRestaurantId(String code) {
        return null;
    }

    public void deleteRestaurant(RestaurantEntity restaurant) {

    }
}
