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

    private static final String CATALOG_JSP = "catalog.jsp";
    private static final String ALL_TESTS = "allTests";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher(CATALOG_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        doGet(req, resp);
    }
}
