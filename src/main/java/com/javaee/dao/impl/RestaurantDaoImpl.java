package com.javaee.dao.impl;

import com.javaee.dao.RestaurantDao;
import com.javaee.entity.FoodEntity;
import com.javaee.entity.RestaurantEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:28 2019/3/5
 */

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class RestaurantDaoImpl extends HibernateDaoSupport implements RestaurantDao {

    public void createRestaurant(RestaurantEntity restaurant) {
        this.getHibernateTemplate().save(restaurant);
    }

    public RestaurantEntity retrieveByRestaurantId(String code) {
        return this.getHibernateTemplate().get(RestaurantEntity.class, code);
    }

    public void changeRestaurantCheckState(String code, int newState) {
        RestaurantEntity restaurant=this.getHibernateTemplate().get(RestaurantEntity.class, code);
        restaurant.setState(newState);
        this.getHibernateTemplate().update(restaurant);
    }

    public void updateRestaurant(String restCode, String name, String address, String kind) {
        RestaurantEntity restaurantEntity=this.getHibernateTemplate().get(RestaurantEntity.class, restCode);
        restaurantEntity.setName(name);
        restaurantEntity.setAddress(address);
        restaurantEntity.setKind(kind);
        restaurantEntity.setState(0);
        this.getHibernateTemplate().update(restaurantEntity);
    }

    public List getAllRestaurantList() {
        return this.getHibernateTemplate().find("from RestaurantEntity");
    }

    public List getAllFoodOfOneRestaurant(String code) {
        String hql="from FoodEntity where restCode=?0";
        return this.getHibernateTemplate().find(hql,code);
//        FoodEntity foodEntity=new FoodEntity();
//        foodEntity.setRestCode(code);
//        return this.getHibernateTemplate().findByExample(foodEntity);
    }

    public List getAllPackageOfOneRestaurant(String code) {
        String hql="from FoodpackageEntity where restCode=?0";
        return this.getHibernateTemplate().find(hql,code);
    }

    public List getUncheckRestaurant() {
        String hql="from RestaurantEntity where state=0";
        return this.getHibernateTemplate().find(hql);
    }
}
