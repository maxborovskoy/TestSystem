package dao;

import org.apache.tomcat.jdbc.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractController <E, K> {
    protected Connection connection = null;

    public abstract void add(E entity);
    public abstract E get(K id);
    public abstract List<E> getAll();
    public abstract void remove(K id);

    public PreparedStatement getPrepareStatement(String sql) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new Exception("ps getting error ", e);
        }

        return ps;
    }

    // Закрытие PrepareStatement
    public void closePrepareStatement(PreparedStatement ps) throws Exception {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new Exception("ps closing error ", e);
            }
        }
    }

}
