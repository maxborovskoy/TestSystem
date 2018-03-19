package dao;

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
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("ADD_ANSWER"));
            st.setString(1, answer.getText());
            st.setBoolean(2, answer.getRight());
            st.setLong(3, answer.getQuestionId());
            st.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                pool.freeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Answer get(Long id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("GET_ANSWER"));
            st.setLong(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                String text = rs.getString("text");
                boolean isRight = rs.getBoolean("isRight");
                long questionId = rs.getLong("questionId");
                Answer a = new Answer(text, isRight, questionId);
                a.setId(id);
                return a;
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
                    pool.freeConnection(con);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Answer> getAllAnswersByQuestionId(Long questionId) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Answer> answerList = new ArrayList<>();
        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("GET_ALL_ANSWERS_BY_QUESTION_ID"));
            st.setLong(1, questionId);
            rs = st.executeQuery();

            while (rs.next()) {
                long id = rs.getLong("id");
                String text = rs.getString("text");
                boolean isRight = rs.getBoolean("isRight");
                Answer a = new Answer(text, isRight, questionId);
                a.setId(id);
                answerList.add(a);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        } finally  {
            if (rs != null) {
                try {
                    rs.close();
                    pool.freeConnection(con);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return answerList;
    }

    @Override
    public void remove(Long id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("REMOVE_ANSWER"));
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                pool.freeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeAllAnswersByQuestionId(Long questionId) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("REMOVE_ALL_ANSWERS_BY_QUESTION_ID"));
            st.setLong(1, questionId);
            st.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
    } finally {
        try {
            pool.freeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

    public void updateAnswerById(long id, String text, Boolean isRight) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("UPDATE_ANSWER_BY_ID"));
            st.setString(1, text);
            st.setBoolean(2, isRight);
            st.setLong(3, id);
            st.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                pool.freeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
