package services.impl;

import dao.TestResultDAO;
import entity.TestResult;
import services.api.TestResultService;

import java.util.List;

public class TestResultServiceImpl implements TestResultService {
    private TestResultDAO testResultDAO = new TestResultDAO();

    @Override
    public void add(TestResult testResult) {
        testResultDAO.add(testResult);
    }

    @Override
    public List<TestResult> getAllTestResultsByUserId(long userId) {
        return testResultDAO.getAllTestResultsByUserId(userId);
    }

    @Override
    public void remove(long id) {
        testResultDAO.remove(id);
    }
}
