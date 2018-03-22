package controllers;

import entity.Test;
import services.api.TestService;
import services.impl.TestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {

    public static final String TEST_JSP = "/test.jsp";
    public static final String TEST = "test";
    public static final String ID = "id";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter(ID);
        TestService testService = new TestServiceImpl();
        Test particularTest = testService.getTest(Long.parseLong(id));         
        req.setAttribute(TEST, particularTest);
        req.getRequestDispatcher(TEST_JSP).forward(req, resp);
    }
}
