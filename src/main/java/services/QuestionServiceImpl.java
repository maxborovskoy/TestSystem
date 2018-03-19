package services;

import dao.QuestionDAO;
import entity.Answer;
import entity.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private QuestionDAO questionDAO = new QuestionDAO();

    @Override
    public void add(Question question) {
        questionDAO.add(question);
        AnswerService answerService = new AnswerServiceImpl();
        for (Answer a : question.getAnswers()) {
            answerService.add(a);
        }
    }

    @Override
    public Question get(long id) {
        return questionDAO.get(id);
    }

    @Override
    public List<Question> getAllQuestionsByTestId(long testId) {
        return questionDAO.getAllQuestionsByTestId(testId);
    }

    @Override
    public void remove(long id) {
        questionDAO.remove(id);
        new AnswerServiceImpl().removeAllAnswersByQuestionId(id);
    }

    @Override
    public void removeAllQuestionsByTestId(long testId) {
        List<Question> questionList = questionDAO.getAllQuestionsByTestId(testId);
        for (Question question : questionList) {
            remove(question.getId());
        }
    }

    @Override
    public Boolean updateText(String text, Question question) {
        List<Question> questionList = getAllQuestionsByTestId(question.getTestId());
        for (Question q: questionList) {
            if (q.getText().equals(text)) return false;
            }

        questionDAO.updateTextById(question.getId(), text);
        return true;
    }


}
