package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ConnectionPool {
    private static final ResourceBundle RESOURCE = ResourceBundle.getBundle("sql_queries");
    private static final String H2_URL = RESOURCE.getString("h2.url");
    private static final String H2_USER = RESOURCE.getString("h2.user");
    private static final String H2_PASS = RESOURCE.getString("h2.password");
    private static final int MAX_CONNECTION = Integer.parseInt(RESOURCE.getString("h2.maxConnection"));
    private List<Connection> freeConnections;
    private static ConnectionPool instancePool;



    private ConnectionPool() {
        freeConnections = new ArrayList<>();
    }

    public static ConnectionPool getInstance() throws SQLException {
        if (instancePool == null) {
            instancePool = new ConnectionPool();
            for (int i = 0; i < MAX_CONNECTION; i++) {
                instancePool.freeConnections.add(DriverManager.getConnection(H2_URL, H2_USER, H2_PASS));
            }
        }
        return instancePool;
    }

    public Connection getConnection() {
        Connection con = freeConnections.remove(freeConnections.size() - 1);
        return con;
    }
}