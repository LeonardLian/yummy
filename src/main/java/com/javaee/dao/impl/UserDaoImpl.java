package com.javaee.dao.impl;

import com.javaee.dao.UserDao;
import com.javaee.entity.BankcardEntity;
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
    public void createOrModifyUser(String email, String phone, String name, String addresses,String cardcode) {
        UserEntity userEntity=this.getHibernateTemplate().get(UserEntity.class,email);
        if(userEntity.getEmail().equals(email)){
            userEntity.setName(name);
            userEntity.setAddresses(addresses);
            userEntity.setPhone(phone);
            this.getHibernateTemplate().update(userEntity);

            BankcardEntity bankcardEntity=new BankcardDaoImpl().retrieveByEmail(email);
            bankcardEntity.setCardcode(cardcode);
        }
        else {
            UserEntity userEntity1=new UserEntity();
            userEntity1.setEmail(email);
            userEntity1.setPhone(phone);
            userEntity1.setAddresses(addresses);
            userEntity1.setName(name);
            userEntity1.setLevel(0);
            this.getHibernateTemplate().save(userEntity1);

            BankcardEntity bankcardEntity=new BankcardEntity();
            bankcardEntity.setCardcode(cardcode);
            bankcardEntity.setEmail(email);
            bankcardEntity.setMoney(1000);
            new BankcardDaoImpl().createBankcard(bankcardEntity);
        }
    }

    public UserEntity retrieveByUserEmail(String email) {
        return this.getHibernateTemplate().get(UserEntity.class,email);
    }

    public void deleteUser(String email) {
        UserEntity user=this.getHibernateTemplate().get(UserEntity.class, email);
        this.getHibernateTemplate().delete(user);
    }

    public void changeUserLevel(String email, int newLevel) {
        UserEntity user=this.getHibernateTemplate().get(UserEntity.class, email);
        user.setLevel(newLevel);
        this.getHibernateTemplate().update(user);
    }
}

// "Write operations are not allowed in read-only mode"  使用下述注释
// @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )