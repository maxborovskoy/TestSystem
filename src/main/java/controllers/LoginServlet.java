package controllers;

import entity.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.api.UserService;
import services.impl.UserServiceImpl;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String TUTOR_EMAIL = "tutor@tutor";
    private static final String CATALOG = "/catalog";
    private static final String LOGIN_JSP = "login.jsp";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String credentialsUser = req.getParameter(USER);
        String credentialsPassword = req.getParameter(PASSWORD);

        authorizeUser(req,
                resp,
                credentialsUser,
                new UserServiceImpl(),
                credentialsUser,
                credentialsPassword);


    }

    private void authorizeUser(HttpServletRequest req, HttpServletResponse resp, String credentialsUser, UserService validator, String name, String pass)
            throws ServletException, IOException {

        User user = validator.authorizeUser(name, pass);
        if (user != null) {

            HttpSession session = req.getSession();
            session.setAttribute(USER, user);

            resp.sendRedirect(CATALOG);

        } else {
            req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
