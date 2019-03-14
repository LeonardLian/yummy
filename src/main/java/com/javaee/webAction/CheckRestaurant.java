package com.javaee.webAction;

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
 * @date: create in 下午7:10 2019/3/14
 */
@WebServlet("/CheckRestaurant")
public class CheckRestaurant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String restCode=req.getParameter("restCode");
        int result=Integer.parseInt(req.getParameter("result"));

        RestaurantService restaurantService=new RestaurantServiceimpl();
        restaurantService.checkRestaurant(restCode,result);

        resp.getWriter().print("success");
    }
}
