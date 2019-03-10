package com.javaee.service;

import com.javaee.entity.UserEntity;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午7:52 2019/3/10
 */
public interface UserService {

    void addOrModifyUser(UserEntity user);

    void deleteUser(String email);

    void changeUserLevel(String email);

    UserEntity findCertainUserByUserEmail(String email);

    String generateRandomEmailCode();
}
