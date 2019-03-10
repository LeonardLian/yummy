package com.javaee.dao.impl;

import com.javaee.dao.FoodorderDao;
import com.javaee.entity.FoodorderEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:23 2019/3/5
 */

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class FoodorderDaoImpl extends HibernateDaoSupport implements FoodorderDao{
    public void createFoodOrder(FoodorderEntity foodorder) {
        this.getHibernateTemplate().save(foodorder);
    }

    public List getAllOrderOfOneUser(String email) {
        String hql="from FoodorderEntity where email = ?0";
        List orderlist=this.getHibernateTemplate().find(hql,email);
        return orderlist;
    }

    public FoodorderEntity retrieveOrderById(int orderId) {
        return this.getHibernateTemplate().get(FoodorderEntity.class,orderId);
    }
}
