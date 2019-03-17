package com.javaee.dao;

import com.javaee.entity.UserEntity;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:57 2019/3/5
 */
public interface UserDao {

    void createUser(String username, String password, String email, String phone, String name, String addresses);

    void updateUser(String username, String phone, String name, String addresses );

    UserEntity retrieveByUsername(String username);

    void deleteUser(String username);

    void changeUserLevel(String username, int newLevel);

    void changeMoney(String username, double consumeMoney, int state);

}
