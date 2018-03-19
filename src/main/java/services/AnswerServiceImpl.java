package services;

import dao.AnswerDAO;
import entity.Answer;

public class AnswerServiceImpl implements AnswerService {
    private AnswerDAO answerDAO = new AnswerDAO();

    @Override
    public void add(String text, Boolean isRight, long questionId) {
        Answer a = new Answer(text, isRight, questionId);
        answerDAO.add(a);
    }

    @Override
    public void remove(long id) {
        answerDAO.remove(id);
    }

    @Override
    public void update(long id, String text, Boolean isRight) {
        Answer res = new Answer(text, isRight, (answerDAO.get(id)).questionId);
        answerDAO.remove(id);
        answerDAO.add(res);
    }

    @Override
    public List<Answers> getAllAnswersByQuestionId(long questionId) {

        return answerDAO.getAllAnswersByQuestionId(questionId);
    }

    @Override
    public void removeAllAnswersByQuestionId(long questionId) {
        answerDAO.removeAllAnswersByQuestionId(questionId);
    }
}
