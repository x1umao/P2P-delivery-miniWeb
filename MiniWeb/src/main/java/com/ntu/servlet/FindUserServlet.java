package com.ntu.servlet;

import com.alibaba.fastjson.JSON;
import com.ntu.dao.TaskDao;
import com.ntu.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        try {
            user = (User) req.getSession().getAttribute("user");
            user.setPassword(null);
        } catch (Exception ignored) {
        }
        String jsonString = JSON.toJSONString(user);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
