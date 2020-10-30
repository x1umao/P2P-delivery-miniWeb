package com.ntu.servlet;

import com.ntu.domain.User;
import com.ntu.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dealTaskServlet")
public class DealTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService service = new TaskService();
        String tid = req.getParameter("tid");
        String driver = req.getParameter("driver");
        User customer = (User) req.getSession().getAttribute("user");
        System.out.println(tid+driver);

        int i = service.dealTask(tid,driver,customer.getUsername());
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(""+i);
    }
}
