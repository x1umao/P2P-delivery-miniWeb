package com.ntu.servlet;

import com.alibaba.fastjson.JSON;
import com.ntu.dao.TaskDao;
import com.ntu.domain.Task;
import com.ntu.domain.User;
import com.ntu.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.alibaba.fastjson.JSON.parseObject;

@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService service = new TaskService();
        int pageNum = Integer.parseInt(req.getParameter("pageNum"));
        int pageStatus = Integer.parseInt(req.getParameter("pageStatus"));
        User user = (User) req.getSession().getAttribute("user");

        List<Task> task = service.getTaskByPage(pageNum, pageStatus, user);
        String jsonString = JSON.toJSONString(task);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
