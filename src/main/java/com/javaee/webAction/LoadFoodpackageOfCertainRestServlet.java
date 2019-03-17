package com.javaee.webAction;

import com.alibaba.fastjson.JSON;
import com.javaee.entity.FoodpackageEntity;

import com.javaee.service.FoodpackageService;
import com.javaee.service.impl.FoodpackageServiceImpl;

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
@WebServlet("/LoadFoodpackageOfCertainRestServlet")
public class LoadFoodpackageOfCertainRestServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String restCode=req.getParameter("restCode");
        FoodpackageService foodpackageService=new FoodpackageServiceImpl();
        List foodpackageList=foodpackageService.getAllPackageOfOneRestaurant(restCode);

        String json= JSON.toJSONString(foodpackageList);

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(json);
    }
}
