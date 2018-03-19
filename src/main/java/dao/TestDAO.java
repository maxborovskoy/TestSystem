package dao;

import entity.Question;
import entity.Test;
import entity.TestTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAO extends AbstractDAO<Test, Long> {

    @Override
    public void add(Test test) {

        Connection con = null;
        PreparedStatement st = null;
        try {

            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("ADD_TEST"));
            st.setString(1, test.getName());
            st.setString(2, test.getType().getName());
            st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (st != null) st.close();
                pool.freeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Test get(Long id) {
        Connection con = null;
        ResultSet rs = null;
        try (PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_TEST"))
        ) {
            con = pool.getConnection();
            st.setLong(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                long testId = rs.getLong("id");
                String name = rs.getString("name");
                TestTypes type = TestTypes.getType(rs.getString("type"));
                List<Question> questionList = new ArrayList<>();
                Test test = new Test(name, questionList, type);
                return test;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (con != null) con.close();
                pool.freeConnection(con);
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Test> getAll() {
        Connection con = null;
        ResultSet rs = null;
        List<Test> testList = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ALL_TESTS"))) {
            con = pool.getConnection();
            rs = st.executeQuery();
            while (rs.next()) {
                long testId = rs.getLong("id");
                String name = rs.getString("name");
                TestTypes type = TestTypes.getType(rs.getString("type"));
                List<Question> questionList = new ArrayList<>();
                Test test = new Test(name, questionList, type);
                testList.add(test);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (con != null) con.close();
                pool.freeConnection(con);
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return testList;
    }

    @Override
    public void remove(Long id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("REMOVE_TEST"));
            st.setLong(1, id);
            st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (st != null) st.close();
                pool.freeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Test test) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("UPDATE_TEST"));
            st.setString(1, test.getName());
            st.setString(2, test.getType().getName());
            st.setLong(3, test.getId());
            st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (st != null) st.close();
                pool.freeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}