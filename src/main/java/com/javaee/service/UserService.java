package com.javaee.service;

import com.javaee.entity.UserEntity;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午7:52 2019/3/10
 */
public interface UserService {

    void addUser(String username, String password, String email, String phone, String name,String address);

    void updateUser(String username, String phone, String name, String addresses);

    void deleteUser(String username);

    void changeUserLevel(String username);

    boolean judgeUserPassword(String username,String password);

    UserEntity findCertainUserByUsername(String username);

    String generateRandomEmailCode();
}
