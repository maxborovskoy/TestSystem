package services;

import entity.Question;
import java.util.List;

public interface QuestionService {
    void add(Question question);

    Question get(long id);

    List<Question> getAllQuestionsByTestId(long testId);

    void remove(long id);

    void removeAllQuestionsByTestId(long testId);

    void updateTextById(long id, String text);


}
