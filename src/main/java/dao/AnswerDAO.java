package dao;

import controllers.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAO extends AbstractDAO<Answer, Long> {


    @Override
    public void add(Answer answer) {
        Connection con;
        PreparedStatement st = null;
        try{
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("ADD_ANSWER"));
            st.setLong(1, answer.getId()); // Where do we get this?
            st.setString(2, answer.getText());
            st.setBoolean(3, answer.getRight());
            st.setLong(4, answer.getQuestionId());
            st.executeUpdate();

            con.close();
        }catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            try {
                if(st != null) st.close();
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
        Answer a;
        try{
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("GET_ANSWER"));
            st.setLong(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                a = new Answer();
                a.setId(rs.getLong("id"));
                a.setText(rs.getString("text"));
                a.setRight(rs.getBoolean("isRight"));
                a.setQuestionId(rs.getLong("questionId"));

                return a;
            } else {
                return null;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if(con != null) con.close();
                if(st != null) st.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Answer> getAll() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Answer> answerList = new ArrayList<>();

        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("GET_ALL_ANSWERS"));
            rs = st.executeQuery();

            while (rs.next()) {
                Answer a = new Answer();
                a.setId(rs.getLong("id"));
                a.setText(rs.getString("text"));
                a.setRight(rs.getBoolean("isRight"));
                a.setQuestionId(rs.getLong("questionId"));

                answerList.add(a);
            }

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(con != null) con.close();
                if(st != null) st.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return answerList;
    }

    @Override
    public void remove(Long id) {
        Connection con;
        PreparedStatement st = null;
        try{
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("REMOVE_ANSWER"));
            st.setLong(1, id);
            st.executeUpdate();

            con.close();
        }catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            try {
                if(st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Answer> getAllAnswersByQuestionId(Long questionId) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        List<Answer> answerList = new ArrayList<>();
        try{
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("GET_ALL_ANSWERS_BY_QUESTION_ID"));
            st.setLong(4, questionId);
            rs = st.executeQuery();

            while (rs.next()) {
                Answer a = new Answer();
                a.setId(rs.getLong("id"));
                a.setText(rs.getString("text"));
                a.setRight(rs.getBoolean("isRight"));
                a.setQuestionId(rs.getLong("questionId"));
                answerList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (con != null) con.close();
                if (st != null) st.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return answerList;
    }

    public void removeAllAnswersByQuestionId(Long questionId){
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("REMOVE_ALL_ANSWERS_BY_QUESTION_ID"));
            st.setLong(4, questionId);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (con != null) con.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
