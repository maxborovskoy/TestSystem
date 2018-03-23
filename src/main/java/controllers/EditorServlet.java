package controllers;

import entity.Test;
import services.api.TestService;
import services.impl.TestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditorServlet extends HttpServlet {

    private static final String EDITOR_JSP = "editor.jsp";
    private static final String TEST = "test";
    private static final String ID = "id";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        TestService testService = new TestServiceImpl();
        Long testID = Long.parseLong(req.getParameter(ID));
        Test test = testService.getTest(testID);
        session.setAttribute(TEST, test);
        req.getRequestDispatcher(EDITOR_JSP).forward(req, resp);

    }
}
