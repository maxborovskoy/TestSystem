package dao;

import config.ConnectionPool;
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

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("ADD_TEST"));
        ) {
            setSQLParameters(test, st);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            freeCon(con);
        }
    }

    @Override
    public Test get(Long id) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_TEST"))
        ) {
            st.setLong(1, id);
            try (
                    ResultSet rs = st.executeQuery()
            ) {
                if (rs.next()) {
                    return getTestById(id, rs);
                } else {
                    return null;
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            freeCon(con);
        }
    }

    public List<Test> getAll() {

        Connection con = pool.getConnection();
        List<Test> testList = new ArrayList<>();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ALL_TESTS"));
                ResultSet rs = st.executeQuery()
        ) {
            while (rs.next()) {
                long testId = rs.getLong("id");
                Test test = getTestById(testId, rs);
                testList.add(test);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            freeCon(con);
        }
        return testList;
    }

    @Override
    public void remove(Long id) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("REMOVE_TEST"))
        ) {
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            freeCon(con);
        }
    }

    public void update(Test test) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("UPDATE_TEST"))
        ) {
            setSQLParameters(test, st);
            st.setLong(3, test.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    private void setSQLParameters(Test test, PreparedStatement st) throws SQLException {
        st.setString(1, test.getName());
        st.setString(2, test.getType().getName());
    }

    private Test getTestById(Long id, ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        TestTypes type = TestTypes.getType(rs.getString("type"));

        QuestionDAO help = new QuestionDAO();
        List<Question> questionList = help.getAllQuestionsByTestId(id);

        Test test = new Test(name, questionList, type);
        test.setId(id);
        return test;
    }
}