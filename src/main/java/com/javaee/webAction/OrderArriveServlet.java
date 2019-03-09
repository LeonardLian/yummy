package com.javaee.webAction;

import com.javaee.service.impl.RestaurantServiceimpl;
import com.javaee.service.impl.UserServiceImpl;
import com.javaee.utility.TimeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

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

        new UserServiceImpl().arriveForOrder(orderid);

        resp.getWriter().print("success");
    }
}
