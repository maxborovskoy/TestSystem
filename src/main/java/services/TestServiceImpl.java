package services;

import dao.TestDAO;
import entity.Test;

import java.util.List;

public class TestServiceImpl implements TestService {

    private TestDAO testDAO = new TestDAO();

    @Override
    public void addTest(Test test) {
        test.setQuest(new QuestionServiceImpl().getAllQuestionsByTestId(test.getId()));
        testDAO.add(test);
    }

    @Override
    public Test getTest(Long id) {
        Test test = testDAO.getById(id);
        test.setQuest(new QuestionServiceImpl().getAllQuestionsByTestId(id));
        return test;
    }

    @Override
    public List<Test> getAllTests() {
        return testDAO.getAll();
    }

    @Override
    public void removeTest(Long id) {
        testDAO.removeById(id);
        new QuestionServiceImpl().removeAllQuestionsByTestId(id);
    }

    @Override
    public void updateTest(Test test) {
        testDAO.update(test);
    }
}
