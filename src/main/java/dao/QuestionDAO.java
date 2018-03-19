package dao;

import config.ConnectionPool;
import entity.Answer;
import entity.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO extends AbstractDAO<Question, Long> {

    @Override
    public void add(Question question) {
        Connection con = pool.getConnection();
        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("ADD_QUESTION"));
        ) {

            st.setString(2, question.getText());
            st.setLong(3, question.getTestId());
            st.executeUpdate();
            ConnectionPool.freeConnection(con);
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Question get(Long id) {
        ResultSet rs = null;
        Connection con = pool.getConnection();
        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_QUESTION"));
        ) {
            st.setLong(1, id);
            rs = st.executeQuery();
            List<Answer> answers = new ArrayList<>();
            if (rs.next()) {
                String text = rs.getString("questions.text");
                long testId = rs.getLong("questions.testId");
                do {
                    long answerId = rs.getLong("answers.id");
                    String answerText = rs.getString("answers.text");
                    boolean isRight = rs.getBoolean("answers.isRight");
                    Answer a = new Answer(answerText, isRight, id);
                    a.setId(answerId);
                    answers.add(a);
                } while (rs.next());

                Question q = new Question(text, answers, testId);
                q.setId(id);
                ConnectionPool.freeConnection(con);
                return q;
            } else {
                ConnectionPool.freeConnection(con);
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

    public List<Question> getAllQuestionsByTestId(Long testId) {
        ResultSet rs = null;
        List<Question> questionList = new ArrayList<>();
        Connection con = pool.getConnection();
        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ALL_QUESTIONS_BY_TEST_ID"));
        ) {
            st.setLong(3, testId);
            rs = st.executeQuery();
            while (rs.next()) {
                questionList.add(get(rs.getLong("Id")));
            }
            ConnectionPool.freeConnection(con);
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

    @Override
    public void remove(Long id) {
        Connection con = pool.getConnection();
        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("REMOVE_QUESTION"));
        ) {
            st.setLong(1, id);
            st.executeUpdate();
            ConnectionPool.freeConnection(con);
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public void updateTextById(long id, String text) {
        Connection con = pool.getConnection();
        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("UPDATE_QUESTION_BY_ID"));
        ) {
            st.setString(1, text);
            st.setLong(2, id);
            st.executeUpdate();
            ConnectionPool.freeConnection(con);
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
