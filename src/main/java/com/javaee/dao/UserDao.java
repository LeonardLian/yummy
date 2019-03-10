package com.javaee.dao;

import com.javaee.entity.UserEntity;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:57 2019/3/5
 */
public interface UserDao {

    void createUser(UserEntity user);

    UserEntity retrieveByUserEmail(String email);

    void deleteUser(String email);

    void changeUserLevel(String email, int newLevel);

}
