package com.javaee.webAction;

import com.alibaba.fastjson.JSON;
import com.javaee.entity.RestaurantEntity;
import com.javaee.service.RestaurantService;
import com.javaee.service.impl.RestaurantServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午11:40 2019/3/8
 */
@WebServlet("/LoadRestaurantListServlet")
public class LoadRestaurantListServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RestaurantService restaurantService=new RestaurantServiceimpl();
        List<RestaurantEntity> restaurantList=restaurantService.getAllRestaurantList();

        String json= JSON.toJSONString(restaurantList);

        resp.getWriter().print(json);
    }
}
