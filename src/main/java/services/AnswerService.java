package services;

import entity.Answer;

public interface AnswerService {

    void add(String text, Boolean isRight, long questionId);

    void remove(long id);

    void update(long id, String text, Boolean isRight);

    List<Answers> getAllAnswersByQuestionId(long questionId);

    void removeAllAnswersByQuestionId(long questionId);
}
