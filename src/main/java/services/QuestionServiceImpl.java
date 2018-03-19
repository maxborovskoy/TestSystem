package services;

import dao.QuestionDAO;
import entity.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private QuestionDAO questionDAO = new QuestionDAO();

    @Override
    public void add(String text, long testId) {
        List<Answer> answers = null;
        Question question = new Question(text, answers, testId);
        questionDAO.add(question);
    }

    @Override
    public void remove(long id) {
        questionDAO.remove(id);
        new AnswerServiceImpl().removeAllAnswersByQuestionId(id);
    }

    @Override
    public void update(long id, String text, long testId) {
        Question result = new Question(id, text, (questionDAO.get(id)).answers, testId);
        questionDAO.remove(id);
        questionDAO.add(result);
    }

    @Override
    public void removeAllQuestionsByTestId(long testId) {
        List<Question> questionList = questionDAO.getAllQuestionsByTestId();
        for (Question question : questionList) {
            remove(question.getId());
        }
    }

    @Override
    public List<Question> getAllQuestionsByTestId(long testId) {
        return questionDAO.getAllQuestionsByTestId(testId);
    }


    // we already have this in Dao?
    @Override
    public Question getQuestion(long id) {
        Question question = questionDAO.get(id);
        question.setAnswers(new AnswerServiceImpl().getAnswersByQuestionId(id));
        return question;
    }


}
