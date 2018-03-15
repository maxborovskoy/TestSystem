package dao;

import controllers.ConnectionPool;
import entity.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO extends AbstractDAO<Question, Long> {

    @Override
    public void add(Question question) {

        Connection con;
        PreparedStatement st = null;
        try{
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("ADD_QUESTION"));
            st.setLong(1, question.getId()); // Where do we get this?
            st.setString(2, question.getText());
            st.setLong(3, question.getIdTest());
            st.executeUpdate();

            con.close();
            pool.freeConnection(con);
            pool.release();
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
    public Question get(Long id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Question q;
        try{
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("GET_QUESTION"));
            st.setLong(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                q = new Question();
                q.setId(rs.getLong("id"));
                q.setText(rs.getString("text"));
                q.setIdTest(rs.getLong("idTest"));
                // How to deal with list of answers?

                return q;
            } else {
                return null;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if(con != null) con.close();
                pool.freeConnection(con);
                pool.release();
                if(st != null) st.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Question> getAll() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Question> questionList = new ArrayList<>();

        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("GET_ALL_QUESTIONS"));
            rs = st.executeQuery();

            while (rs.next()) {
                Question q = new Question();
                q.setId(rs.getLong("id"));
                q.setText(rs.getString("text"));
                q.setIdTest(rs.getLong("idTest"));

                questionList.add(q);
            }

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(con != null) con.close();
                pool.freeConnection(con);
                pool.release();
                if(st != null) st.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return questionList;
    }

    @Override
    public void remove(Long id) {
        Connection con;
        PreparedStatement st = null;
        try{
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("REMOVE_QUESTION"));
            st.setLong(1, id);
            st.executeUpdate();

            con.close();
            pool.freeConnection(con);
            pool.release();
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

    public List<Question> getAllQuestionsByTestId(Long TestId){
        Connection con;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Question> questionList = new ArrayList<>();
        try{
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("GET_ALL_QUESTIONS_BY_TEST_ID"));
            st.setLong(3, TestId);
            rs = st.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getLong("Id"));
                question.setText(rs.getString("Text"));
                question.setIdTest(rs.getLong("TextId"));

                questionList.add(question);
            }
            con.close();
            pool.freeConnection(con);
            pool.release();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(st != null) st.close();
                if(rs != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return questionList;
    }
}
