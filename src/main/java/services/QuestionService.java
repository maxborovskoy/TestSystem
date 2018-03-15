package services;

import services.Question;

public interface QuestionService {
    void add(Long id);

    void remove(Long id);

    void removeAllQuestionsByTestId(Long testId);

    List<Question> getQuestionsByTestId(Long testId);

    Question getQuestion(Long id);


}
