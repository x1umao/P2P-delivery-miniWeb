package com.ntu.servlet;

import com.ntu.domain.Message;
import com.ntu.domain.User;
import com.ntu.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sendMsgServlet")
public class SendMsgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    /***
     * listener:msgListener,msg:msg,tid:msgTid
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = new Message();
        MessageService service = new MessageService();
        User user = (User) req.getSession().getAttribute("user");
        //Todo beanUtil
        message.setListener(req.getParameter("listener"));
        message.setMessage(req.getParameter("msg"));
        message.setTaskId(Integer.valueOf(req.getParameter("tid")));
        message.setTalker(user.getUsername());

        //return result
        int i = service.setMsg(message);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(""+i);

    }
}
