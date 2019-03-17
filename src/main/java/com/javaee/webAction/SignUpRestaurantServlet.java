package com.javaee.webAction;

import com.javaee.entity.RestaurantEntity;
import com.javaee.service.RestaurantService;
import com.javaee.service.impl.RestaurantServiceimpl;
import com.javaee.utility.EntityUtils;

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
@WebServlet("/SignUpRestaurantServlet")
public class SignUpRestaurantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");

        String code= EntityUtils.randomCodeGenerater();
        resp.getWriter().print(code);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String code=req.getParameter("code");
        String password=req.getParameter("password");
        String address=req.getParameter("address");
        String kind=req.getParameter("kind");
        int state=0;
        String name=req.getParameter("name");

        RestaurantEntity restaurantEntity=new RestaurantEntity();
        restaurantEntity.setCode(code);
        restaurantEntity.setPassword(password);
        restaurantEntity.setAddress(address);
        restaurantEntity.setKind(kind);
        restaurantEntity.setState(state);
        restaurantEntity.setName(name);

        RestaurantService restaurantService=new RestaurantServiceimpl();

        restaurantService.addNewRestaurant(restaurantEntity);

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("success");
    }
}
