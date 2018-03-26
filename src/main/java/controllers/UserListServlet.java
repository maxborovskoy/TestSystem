

package controllers;

import entity.TestResult;
import entity.User;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.api.UserService;
import services.impl.TestResultServiceImpl;
import services.impl.UserServiceImpl;

public class UserListServlet extends HttpServlet {

    private static final String USER_LIST_JSP = "/userList.jsp";
    private static final String USER = "user";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = new UserServiceImpl().getAll();
        req.setAttribute("users", users);
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(USER_LIST_JSP).forward(req, resp);

    }
}