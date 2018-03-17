package controllers;

import entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestPageServlet extends HttpServlet {

    private Test CreateTestTest() {
        Answer[][] answers = new Answer[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                answers[i][j] = new Answer();
                answers[i][j].setId(i * 2 + j);
                answers[i][j].setText("Ответ " + (j + 1) + " к вопросу " + (i + 1) + ((j == 0 || i == 1) ? " (верный)" : " (неверный)"));
                answers[i][j].setQuestionId(i);
                answers[i][j].setRight(j == 0 || i == 1);
            }
        }
        Question[] questions = new Question[2];
        for (int i = 0; i < 2; i++) {
            questions[i] = new Question();
            questions[i].setAnswers(Arrays.asList(answers[i][0], answers[i][1]));
            questions[i].setId(i);
            questions[i].setTestId(0);
            questions[i].setText("Вопрос №" + (i + 1) + "?");
        }
        Test test = new Test();
        test.setId(1);
        test.setName("Какой-то тест");
        test.setType(TestTypes.PHYSICS);
        test.setQuest(Arrays.asList(questions[0], questions[1]));
        return test;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Test test = CreateTestTest();
        int correctAnswers = 0;
        for (Question q : test.getQuest()) {
            List<Long> answers = Arrays.stream(req.getParameterValues("q" + q.getId())).mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
            boolean isCorrect = true;
            for (Answer a : q.getAnswers()) {
                boolean isChecked = answers.contains(a.getId());
                if (a.getRight() && !isChecked || !a.getRight() && isChecked) {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect)
                correctAnswers++;
        }

        TestResult result = new TestResult();
        result.setTest(test);
        result.setCountAnswers(test.getQuest().size());
        result.setCorrectAnswers(correctAnswers);
        result.setScore(correctAnswers * 100 / test.getQuest().size());

        req.setAttribute("result", result);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Test test = CreateTestTest();
        req.setAttribute("test", test);
        req.getRequestDispatcher("test.jsp").forward(req, resp);
    }
}
