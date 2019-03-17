package com.javaee.webAction;

import com.javaee.entity.FoodorderEntity;
import com.javaee.service.FoodorderService;
import com.javaee.service.impl.FoodorderServiceImpl;
import com.javaee.utility.TimeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午11:42 2019/3/8
 */
@WebServlet("/OrderCallServlet")
public class OrderCallServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        FoodorderEntity foodorderEntity=new FoodorderEntity();

        foodorderEntity.setUsername(req.getParameter("username"));
        foodorderEntity.setRestCode(req.getParameter("restCode"));
        foodorderEntity.setUseraddress(req.getParameter("useraddress"));
        foodorderEntity.setPackageids(req.getParameter("packageids"));
        foodorderEntity.setPackagenums(req.getParameter("packagenums"));
        foodorderEntity.setFoodCodes(req.getParameter("foodCodes"));
        foodorderEntity.setFoodNums(req.getParameter("foodNums"));
        foodorderEntity.setTotalprice(Double.parseDouble(req.getParameter("totalprice")));
        foodorderEntity.setBuildtime(TimeUtils.getCurrentTime());

        FoodorderService foodorderService=new FoodorderServiceImpl();
        foodorderService.callOrder(foodorderEntity);

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("success");
    }
}
