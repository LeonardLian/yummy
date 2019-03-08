package com.javaee.webAction;

import com.alibaba.fastjson.JSON;
import com.javaee.entity.FoodEntity;
import com.javaee.service.SystemService;
import com.javaee.service.impl.SystemServiceImpl;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午10:58 2019/3/8
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String targetEmail=req.getParameter("email");

        String startEmail="1147588658@qq.com";
        String startAccount="1147588658";
        String password="oechlchfqorrjebg";

        Properties properties=System.getProperties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", "smtp.qq.com");

        Session session=Session.getInstance(properties);
        session.setDebug(true);

        String code="";
        try {

            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(startEmail));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(targetEmail));

            message.setSubject("获取您的yummy邮箱验证码");

            SystemService systemService=new SystemServiceImpl();
            code=systemService.generateRandomCode();

            message.setContent("您的验证码为："+code,"text/html;charset=UTF-8");

            Transport transport=session.getTransport();

            transport.connect(startAccount,password);
            transport.sendMessage(message,message.getAllRecipients());

            transport.close();

        }catch (MessagingException mex){
            mex.printStackTrace();
            resp.getWriter().print(mex.toString());
        }


        System.out.println(code);
        resp.getWriter().print(code);
//        FoodEntity foodEntity=new FoodEntity();
//        foodEntity.setFoodid(1);
//        foodEntity.setRestCode("asdf");
//        foodEntity.setPrice(13);
//        foodEntity.setNumber(9);
//
//        String foodJson= JSON.toJSONString(foodEntity);
//        resp.getWriter().print(foodJson);
    }
}
