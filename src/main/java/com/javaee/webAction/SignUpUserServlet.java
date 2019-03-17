package com.javaee.webAction;

import com.javaee.entity.UserEntity;
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
 * @date: create in 下午8:15 2019/3/16
 */
@WebServlet("/SignUpUserServlet")
public class SignUpUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");
        String name=req.getParameter("name");
        String addresses=req.getParameter("addresses");

        UserService userService=new UserServiceImpl();

        userService.addUser(username,password,email,phone,name,addresses);

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("success");
    }
}
