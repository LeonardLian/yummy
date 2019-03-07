package com.javaee.dao.impl;

import com.javaee.dao.FoodpackageDao;
import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.FoodpackageEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:26 2019/3/5
 */

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class FoodpackageDaoImpl extends HibernateDaoSupport  implements FoodpackageDao{
    public void createFoodpackage(FoodpackageEntity foodpackage) {
        this.getHibernateTemplate().save(foodpackage);
    }

    public FoodpackageEntity retrievePackageByPackageId(int packageId) {
        return this.getHibernateTemplate().get(FoodpackageEntity.class, packageId);
    }
}
