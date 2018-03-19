package services;

import dao.TestDAO;
import entity.Test;

import java.util.List;

public class TestServiceImpl implements TestService {

    private TestDAO testDAO = new TestDAO();

    @Override
    public boolean addTest(Test test) {
        test.setQuest(new QuestionServiceImpl().getAllQuestionsByTestId(test.getId()));
        testDAO.add(test);
        return true;

    }

    @Override
    public Test getTest(Long id) {
        Test test = testDAO.get(id);
        test.setQuest(new QuestionServiceImpl().getAllQuestionsByTestId(id));
        return test;
    }

    @Override
    public List<Test> getAllTests() {
        return testDAO.getAll();
    }

    @Override
    public boolean removeTest(Long id) {
        testDAO.remove(id);
        new QuestionServiceImpl().removeAllQuestionsByTestId(id);
        return true;
    }

    @Override
    public boolean updateTest(Test test) {
        testDAO.update(test);
        return true;
    }
}
