package controllers;

import entity.User;
import services.api.UserService;
import services.impl.UserServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationServlet extends HttpServlet {

    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String REPASSWORD = "passwordRepeat";
    private static final UserService userService = new UserServiceImpl();
    private static final String REGISTRATION_JSP = "/registration.jsp";
    private static final String LOGIN_JSP = "/login.jsp";
    private static final String FLAG = "flag";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userNameCred = req.getParameter(USER);
        String userPassCred = req.getParameter(PASSWORD);
        String userRePassCred = req.getParameter(REPASSWORD);
        HttpSession session = req.getSession();
        if (isEmptyFields(userNameCred, userPassCred, userRePassCred)) {
            session.setAttribute(FLAG, "Please fill all fields");
            req.getRequestDispatcher(REGISTRATION_JSP).forward(req, resp);
        } else {
            User user = new User(userNameCred, userPassCred, false);


            if (userService.isAlreadyExists(user)) {
                session.setAttribute(FLAG, "User is already exists");
                req.getRequestDispatcher(REGISTRATION_JSP).forward(req, resp);
            } else if (!userPassCred.equals(userRePassCred)) {
                session.setAttribute(FLAG, "Wrong repeated password");
                req.getRequestDispatcher(REGISTRATION_JSP).forward(req, resp);
            } else {
                userService.registerUser(user);
                req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
            }
        }
    }

    private boolean isEmptyFields(String userNameCred, String userPassCred, String userRePassCred) {
        return userNameCred.isEmpty() || userPassCred.isEmpty() || userRePassCred.isEmpty();
    }
}
