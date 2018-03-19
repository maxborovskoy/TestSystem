package services;

import entity.Question;
import java.util.List;

public interface QuestionService {
    void add(String text, long testId);

    void remove(long id);

    void update(long id, String text, long testId);

    void removeAllQuestionsByTestId(long testId);

    List<Question> getAllQuestionsByTestId(long testId);

    Question getQuestion(long id);


}
