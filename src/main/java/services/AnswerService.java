package services;

public interface AnswerService {

    void add(Answer answer);

    void remove(Long answerId);

    List<Answers> getAnswersByQuestionId(Long questionId);
}
