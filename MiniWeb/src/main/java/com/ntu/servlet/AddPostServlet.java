package com.ntu.servlet;

import com.ntu.domain.Task;
import com.ntu.domain.User;
import com.ntu.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.alibaba.fastjson.JSON.parseObject;

@WebServlet("/addPostServlet")
public class AddPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService service = new TaskService();
        String jsonString = req.getParameter("data");
        Task newTask = parseObject(jsonString, Task.class);
        User user = (User) req.getSession().getAttribute("user");
        newTask.setCustomerId(user.getUid().toString());

        int i = service.addNewTask(newTask);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(""+i);
    }
}
