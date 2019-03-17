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
 * @date: create in 下午2:35 2019/3/14
 */
@WebServlet("/ModifyRestServlet")
public class ModifyRestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String restCode=req.getParameter("restCode");
        String name=req.getParameter("name");
        String address=req.getParameter("address");
        String kind=req.getParameter("kind");

        RestaurantService restaurantService=new RestaurantServiceimpl();
        restaurantService.updateRestaurant(restCode,name,address,kind);

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("success");
    }
}
