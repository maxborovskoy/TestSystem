package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class ConnectionPool {
    private static final ResourceBundle RESOURCE = ResourceBundle.getBundle("sql_queries");
    private static final String H2_URL = RESOURCE.getString("h2.url");
    private static final String H2_USER = RESOURCE.getString("h2.user");
    private static final String H2_PASS = RESOURCE.getString("h2.password");
    private static final int MAX_CONNECTION = Integer.parseInt(RESOURCE.getString("h2.maxConnection"));
    private Deque<Connection> freeConnections;
    private static ConnectionPool instancePool;



    private ConnectionPool() {
        freeConnections = new LinkedList<>();
    }

    public static ConnectionPool getInstance() throws SQLException {
        if (instancePool == null) {
            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            instancePool = new ConnectionPool();
            for (int i = 0; i < MAX_CONNECTION; i++) {
                instancePool.freeConnections.add(DriverManager.getConnection(H2_URL, H2_USER, H2_PASS));
            }
        }
        return instancePool;
    }

    public Connection getConnection() {
        if (freeConnections.isEmpty()) {
            try {
                for (int i = 0; i < MAX_CONNECTION; i++) {
                    instancePool.freeConnections.add(DriverManager.getConnection(H2_URL, H2_USER, H2_PASS));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return freeConnections.pollLast();
    }

    public static void freeConnection(Connection con) throws SQLException{
        if (con != null && !con.isClosed()) {
            ConnectionPool pool = ConnectionPool.getInstance();
            pool.freeConnections.add(con);
        }
    }
}