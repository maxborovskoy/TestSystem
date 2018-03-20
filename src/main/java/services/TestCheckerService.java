package services;

import entity.Test;
import entity.TestResult;

import java.util.List;
import java.util.Map;

public interface TestCheckerService {

    TestResult CheckTest(Test test, Map<Long, List<Long>> answers);
}