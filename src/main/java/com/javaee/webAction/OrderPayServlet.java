package com.javaee.webAction;

import com.javaee.entity.FoodorderEntity;
import com.javaee.service.UserService;
import com.javaee.service.impl.UserServiceImpl;
import com.javaee.service.FoodService;
import com.javaee.service.FoodorderService;
import com.javaee.service.impl.FoodServiceImpl;
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
 * @date: create in 下午11:46 2019/3/8
 */
@WebServlet("/OrderPayServlet")
public class OrderPayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int orderid=Integer.parseInt(req.getParameter("orderid"));
        String cardcode=req.getParameter("cardcode");

        FoodorderService foodorderService=new FoodorderServiceImpl();
        foodorderService.payForOrder(orderid,cardcode);

        FoodorderEntity foodorderEntity=foodorderService.findCertainFoodorderByOrderId(orderid);
        String email=foodorderEntity.getEmail();

        UserService userService=new UserServiceImpl();
        userService.changeUserLevel(email);

        FoodService foodService=new FoodServiceImpl();
        foodService.changeFoodNum(foodorderEntity,0);

        resp.getWriter().print("success");
    }
}
