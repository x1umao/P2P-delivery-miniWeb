package com.ntu.servlet;

import com.ntu.domain.User;
import com.ntu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.alibaba.fastjson.JSON.parseObject;

@WebServlet("/signupServlet")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserService();

        String jsonString = req.getParameter("data");
        User newUser = parseObject(jsonString, User.class);

        int i = service.register(newUser);
        if (i==1){
            User user = service.login(newUser);
            req.getSession().setAttribute("user",user);
            resp.getWriter().write("success");
        }
        if (i==0){
            resp.getWriter().write("fail");
        }
    }
}
