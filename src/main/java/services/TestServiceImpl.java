package services;

import dao.TestDAO;
import entity.Test;

import java.util.List;

public class TestServiceImpl implements TestService {

    private TestDAO tDao = new TestDAO();

    @Override
    public void addTest(Test test) {
        test.setQuest(new QuestionServiceImpl().getAllQuestionsByTestId(test.getId()));
        tDao.add(test);
    }

    @Override
    public Test getTest(Long id) {
        Test test = tDao.get(id);
        test.setQuest(new QuestionServiceImpl().getAllQuestionsByTestId(id));
        return test;
    }

    @Override
    public List<Test> getAllTests() {
        //TODO REDONE
        return tDao.getAll();
    }

    @Override
    public void removeTest(Long id) {
        tDao.remove(id);
    }

    @Override
    public void changeTest(Test test) {
        tDao.update(test);
    }
}
