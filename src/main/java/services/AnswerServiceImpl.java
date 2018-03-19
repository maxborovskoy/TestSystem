package services;

import dao.AnswerDAO;
import entity.Answer;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {
    private AnswerDAO answerDAO = new AnswerDAO();

    @Override
    public void add(Answer answer) {
        answerDAO.add(answer);
    }

    @Override
    public Answer get(long id) {
        return answerDAO.get(id);
    }

    @Override
    public List<Answer> getAllAnswersByQuestionId(long questionId) {

        return answerDAO.getAllAnswersByQuestionId(questionId);
    }

    @Override
    public void remove(long id) {
        answerDAO.remove(id);
    }

    @Override
    public void removeAllAnswersByQuestionId(long questionId) {
        answerDAO.removeAllAnswersByQuestionId(questionId);
    }

    @Override
    public void updateAnswerById(long id, String text, Boolean isRight) {
        answerDAO.updateAnswerById(id, text, isRight);
    }
}
