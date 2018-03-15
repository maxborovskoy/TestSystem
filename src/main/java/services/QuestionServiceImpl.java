package services;

import dao.QuestionDAO;

public class QuestionServiceImpl implements QuestionService {
    private QuestionDAO questionDAO = new QuestionDAO();
    @Override
    public void add(Question question) {
        questionDAO.add(question);
    }

    @Override
    public void remove(Long id) {
        questionDAO.remove(id);
        new AnswerServiceImpl().removeAllAnswersByQuestionId(id);
    }

    @Override
    public void removeAllQuestionsByTestId(Long testId) {
        List<Question> questionList = questionDAO.getAllQuestionsByTestId();
        for(Question question : questionList) {
            remove(question.getId());
        }
    }

    @Override
    public List<Question> getQuestionsByTestId(Long testId) {
        return questionDAO.getAllQuestionsByTestId(testId);
    }

    @Override
    public Question getQuestion(Long id) {
        Question question = questionDAO.get(Long id);
        question.setAnswers(new AnswerServiceImpl().getAnswersByQuestionId(id));
        return question;
    }


}
