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
    public Boolean updateAnswer(Answer answer, String text, Boolean isRight) {
        Boolean hasRight = isRight;
        List<Answer> answerList = getAllAnswersByQuestionId(answer.getQuestionId());
        for (Answer a: answerList) {
            if (a.getText().equals(text) && a.getId() != answer.getId()) return false;
            if (a.getRight()) hasRight = true;
        }
        answerDAO.updateAnswerById(answer.getId(), text, isRight);
        return hasRight;
    }
}
