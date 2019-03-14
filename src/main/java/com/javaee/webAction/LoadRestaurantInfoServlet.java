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

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午1:53 2019/3/14
 */
@WebServlet("/LoadRestaurantInfoServlet")
public class LoadRestaurantInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String restCode=req.getParameter("restCode");

        RestaurantService restaurantService=new RestaurantServiceimpl();
        RestaurantEntity restaurantEntity=restaurantService.retrieveByrestCode(restCode);

        String json= JSON.toJSONString(restaurantEntity);
        resp.getWriter().print(json);
    }
}
