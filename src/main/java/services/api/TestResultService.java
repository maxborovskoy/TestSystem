package services.api;

import entity.TestResult;

import java.util.List;

public interface TestResultService {

    void add(TestResult testResult);

    List<TestResult> getAllTestResultsByUserId(long userId);

    void remove(long id);

}
