package dao;

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
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("ADD_USER"));
        ) {
            st.setString(1, entity.getName());
            st.setString(2, entity.getPassword());
            st.setBoolean(3, entity.getTutor());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User get(Long id) {
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_USER"));
        ) {
            st.setLong(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String pass = rs.getString("pass");
                    boolean tutor = rs.getBoolean("isTutor");
                    User user = new User(name, pass, tutor);
                    user.setId(id);
                    return user;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("GET_ALL_USERS"));
        ) {
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String pass = rs.getString("pass");
                    boolean tutor = rs.getBoolean("isTutor");
                    User user = new User(name, pass, tutor);
                    user.setId(rs.getLong("id"));
                    userList.add(user);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public void remove(Long id) {
        try (
                Connection con = pool.getConnection();
                PreparedStatement st = con.prepareStatement(sqlQueries.getString("REMOVE_USER"));
        ) {
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
