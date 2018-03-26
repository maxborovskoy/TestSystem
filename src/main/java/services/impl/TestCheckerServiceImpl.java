package services.impl;

import entity.Answer;
import entity.Question;
import entity.Test;
import entity.TestResult;
import services.api.TestCheckerService;

import java.util.List;
import java.util.Map;

public class TestCheckerServiceImpl implements TestCheckerService {

    @Override
    public TestResult CheckTest(Test test, Map<Long, List<Long>> answers) {
        TestResult result = new TestResult();
        if (test != null && answers != null) {
            int correctAnswers = 0;
            for (Question q : test.getQuest()) {
                if (answers.containsKey(q.getId())) {
                    List<Long> answerIds = answers.get(q.getId());
                    if (CheckQuestion(q, answerIds))
                        correctAnswers++;
                } else if (noCorrectAnswers(q)){
                    correctAnswers++;
                }
            }

            result.setCountAnswers(test.getQuest().size());
            result.setCorrectAnswers(correctAnswers);
            result.setScore(correctAnswers * 100 / test.getQuest().size());
        }
        return result;
    }

    private boolean noCorrectAnswers(Question question) {
        for(Answer answer : question.getAnswers()){
            if(answer.getRight()){
                return false;
            }
        }
        return true;
    }

    private boolean CheckQuestion(Question q, List<Long> answerIds) {
        boolean isCorrect = true;
        for (Answer a : q.getAnswers()) {
            boolean isChecked = answerIds.contains(a.getId());
            if (a.getRight() && !isChecked || !a.getRight() && isChecked) {
                isCorrect = false;
                break;
            }
        }
        return isCorrect;
    }
}