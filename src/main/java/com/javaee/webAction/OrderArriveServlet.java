package com.javaee.webAction;

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
 * @date: create in 下午11:55 2019/3/8
 */
@WebServlet("/OrderArriveServlet")
public class OrderArriveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int orderid=Integer.parseInt(req.getParameter("orderid"));

        FoodorderService foodorderService=new FoodorderServiceImpl();
        foodorderService.arriveForOrder(orderid);

        resp.getWriter().print("success");
    }
}
