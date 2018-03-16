package services;

import dao.AnswerDAO;

public class AnswerServiceImpl implements AnswerService {
    private AnswerDAO answerDAO = new AnswerDAO();
    @Override
    public void add(Answer answer) {
        answerDAO.add(answer);
    }

    @Override
    public void remove(Long answerId) {
        answerDAO.remove(answerId);
    }

    @Override
    public List<Answers> getAnswersByQuestionId(Long questionId) {

        return answerDAO.getAllAnswersByQuestionId(questionId);
    }
}
