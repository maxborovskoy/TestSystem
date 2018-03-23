package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Test;
import services.api.TestService;
import services.impl.TestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTestServlet extends HttpServlet {

    private static final String TEST = "test";
    private static final TestService testService = new TestServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String test = req.getParameter(TEST);
        createNewTest(convertJson(test));
    }

    private Test convertJson(String test) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(test, Test.class);
    }

    private void createNewTest(Test test) {
        testService.addTest(test);
    }
}
