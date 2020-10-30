package com.ntu.servlet;

import com.ntu.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletePostServlet")
public class DeletePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService service = new TaskService();
        int tid = Integer.parseInt(req.getParameter("tid"));

        int i = service.deletePostByTid(tid);

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(""+i);
    }
}
