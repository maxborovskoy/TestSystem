package services;

import dao.QuestionDAO;

public class QuestionServiceImpl implements QuestionService {
    private QuestionDAO questionDAO = new QuestionDAO();
    @Override
    public void add(Question question) {
        questionDAO.add(question);
    }

    @Override
    public void remove(Long questionId) {
        questionDAO.remove(questionId);
        new AnswerServiceImpl().removeAllAnswersByQuestionId(questionId);
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
    public Question getQuestion(Long questionId) {
        Question question = questionDAO.get(questionId);
        question.setAnswers(new AnswerServiceImpl().getAnswersByQuestionId(questionId));
        return question;
    }


}
