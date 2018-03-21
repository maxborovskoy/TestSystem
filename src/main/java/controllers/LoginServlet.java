package controllers;

import entity.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.UserService;
import services.UserServiceImpl;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final String USER = "user";
    private static final String PASSWORD = "password";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String credentialsUser = req.getParameter(USER);
        String credentialsPassword = req.getParameter(PASSWORD);


        authorizeUser(req,
            resp,
            credentialsUser,
            new UserServiceImpl(),
                new User(credentialsUser, credentialsPassword, false));

    }

    private void authorizeUser(HttpServletRequest req, HttpServletResponse resp, String credentialsUser, UserService validator, User user)
        throws ServletException, IOException {
        if (validator.authorizeUser(user)) {

            HttpSession session = req.getSession();
            session.setAttribute(USER, credentialsUser);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/catalog");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
