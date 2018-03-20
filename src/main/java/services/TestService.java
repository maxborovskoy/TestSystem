package services;

import entity.Test;

import java.util.List;

public interface TestService {


    void addTest(Test test);

    Test getTest(Long id);

    List<Test> getAllTests();

    void removeTest(Long id);

    void updateTest(Test test);
}