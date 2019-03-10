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
 * @date: create in 下午11:43 2019/3/8
 */
@WebServlet("/SignInRestaurantServlet")
public class SignInRestaurantServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String code=req.getParameter("code");
        String password=req.getParameter("password");

        RestaurantService restaurantService=new RestaurantServiceimpl();
        boolean result=restaurantService.judgeRestaurantPassword(code,password);

        int checkResult=restaurantService.getCheckResult(code);

        if(result){
            if (checkResult==0){
                resp.getWriter().print("0");
            }
            else if(checkResult==1){
                resp.getWriter().print("1");
            }
            else if(checkResult==2){
                resp.getWriter().print("2");
            }
            else {}
        }
        else{
            resp.getWriter().print("3");
        }
    }
}
