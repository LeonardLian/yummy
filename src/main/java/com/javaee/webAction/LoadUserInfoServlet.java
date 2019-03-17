package com.javaee.webAction;

import com.alibaba.fastjson.JSON;
import com.javaee.entity.RestaurantEntity;
import com.javaee.entity.UserEntity;
import com.javaee.service.RestaurantService;
import com.javaee.service.UserService;
import com.javaee.service.impl.RestaurantServiceimpl;
import com.javaee.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午5:39 2019/3/14
 */
@WebServlet("/LoadUserInfoServlet")
public class LoadUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String username=req.getParameter("username");

        UserService userService=new UserServiceImpl();
        UserEntity userEntity=userService.findCertainUserByUsername(username);

        String json= JSON.toJSONString(userEntity);

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(json);
    }
}
