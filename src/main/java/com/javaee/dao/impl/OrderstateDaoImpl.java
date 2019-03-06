package com.javaee.dao.impl;

import com.javaee.dao.OrderstateDao;
import com.javaee.entity.OrderstateEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:28 2019/3/5
 */

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class OrderstateDaoImpl extends HibernateDaoSupport  {
    public void createOrderstate(OrderstateEntity Orderstate) {

    }

    public void updateOrderstate(OrderstateEntity Orderstate) {

    }

    public OrderstateEntity retrieveByOrderstateId(int orderId) {
        return null;
    }

    public void deleteOrderstate(OrderstateEntity Orderstate) {

    }
}
