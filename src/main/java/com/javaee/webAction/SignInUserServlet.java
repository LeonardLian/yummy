package com.javaee.webAction;

import com.javaee.service.UserService;
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
 * @date: create in 下午8:07 2019/3/16
 */
@WebServlet("/SignInUserServlet")
public class SignInUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String username=req.getParameter("username");
        String password=req.getParameter("password");

        UserService userService=new UserServiceImpl();
        boolean result=userService.judgeUserPassword(username,password);

        resp.setCharacterEncoding("utf-8");
        if(result){
            resp.getWriter().print("0");
        }
        else{
            resp.getWriter().print("1");
        }
    }
}
