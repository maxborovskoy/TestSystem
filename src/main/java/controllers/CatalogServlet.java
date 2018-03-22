package controllers;

import entity.Test;
import services.api.TestService;
import services.impl.TestServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/Catalog")
public class CatalogServlet extends HttpServlet {

    public static final String CATALOG_JSP = "catalog.jsp";
    public static final String ALL_TESTS = "allTests";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestService testService = new TestServiceImpl();
        List<Test> allTests = testService.getAllTests();
        req.setAttribute(ALL_TESTS, allTests);
        req.getRequestDispatcher(CATALOG_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
