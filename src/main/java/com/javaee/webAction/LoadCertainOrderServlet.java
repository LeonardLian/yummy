package com.javaee.webAction;

import com.alibaba.fastjson.JSON;
import com.javaee.entity.FoodorderEntity;
import com.javaee.service.FoodorderService;
import com.javaee.service.impl.FoodorderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午2:28 2019/3/12
 */
@WebServlet("/LoadCertainOrderServlet")
public class LoadCertainOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int orderId=Integer.parseInt(req.getParameter("orderId"));

        FoodorderService foodorderService=new FoodorderServiceImpl();
        FoodorderEntity foodorderEntity=foodorderService.findCertainFoodorderByOrderId(orderId);

        String json= JSON.toJSONString(foodorderEntity);
        resp.getWriter().print(json);
    }
}
