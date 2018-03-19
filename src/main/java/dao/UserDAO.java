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
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("ADD_USER"));
            st.setLong(1, entity.getId()); // Where do we get this?
            st.setString(2, entity.getName());
            st.setString(3, entity.getPassword());
            st.setBoolean(4, entity.getTutor());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (st != null)
                    st.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User get(Long id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        User a = null;
        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("GET_USER"));
            st.setLong(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                a = new User();
                a.setId(rs.getLong("id"));
                a.setName(rs.getString("name"));
                a.setPassword(rs.getString("pass"));
                a.setTutor(rs.getBoolean("isTutor"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (st != null)
                    st.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return a;
    }

    @Override
    public List<User> getAll() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();

        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("GET_ALL_USERS"));
            rs = st.executeQuery();

            while (rs.next()) {
                User a = new User();
                a.setId(rs.getLong("id"));
                a.setName(rs.getString("name"));
                a.setPassword(rs.getString("pass"));
                a.setTutor(rs.getBoolean("isTutor"));
                userList.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (st != null)
                    st.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public void remove(Long id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = pool.getConnection();
            st = con.prepareStatement(sqlQueries.getString("REMOVE_USER"));
            st.setLong(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (st != null)
                    st.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
