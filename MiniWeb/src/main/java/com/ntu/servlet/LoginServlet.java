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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserService service = new UserService();

        String jsonString = req.getParameter("data");
        User loginUser = parseObject(jsonString, User.class);
        User user = service.login(loginUser);

        resp.setCharacterEncoding("UTF-8");
        if (user == null) {
            resp.getWriter().write("fail");

        } else {
            resp.getWriter().write("success");
        }
        //storage session
        req.getSession().setAttribute("user", user);
    }
}
