package services;

import dao.AnswerDAO;

public class AnswerServiceImpl implements AnswerService {
    private AnswerDAO answerDAO = new AnswerDAO();
    @Override
    public void add(Answer answer) {
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<Answers> getAnswersByQuestionId(Long id) {
        return null;
    }
}
