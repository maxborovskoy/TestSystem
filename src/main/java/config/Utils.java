package config;

import entity.Test;
import entity.TestResult;
import services.api.TestService;
import services.impl.TestResultServiceImpl;
import services.impl.TestServiceImpl;
import java.util.List;

public class Utils {
    public static List<Test> getAllTestsByTheme(String theme){
        TestService testService = new TestServiceImpl();

        return "All".equals(theme) ? testService.getAllTests() : testService.getAllTestsByTheme(theme);
    }

    public static String getTestName(long testId){
        return new TestServiceImpl().getTest(testId).getName();
    }

    public static int getPercents(TestResult testResult){
        return new TestResultServiceImpl().getScore(testResult);
    }
}
