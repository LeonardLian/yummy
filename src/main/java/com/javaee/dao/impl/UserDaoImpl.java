package com.javaee.dao.impl;

import com.javaee.dao.UserDao;
import com.javaee.entity.BankcardEntity;
import com.javaee.entity.UserEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:20 2019/3/5
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    public void createUser(String username, String password, String email, String phone, String name, String addresses) {
        UserEntity userEntity1=new UserEntity();
        userEntity1.setUsername(username);
        userEntity1.setPassword(password);
        userEntity1.setEmail(email);
        userEntity1.setPhone(phone);
        userEntity1.setAddresses(addresses);
        userEntity1.setName(name);
        userEntity1.setLevel(0);
        userEntity1.setLeftmoney(1000.0);
        this.getHibernateTemplate().save(userEntity1);
    }

    public void updateUser(String username, String phone, String name, String addresses) {
        UserEntity userEntity=this.getHibernateTemplate().get(UserEntity.class, username);
        userEntity.setName(name);
        userEntity.setAddresses(addresses);
        userEntity.setPhone(phone);
        this.getHibernateTemplate().update(userEntity);
    }

    public void changeMoney(String username, double consumeMoney, int state) {
        UserEntity userEntity=this.getHibernateTemplate().get(UserEntity.class, username);
        double oldMoney=userEntity.getLeftmoney();

        if(state==0){
            oldMoney=oldMoney-consumeMoney;
        }else if(state==1){
            oldMoney=oldMoney+consumeMoney;
        }else {}

        userEntity.setLeftmoney(oldMoney);

        this.getHibernateTemplate().update(userEntity);
    }


    public UserEntity retrieveByUsername(String username) {
        return this.getHibernateTemplate().get(UserEntity.class, username);
    }

    public void deleteUser(String username) {
        UserEntity user=this.getHibernateTemplate().get(UserEntity.class, username);
        this.getHibernateTemplate().delete(user);
    }

    public void changeUserLevel(String username, int newLevel) {
        UserEntity user=this.getHibernateTemplate().get(UserEntity.class, username);
        user.setLevel(newLevel);
        this.getHibernateTemplate().update(user);
    }
}

// "Write operations are not allowed in read-only mode"  使用下述注释
// @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )