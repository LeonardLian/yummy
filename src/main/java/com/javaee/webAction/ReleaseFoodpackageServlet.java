package com.javaee.webAction;

import com.javaee.entity.FoodpackageEntity;
import com.javaee.service.RestaurantService;
import com.javaee.service.impl.RestaurantServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午11:54 2019/3/8
 */
@WebServlet("/ReleaseFoodpackageServlet")
public class ReleaseFoodpackageServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        FoodpackageEntity foodpackageEntity=new FoodpackageEntity();
        foodpackageEntity.setRestCode(req.getParameter("restCode"));
        foodpackageEntity.setName(req.getParameter("name"));
        foodpackageEntity.setFoodCodes(req.getParameter("foodCodes"));
        foodpackageEntity.setFoodNums(req.getParameter("foodNums"));
        foodpackageEntity.setPrice(Double.parseDouble(req.getParameter("price")));

        RestaurantService restaurantService=new RestaurantServiceimpl();
        restaurantService.releaseFoodpackage(foodpackageEntity);

        resp.getWriter().print("success");
    }
}
