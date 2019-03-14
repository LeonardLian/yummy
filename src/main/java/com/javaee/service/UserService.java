package com.javaee.service;

import com.javaee.entity.UserEntity;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午7:52 2019/3/10
 */
public interface UserService {

    void addOrModifyUser(String email,String phone,String name,String address,String cardcode);

    void deleteUser(String email);

    void changeUserLevel(String email);

    UserEntity findCertainUserByUserEmail(String email);

    String generateRandomEmailCode();
}
