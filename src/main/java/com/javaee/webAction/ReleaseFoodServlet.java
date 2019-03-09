package com.javaee.webAction;

import com.javaee.entity.FoodEntity;
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
 * @date: create in 下午11:53 2019/3/8
 */
@WebServlet("/ReleaseFoodServlet")
public class ReleaseFoodServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        FoodEntity foodEntity=new FoodEntity();
        foodEntity.setRestCode(req.getParameter("restCode"));
        foodEntity.setPrice(Double.parseDouble(req.getParameter("price")));
        foodEntity.setNumber(Integer.parseInt(req.getParameter("number")));

        RestaurantService restaurantService=new RestaurantServiceimpl();
        restaurantService.releaseFood(foodEntity);

        resp.getWriter().print("success");
    }
}
