package services;

import entity.Test;
import java.util.List;

public interface TestService {

    public void addTest(Test test);
    public Test getTest(Long id);
    public List<Test> getAllTests();
    public void removeTest(Long id);
    public void changeTest(Test test);
}