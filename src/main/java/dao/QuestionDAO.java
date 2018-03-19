package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO extends AbstractDAO<Question, Long> {

    @Override
    public void add(Question question) {
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("ADD_QUESTION"));
        ) {
            st.setString(2, question.getText());
            st.setLong(3, question.getTestId());
            st.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Question get(Long questionId) {
        ResultSet rs = null;
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_QUESTION"));
        ) {
            st.setLong(1, questionId);
            rs = st.executeQuery();
            List<Answer> answers = new ArrayList<>();
            if (rs.next()) {
                //q = new Question();
                long id = rs.getLong("questions.id");
                String text = rs.getString("questions.text");
                long testId = rs.getLong("questions.testId");
                do {
                    long answerId = rs.getLong("answers.id");
                    String answerText = rs.getString("answers.text");
                    boolean isRight = rs.getBoolean("answers.isRight");
                    answers.add(new Answer(answerId, answerText, isRight, questionId));
                } while (rs.next());

                return new Question(questionId, text, answers, testId);
            } else {
                return null;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Question> getAll() {
        List<Question> questionList = new ArrayList<>();
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ALL_QUESTIONS"));
                ResultSet rs = st.executeQuery();
        ) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String text = rs.getString("text");
                long testId = rs.getLong("testId");
                Question q = new Question();

                questionList.add(q);
            }

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }

        return questionList;
    }

    @Override
    public void remove(Long id) {
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("REMOVE_QUESTION"));
        ) {
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Question> getAllQuestionsByTestId(Long testId) {
        ResultSet rs = null;
        List<Question> questionList = new ArrayList<>();
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ALL_QUESTIONS_BY_TEST_ID"));
        ) {
            st.setLong(3, testId);
            rs = st.executeQuery();
            while (rs.next()) {
                questionList.add(get(rs.getLong("Id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return questionList;
    }
}
