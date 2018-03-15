package services;

public interface AnswerService {

    void add(Long id);

    void remove(Long id);

    List<Answers> getAnswersByQuestionId(Long id);
}
