package controllers;

import entity.User;
import services.UserService;
import services.UserServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String REPASSWORD = "passwordRepeat";
    private static final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userNameCred = req.getParameter(USER);
        String userPassCred = req.getParameter(PASSWORD);
        String userRePassCred = req.getParameter(REPASSWORD);

        if(userService.isAlreadyExists(userNameCred)){
            req.getRequestDispatcher("/registation.jsp").forward(req, resp);
        } else if(!userPassCred.equals(userRePassCred)){
            req.getRequestDispatcher("/registation.jsp").forward(req, resp);
        } else {
            User user = new User(userNameCred, userPassCred, false);
            userService.registerUser(user);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
