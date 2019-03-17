package com.javaee.webAction;

import com.alibaba.fastjson.JSON;
import com.javaee.entity.OrderstateEntity;
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
 * @date: create in 下午3:09 2019/3/12
 */
@WebServlet("/LoadCertainOrderStateServlet")
public class LoadCertainOrderStateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int orderid=Integer.parseInt(req.getParameter("orderid"));

        FoodorderService foodorderService=new FoodorderServiceImpl();
        OrderstateEntity orderstateEntity=foodorderService.findCertainOrderstateByOrderId(orderid);

        String json = JSON.toJSONString(orderstateEntity);

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(json);
    }
}
