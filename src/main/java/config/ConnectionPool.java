package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ConnectionPool {
    private List<Connection> freeConnections;
    private static ConnectionPool instancePool;

    private ConnectionPool() {
        freeConnections = new ArrayList<>();
    }

    public static ConnectionPool getInstance() throws SQLException {
        if (instancePool == null) {
            instancePool = new ConnectionPool();
            ResourceBundle resource = ResourceBundle.getBundle("sql_queries");
            String url = resource.getString("h2.url");
            String user = resource.getString("h2.user");
            String password = resource.getString("h2.password");
            int maxConn = Integer.parseInt(resource.getString("h2.maxConnection"));
            for (int i = 0; i < maxConn; i++) {
                instancePool.freeConnections.add(DriverManager.getConnection(url, user, password));
            }
        }
        return instancePool;
    }

    public Connection getConnection() {
        Connection con = freeConnections.get(freeConnections.size() - 1);
        freeConnections.remove(con);
        return con;
    }
}