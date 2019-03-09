package com.javaee.webAction;

import com.javaee.entity.FoodorderEntity;
import com.javaee.service.RestaurantService;
import com.javaee.service.UserService;
import com.javaee.service.impl.RestaurantServiceimpl;
import com.javaee.service.impl.UserServiceImpl;


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
@WebServlet("/OrderCancelServlet")
public class OrderCancelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int orderid=Integer.parseInt(req.getParameter("orderid"));
        String cardcode=req.getParameter("cardcode");

        UserService userService=new UserServiceImpl();
        userService.cancelOrder(orderid,cardcode);

        FoodorderEntity foodorderEntity=userService.findCertainFoodorderByOrderId(orderid);
        int userid=foodorderEntity.getUserid();

        userService.changeUserLevel(userid);

        RestaurantService restaurantService=new RestaurantServiceimpl();
        restaurantService.changeFoodNum(foodorderEntity,1);

        resp.getWriter().print("success");
    }
}
