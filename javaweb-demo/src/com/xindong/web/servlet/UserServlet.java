package com.xindong.web.servlet;

import com.xindong.web.model.User;
import com.xindong.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user_servlet")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("执行成功!!!");
        String action = request.getParameter("action");
        switch (action) {

            case "user_list": {
                getUserList(request, response);
                break;
            }
            case "user_add": {
                userAdd(request, response);
                break;
            }
            case "user_delete": {
                userDelete(request, response);
                break;
            }
            case "user_edit": {

                userEdit(request, response);

                break;
            }
            case "user_update": {

                userUpdate(request, response);

                break;
            }
            default:
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    public void getUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String realName = request.getParameter("textRealName");
        User user = null;
        if (realName != null) {
            user = new User();
            user.setRealName(realName);

        }
        List<User> userList = userService.findUserByCondition(user);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void userAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        String realName = request.getParameter("realName");
        Integer gender = Integer.valueOf(request.getParameter("gender"));
        String createDate = request.getParameter("createDate");
        String updateDate = request.getParameter("updateDate");

        user.setGender(gender);
        user.setRealName(realName);
        user.setPassword(password);
        user.setLoginName(loginName);
        user.setCreateDate(createDate);
        user.setUpdateDate(updateDate);

        int i = userService.userAdd(user);
        response.sendRedirect("/javaweb-demo/user_servlet?action=user_list");

    }

    public void userDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int i = userService.userDelete(id);
        if (i != 0) {
            response.sendRedirect("/javaweb-demo/user_servlet?action=user_list");
        } else {

        }

    }

    public void userEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/edit.jsp").forward(request, response);

    }

    public void userUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        Integer id = Integer.valueOf(request.getParameter("id"));
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        String realName = request.getParameter("realName");
        Integer gender = Integer.valueOf(request.getParameter("gender"));
        String createDate = request.getParameter("createDate");
        String updateDate = request.getParameter("updateDate");
        user.setId(id);
        user.setGender(gender);
        user.setRealName(realName);
        user.setPassword(password);
        user.setLoginName(loginName);
        user.setCreateDate(createDate);
        user.setUpdateDate(updateDate);

        userService.userUpdate(user);
        response.sendRedirect("/javaweb-demo/user_servlet?action=user_list");

    }

}
