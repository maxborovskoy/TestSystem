package services;

import entity.Test;
import java.util.List;

public interface TestService {


    public boolean addTest(Test test);
    public Test getTest(Long id);
    public List<Test> getAllTests();
    public boolean removeTest(Long id);
    public boolean updateTest(Test test);
}