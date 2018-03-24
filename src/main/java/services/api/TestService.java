package services.api;

import entity.Test;

import java.util.List;

public interface TestService {


    Test addTest(Test test);

    Test getTest(Long id);

    List<Test> getAllTests();

    void removeTest(Long id);

    void updateTest(Test test);

    String addTestFromForm(Test test);

    String editThroughForm(Test test);
}