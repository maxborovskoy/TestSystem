package controllers;

import entity.Question;
import entity.Test;
import entity.TestResult;
import services.TestCheckerServiceImpl;
import services.TestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TestPageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        TestServiceImpl testService = new TestServiceImpl();
        Test test = testService.getTest(Long.parseLong(req.getParameter("testid")));
        Map<Long, List<Long>> answers = new HashMap<>();
        for (Question q : test.getQuest())
        {
            List<Long> answerList = Arrays.stream(req.getParameterValues("q"+q.getId()))
                    .mapToLong(Long::parseLong)
                    .boxed()
                    .collect(Collectors.toList());
            answers.put(q.getId(), answerList);
        }
        TestResult result = new TestCheckerServiceImpl().CheckTest(test, answers);

        req.setAttribute("result", result);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Test test = new TestServiceImpl().getTest(Long.parseLong(req.getParameter("testid")));
        req.setAttribute("test", test);
        req.getRequestDispatcher("test.jsp").forward(req, resp);
    }
}