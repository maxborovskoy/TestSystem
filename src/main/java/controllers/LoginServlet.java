package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final String user = "user";
    private static final String password = "password";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(true){
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
