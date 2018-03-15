package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ConnectionPool {
    private String url;
    private String user;
    private String password;
    private int maxConn;
    private ArrayList<Connection> freeConnections = new ArrayList<>();
    private static ConnectionPool instancePool;

    private ConnectionPool() {
        ResourceBundle resource = ResourceBundle.getBundle("sql_queries.properties");
        this.url = resource.getString("h2.url");
        this.user = resource.getString("h2.user");
        this.password = resource.getString("h2.password");
        this.maxConn = Integer.parseInt(resource.getString("h2.maxConn"));

    }

    public static synchronized ConnectionPool getInstance(){
        if (instancePool == null) {
            instancePool = new ConnectionPool();
        }
        return instancePool;
    }

    public synchronized Connection getConnection() {
        Connection connection;
        if (!freeConnections.isEmpty()) {
            connection = freeConnections.get(freeConnections.size() - 1);
            freeConnections.remove(connection);
            try {
                if (connection.isClosed()) {
                    connection = getConnection();
                }
            } catch (Exception ex) {
                connection = getConnection();
            }
        } else {
            connection = newConnection();
        }
        return connection;
    }

    private Connection newConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            return null;
        }
        return connection;
    }

    public synchronized void freeConnection(Connection connection) {
        if ((connection != null) && (freeConnections.size() <= maxConn)) {
            freeConnections.add(connection);
        }
    }

    public synchronized void release() {
        for (Connection con : freeConnections) {
            try {
                con.close();
            } catch (SQLException e) {}
        }
        freeConnections.clear();
    }

}


