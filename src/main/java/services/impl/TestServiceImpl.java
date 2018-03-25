package services.impl;

import dao.TestDAO;
import entity.Answer;
import entity.Question;
import entity.Test;
import services.api.TestService;

import java.util.List;

public class TestServiceImpl implements TestService {

    private TestDAO testDAO = new TestDAO();

    @Override
    public Test addTest(Test test) {
        test.setQuest(new QuestionServiceImpl().getAllQuestionsByTestId(test.getId()));
        return testDAO.add(test);
    }

    @Override
    public Test getTest(Long id) {
        Test test = testDAO.get(id);
        test.setQuest(new QuestionServiceImpl().getAllQuestionsByTestId(id));
        return test;
    }

    @Override
    public List<Test> getAllTests() {
        return testDAO.getAll();
    }

    @Override
    public List<Test> getAllTestsByTheme(String theme) {
        return testDAO.getAllByTheme(theme);
    }

    @Override
    public void removeTest(Long id) {
        testDAO.remove(id);
        new QuestionServiceImpl().removeAllQuestionsByTestId(id);
    }

    @Override
    public void updateTest(Test test) {
        testDAO.update(test);
    }

    @Override
    public CreationStatus addTestFromForm(Test test) {
        if (testDAO.getTestsIdByNameAndType(test.getName(), test.getType()) != -1) {
            return CreationStatus.TEST_EXISTS;
        } else {
            if (test.getName().isEmpty()) {
                return CreationStatus.TEST_NO_NAME;
            }
            if (test.getQuest().isEmpty()) {
                return CreationStatus.EMPTY_QUESTIONS;
            }
            QuestionServiceImpl questionService = new QuestionServiceImpl();
            AnswerServiceImpl answerService = new AnswerServiceImpl();
            Test testWithId = testDAO.add(test);
            for (Question quest : test.getQuest()) {
                if (questionService.getQuestionsIdByTextAndTestId(quest.getText(), testWithId.getId()) != -1) {
                    testDAO.remove(testWithId.getId());
                    return CreationStatus.QUESTION_EXISTS;
                } else {
                    if (quest.getText().isEmpty()) {
                        testDAO.remove(testWithId.getId());
                        return CreationStatus.QUESTION_NO_TEXT;
                    }
                    if (quest.getAnswers().isEmpty()) {
                        testDAO.remove(testWithId.getId());
                        return CreationStatus.QUESTION_NO_ANSWERS;
                    }
                    quest.setTestId(testWithId.getId());
                    Question questionWithId = questionService.addEmptyQuestion(quest);
                    for (Answer answer : quest.getAnswers()) {
                        if (answerService.getAnswerByTextAndQuestionId(answer.getText(), questionWithId.getId()) != -1) {
                            testDAO.remove(testWithId.getId());
                            return CreationStatus.ANSWER_EXISTS;
                        } else {
                            if (answer.getText().isEmpty()) {
                                testDAO.remove(testWithId.getId());
                                return CreationStatus.ANSWER_NO_TEXT;
                            }
                            answer.setQuestionId(questionWithId.getId());
                            answerService.add(answer);
                        }
                    }
                }
            }
            return CreationStatus.OK;
        }
    }

    @Override
    public String editThroughForm(Test test) {
        // TODO: edit service
        String checkResult = checkTest(test);

        if (checkResult.equals("OK")) {
            Long testId = test.getId();
            AnswerServiceImpl answerService = new AnswerServiceImpl();
            QuestionServiceImpl questionService = new QuestionServiceImpl();

            questionService.removeAllQuestionsByTestId(testId);
            for (Question quest : test.getQuest()) {
                quest.setTestId(testId);
                Question questionWithId = questionService.addEmptyQuestion(quest);
                for (Answer answer : quest.getAnswers()) {
                    answer.setQuestionId(questionWithId.getId());
                    answerService.add(answer);
                }
            }
        }
        return checkResult;


    }

    private String checkTest(Test test) {
        if(test.getName().isEmpty()){
            return "EMPTY_NAME";
        }
        if(test.getQuest().isEmpty()){
            return "EMPTY_QUESTIONS";
        }

        for (Question quest : test.getQuest()) {
                if(quest.getText().isEmpty()){
                    return "QUESTION_NO_TEXT";
                }
                for (Answer answer : quest.getAnswers()) {
                    if(answer.getText().isEmpty()) {
                        return "ANSWER_NO_TEXT";
                    }
                }
        }
        return "OK";
    }

}
