package com.javaee.webAction;

import com.alibaba.fastjson.JSON;
import com.javaee.service.RestaurantService;
import com.javaee.service.impl.RestaurantServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午6:28 2019/3/14
 */
@WebServlet("/LoadUncheckRestServlet")
public class LoadUncheckRestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RestaurantService restaurantService=new RestaurantServiceimpl();

        List list=restaurantService.getUncheckRest();
        System.out.println(list.size());

        String json= JSON.toJSONString(list);
        System.out.println(json);

        resp.setCharacterEncoding("utf-8");

        resp.getWriter().print(json);
    }
}
