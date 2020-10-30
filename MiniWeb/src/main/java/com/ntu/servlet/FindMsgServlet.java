package com.ntu.servlet;

import com.alibaba.fastjson.JSON;
import com.ntu.domain.Message;
import com.ntu.domain.User;
import com.ntu.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findMsgServlet")
public class FindMsgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageService service = new MessageService();
        int tid = Integer.parseInt(req.getParameter("tid"));
        User user = (User) req.getSession().getAttribute("user");
        List<Message> messages = service.findTalkerByTid(tid,user);

        String jsonString = JSON.toJSONString(messages);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
