package com.javaee.webAction;

import com.alibaba.fastjson.JSON;
import com.javaee.entity.FoodEntity;
import com.javaee.service.SystemService;
import com.javaee.service.impl.SystemServiceImpl;

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
 * @date: create in 下午11:41 2019/3/8
 */
@WebServlet("/LoadFoodsOfCertainRestServlet")
public class LoadFoodsOfCertainRestServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String restCode=req.getParameter("restCode");
        SystemService systemService=new SystemServiceImpl();
        List<FoodEntity> foodList=systemService.getAllFoodOfOneRestaurant(restCode);

        String json= JSON.toJSONString(foodList);

        resp.getWriter().print(json);

    }
}
