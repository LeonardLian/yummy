package com.javaee.service.impl;

import com.javaee.dao.FoodorderDao;
import com.javaee.dao.OrderstateDao;
import com.javaee.dao.UserDao;
import com.javaee.entity.FoodorderEntity;
import com.javaee.entity.OrderstateEntity;
import com.javaee.entity.UserEntity;
import com.javaee.service.UserService;
import com.javaee.utility.EntityUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午8:18 2019/3/10
 */
public class UserServiceImpl implements UserService {

    private ApplicationContext applicationContext=
            new ClassPathXmlApplicationContext("config.xml");

    private UserDao userDao=(UserDao)applicationContext.getBean("userDao");
    private FoodorderDao foodorderDao=(FoodorderDao)applicationContext.getBean("foodorderDao");
    private OrderstateDao orderstateDao=(OrderstateDao)applicationContext.getBean("orderstateDao");

    //添加用户
    public void addUser(String username, String password, String email, String phone, String name, String address) {
        userDao.createUser(username,password,email,phone,name,address);
    }

    //更新用户信息
    public void updateUser(String username, String phone, String name, String addresses) {
        userDao.updateUser(username,phone,name,addresses);
    }

    //注销用户
    public void deleteUser(String email) {
        userDao.deleteUser(email);
    }

    //判断登录密码
    public boolean judgeUserPassword(String username, String password) {
        UserEntity userEntity=userDao.retrieveByUsername(username);
        String correctPassword=userEntity.getPassword();
        return correctPassword.equals(password);
    }

    //修改用户等级 0未支付，1已支付，2已过期，3在路上，4已送达  5已退订
    public void changeUserLevel(String username) {
        double cost=0;
        List orderList=foodorderDao.getAllOrderOfOneUser(username);
        for (int i=0;i<orderList.size();i++){

            FoodorderEntity foodorder=(FoodorderEntity)orderList.get(i);

            int orderId=foodorder.getOrderid();
            OrderstateEntity orderstateEntity=orderstateDao.retrieveByOrderstateId(orderId);
            String state=orderstateEntity.getOrderstate();

            if(state.equals("已支付")||state.equals("在路上")||state.equals("已送达")){
                cost=cost+foodorder.getTotalprice();
            }
            else {}

            int newLevel=(int)(cost/100);
            userDao.changeUserLevel(username,newLevel);
        }
    }

    //检索特定用户的信息
    public UserEntity findCertainUserByUsername(String username) {
        return userDao.retrieveByUsername(username);
    }

    //生成邮箱验证码
    public String generateRandomEmailCode() {
        return EntityUtils.randomCodeGenerater();
    }
}
