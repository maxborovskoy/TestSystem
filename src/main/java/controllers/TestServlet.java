package controllers;

import entity.Test;
import services.TestService;
import services.TestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        TestService testService = new TestServiceImpl();
        Test particularTest = testService.getTest(Long.parseLong(id));         
        req.setAttribute("test", particularTest);
        req.getRequestDispatcher("/test.jsp").forward(req, resp);
    }
}
