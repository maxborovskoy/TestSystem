package controllers;

import entity.Test;
import services.TestService;
import services.TestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class deleteTestServlet extends HttpServlet {

    private static final String ID = "id";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        TestService testService = new TestServiceImpl();

        String credentialsTestId = req.getParameter(ID);

        testService.removeTest(Long.parseLong(credentialsTestId));
        resp.sendRedirect("/catalog");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
