package com.javaee.dao.impl;

import com.javaee.dao.FoodDao;
import com.javaee.entity.FoodEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:22 2019/3/5
 */

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class FoodDaoImpl extends HibernateDaoSupport implements FoodDao{
    public void createFood(FoodEntity food) {
        this.getHibernateTemplate().save(food);
    }

    public void changeFoodNum(int foodId, int num, int state) {
        FoodEntity food=this.getHibernateTemplate().get(FoodEntity.class, foodId);
        int oldNum=food.getNumber();
        if (state == 0) {
            oldNum=oldNum-num;
        }else {
            oldNum=oldNum+num;
        }
        food.setNumber(oldNum);
        this.getHibernateTemplate().update(food);
    }

    public FoodEntity retrieveFoodById(int foodId) {
        return this.getHibernateTemplate().get(FoodEntity.class, foodId);
    }
}
