package com.javaee.webAction;

import com.alibaba.fastjson.JSON;
import com.javaee.service.FoodorderService;
import com.javaee.service.impl.FoodorderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午8:54 2019/3/11
 */
@WebServlet("/LoadFoodorderOfCertainUserServlet")
public class LoadFoodorderOfCertainUserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String username=req.getParameter("username");

        FoodorderService foodorderService=new FoodorderServiceImpl();
        List list=foodorderService.getAllOrderOfOneUser(username);

        String json= JSON.toJSONString(list);

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(json);
    }
}
