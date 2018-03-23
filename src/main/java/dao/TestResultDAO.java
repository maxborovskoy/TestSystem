package dao;

import config.ConnectionPool;
import entity.TestResult;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestResultDAO extends AbstractDAO<TestResult, Long> {

    private final static Logger log = LogManager.getLogger(TestResultDAO.class);
    private final static String ID = "id";
    private final static String TESTID = "testId";
    private final static String USERID = "userId";
    private final static String SCORE = "score";

    @Override
    public TestResult add(TestResult testResult) {

        if (get(testResult.getUserId(), testResult.getTestId()) != null) {
            update(testResult);
            return testResult;
        }

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("ADD_TESTRESULT"));
        ) {
            st.setLong(1, testResult.getUserId());
            st.setLong(2, testResult.getTestId());
            st.setInt(3, testResult.getScore());
            st.executeUpdate();
            log.info("TestResult " + testResult + " was added");
            return testResult;
        } catch (SQLException e) {
            log.error("TestResult " + testResult + " wasn't added", e);
            throw new RuntimeException(e);
        } finally {
            freeCon(con);
        }
    }

    @Override
    public TestResult get(Long id) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_TESTRESULT"))
        ) {
            st.setLong(1, id);
            try (
                    ResultSet rs = st.executeQuery()
            ) {
                if (rs.next()) {
                    return getTestResult(rs);
                } else {
                    return null;
                }
            } catch (SQLException e) {
                log.error("TestResult(id:" + id + ") cannot be gotten", e);
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            log.error("TestResult(id:" + id + ") cannot be gotten", e);
            throw new RuntimeException(e);
        } finally {
            freeCon(con);
        }
    }

    public TestResult get(long userId, long testId) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_TESTRESULT_BY_USER_AND_TEST"))
        ) {
            st.setLong(1, userId);
            st.setLong(2, testId);
            try (
                    ResultSet rs = st.executeQuery()
            ) {
                if (rs.next()) {
                    return getTestResult(rs);
                } else {
                    return null;
                }
            } catch (SQLException e) {
                log.error("TestResult(userId:" + userId + ";testid:" + testId + ") cannot be gotten", e);
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            log.error("TestResult(userId:" + userId + ";testid:" + testId + ") cannot be gotten", e);
            throw new RuntimeException(e);
        } finally {
            freeCon(con);
        }
    }

    public List<TestResult> getAllTestResultsByUserId(long userId) {

        Connection con = pool.getConnection();
        List<TestResult> testResultList = new ArrayList<>();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ALL_TESTRESULTS_BY_USER"));
        ) {
            st.setLong(1, userId);
            try (
                    ResultSet rs = st.executeQuery()
            ) {
                while (rs.next()) {
                    testResultList.add(getTestResult(rs));
                }
            } catch (SQLException e) {
                log.error("All test results by user cannot be gotten", e);
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            log.error("All test results by user cannot be gotten", e);
            throw new RuntimeException(e);
        } finally {
            freeCon(con);
        }
        return testResultList;
    }

    @Override
    public void remove(Long id) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("REMOVE_TESTRESULT"))
        ) {
            st.setLong(1, id);
            st.executeUpdate();
            log.info("TestResult(id:" + id + ") was removed");
        } catch (SQLException e) {
            log.error("TestResult(id:" + id + ") wasn't removed", e);
            throw new RuntimeException(e);
        } finally {
            freeCon(con);
        }
    }

    private void update(TestResult testResult) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("UPDATE_TESTRESULT"))
        ) {
            st.setLong(1, testResult.getUserId());
            st.setLong(2, testResult.getTestId());
            st.executeUpdate();
            log.info("TestResult " + testResult + " was updated");
        } catch (SQLException e) {
            log.error("TestResult " + testResult + " wasn't updated", e);
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

    private TestResult getTestResult(ResultSet rs) throws SQLException {
        TestResult testResult = new TestResult(rs.getLong(USERID), rs.getLong(TESTID), rs.getInt(SCORE));
        testResult.setId(rs.getLong(ID));
        return testResult;
    }
}