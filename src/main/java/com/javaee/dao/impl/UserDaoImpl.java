package com.javaee.dao.impl;

import com.javaee.dao.UserDao;
import com.javaee.entity.UserEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:20 2019/3/5
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    public void createUser(UserEntity user) {
        this.getHibernateTemplate().save(user);
    }

    public UserEntity retrieveByUserId(int userId) {
        return null;
    }

    public void deleteUser(int userId) {
        UserEntity user=this.getHibernateTemplate().get(UserEntity.class, userId);
        this.getHibernateTemplate().delete(user);
    }

    public void changeUserLevel(int userId, int newLevel) {
        UserEntity user=this.getHibernateTemplate().get(UserEntity.class, userId);
        user.setLevel(newLevel);
        this.getHibernateTemplate().update(user);
    }
}

// "Write operations are not allowed in read-only mode"  使用下述注释
// @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )