package dao;

import config.ConnectionPool;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<User, Long> {
    @Override
    public void add(User entity) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("ADD_USER"));
        ) {
            setSQLParameters(entity, st);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            freeCon(con);
        }
    }

    @Override
    public User get(Long id) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_USER"));
        ) {
            st.setLong(1, id);
            try (
                    ResultSet rs = st.executeQuery()
            ) {
                if (rs.next()) {
                    return getUserById(id, rs);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            freeCon(con);
        }
        return null;
    }

    public List<User> getAll() {

        Connection con = pool.getConnection();
        List<User> userList = new ArrayList<>();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ALL_USERS"));
        ) {
            try (
                    ResultSet rs = st.executeQuery()
            ) {
                while (rs.next()) {
                    User user = getUserById(rs.getLong("id"), rs);
                    userList.add(user);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            freeCon(con);
        }
        return userList;
    }

    @Override
    public void remove(Long id) {

        Connection con = pool.getConnection();

        try (
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("REMOVE_USER"));
        ) {
            st.setLong(1, id);
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

    private void setSQLParameters(User entity, PreparedStatement st) throws SQLException {
        st.setString(1, entity.getName());
        st.setString(2, entity.getPassword());
        st.setBoolean(3, entity.getTutor());
    }

    private User getUserById(Long id, ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String pass = rs.getString("pass");
        boolean tutor = rs.getBoolean("isTutor");
        User user = new User(name, pass, tutor);
        user.setId(id);
        return user;
    }
}
