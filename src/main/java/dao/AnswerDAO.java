package dao;

import config.ConnectionPool;
import entity.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAO extends AbstractDAO<Answer, Long> {


    @Override
    public void add(Answer answer) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("ADD_ANSWER"));
        ) {
            setSQLParameters(answer, st);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            freeCon(con);
        }
    }

    @Override
    public Answer getById(Long id) {

        Connection con = pool.getConnection();

        try (PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ANSWER"))) {
            st.setLong(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return getAnswerById(id, rs);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            freeCon(con);
        }
        return null;
    }

    public List<Answer> getAllAnswersByQuestionId(Long questionId) {

        Connection con = pool.getConnection();
        List<Answer> answerList = new ArrayList<>();

        try (PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ALL_ANSWERS_BY_QUESTION_ID"))) {
            st.setLong(1, questionId);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Answer a = getAnswerByQuestionId(questionId, rs);
                    answerList.add(a);
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            freeCon(con);
        }
        return answerList;
    }

    @Override
    public void removeById(Long id) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("REMOVE_ANSWER"))
        ) {
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            freeCon(con);
        }
    }

    public void removeAllAnswersByQuestionId(Long questionId) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("REMOVE_ALL_ANSWERS_BY_QUESTION_ID"))
        ) {
            st.setLong(1, questionId);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            freeCon(con);
        }
    }

    public void updateAnswerById(long id, String text, Boolean isRight) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("UPDATE_ANSWER_BY_ID"))
        ) {
            setSQLParametersForUpdate(id, text, isRight, st);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            freeCon(con);
        }
    }

    private void freeCon(Connection con) {
        try {
            ConnectionPool.freeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private void setSQLParametersForUpdate(long id, String text, Boolean isRight, PreparedStatement st) throws SQLException {
        st.setString(1, text);
        st.setBoolean(2, isRight);
        st.setLong(3, id);
    }

    private void setSQLParameters(Answer answer, PreparedStatement st) throws SQLException {
        st.setString(1, answer.getText());
        st.setBoolean(2, answer.getRight());
        st.setLong(3, answer.getQuestionId());
    }

    private Answer getAnswerById(Long id, ResultSet rs) throws SQLException {
        String text = rs.getString("text");
        boolean isRight = rs.getBoolean("isRight");
        long questionId = rs.getLong("questionId");
        Answer a = new Answer(text, isRight, questionId);
        a.setId(id);
        return a;
    }

    private Answer getAnswerByQuestionId(Long questionId, ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String text = rs.getString("text");
        boolean isRight = rs.getBoolean("isRight");
        Answer a = new Answer(text, isRight, questionId);
        a.setId(id);
        return a;
    }
}
