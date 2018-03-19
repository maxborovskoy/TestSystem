package services;

import entity.Answer;

import java.util.List;

public interface AnswerService {

    void add(Answer answer);

    Answer get(long id);

    List<Answer> getAllAnswersByQuestionId(long questionId);

    void remove(long id);

    void removeAllAnswersByQuestionId(long questionId);

    void updateAnswerById(long id, String text, Boolean isRight);
}
