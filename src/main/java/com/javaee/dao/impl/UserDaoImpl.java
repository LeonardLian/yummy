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
public class UserDaoImpl extends HibernateDaoSupport  {
    public void createUser(UserEntity user) {

    }

    public void updateUser(UserEntity user) {

    }

    public UserEntity retrieveByUserId(int userId) {
        return null;
    }

    public void deleteUser(UserEntity user) {

    }
}

// "Write operations are not allowed in read-only mode"  使用下述注释
// @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )