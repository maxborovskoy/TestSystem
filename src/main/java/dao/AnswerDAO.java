package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAO extends AbstractDAO<Answer, Long> {


    @Override
    public void add(Answer answer) {
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("ADD_ANSWER"));
        ) {
            st.setString(2, answer.getText());
            st.setBoolean(3, answer.getRight());
            st.setLong(4, answer.getQuestionId());
            st.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Answer get(Long answerId) {
        ResultSet rs = null;
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ANSWER"));
        ) {
            st.setLong(1, answerId);
            rs = st.executeQuery();

            if (rs.next()) {
                long id = rs.getLong("id");
                String text = rs.getString("text");
                boolean isRight = rs.getBoolean("isRight");
                long questionId = rs.getLong("questionId");
                return new Answer(id, text, isRight, questionId);
            } else {
                return null;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Answer> getAll() {
        Answer a;
        List<Answer> answerList = new ArrayList<>();
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ALL_ANSWERS"));
                ResultSet rs = st.executeQuery();
        ) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String text = rs.getString("text");
                boolean isRight = rs.getBoolean("isRight");
                long questionId = rs.getLong("questionId");
                a = new Answer(id, text, isRight, questionId);

                answerList.add(a);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }

        return answerList;
    }

    @Override
    public void remove(Long id) {
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("REMOVE_ANSWER"));
        ) {
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Answer> getAllAnswersByQuestionId(Long questionId) {
        ResultSet rs = null;
        Answer a;
        List<Answer> answerList = new ArrayList<>();
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ALL_ANSWERS_BY_QUESTION_ID"));
        ) {
            st.setLong(4, questionId);
            rs = st.executeQuery();

            while (rs.next()) {
                long id = rs.getLong("id");
                String text = rs.getString("text");
                boolean isRight = rs.getBoolean("isRight");
                a = new Answer(id, text, isRight, questionId);
                answerList.add(a);
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
        return answerList;
    }

    public void removeAllAnswersByQuestionId(Long questionId) {
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("REMOVE_ALL_ANSWERS_BY_QUESTION_ID"));
        ) {
            st.setLong(4, questionId);
            st.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
