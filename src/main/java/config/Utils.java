package config;

import entity.Test;
import services.api.TestService;
import services.impl.TestServiceImpl;
import java.util.List;

public class Utils {
    public static List<Test> getAllTestsByTheme(String theme){
        TestService testService = new TestServiceImpl();

        return "All".equals(theme) ? testService.getAllTests() : testService.getAllTestsByTheme(theme);
    }
}