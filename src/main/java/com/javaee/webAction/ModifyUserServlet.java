package com.javaee.webAction;

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
 * @date: create in 下午5:07 2019/3/14
 */
@WebServlet("/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String username=req.getParameter("username");
        String phone=req.getParameter("phone");
        String name=req.getParameter("name");
        String address=req.getParameter("addresses");

        new UserServiceImpl().updateUser(username,phone,name,address);

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("success");
    }
}
