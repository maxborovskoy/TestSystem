package controllers;

import entity.Question;
import entity.Test;
import entity.TestResult;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import services.TestCheckerServiceImpl;
import services.TestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestPageServlet extends HttpServlet {

    private final static Logger log = LogManager.getLogger(TestPageServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        TestServiceImpl testService = new TestServiceImpl();
        Test test = testService.getTest(Long.parseLong(req.getParameter("testId")));
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
        req.setAttribute("test", test);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
        log.info("Test " + test + " was solved. " +
                "Score: " + result.getScore() + ". " +
                "Correct answers: " + result.getCorrectAnswers() + "/" + result.getCountAnswers() + ".");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Test test = new TestServiceImpl().getTest(Long.parseLong(req.getParameter("testId")));
        req.setAttribute("test", test);
        req.getRequestDispatcher("test.jsp").forward(req, resp);
        log.info("Test " + test + " is solving");
    }
}