package com.xindong.web.servlet;

import com.xindong.web.model.User;
import com.xindong.web.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

//    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp
    ) throws ServletException, IOException {


        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        UserService userService=context.getBean("userService",UserService.class);


        User user = userService.findUserByLoginName(loginName);

        if (user != null) {
            if (!user.getPassword().equals(password)) {
                req.setAttribute("msg", "密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            } else {
                req.setAttribute("msg", "登录成功");
                req.getSession().setAttribute("username",user.getRealName());
                req.getRequestDispatcher("/user_servlet?action=user_list").forward(req,resp);

            }
        } else {
            req.setAttribute("msg", "用户名不存在");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }
}
