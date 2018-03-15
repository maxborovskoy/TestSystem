package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private String url;
    private String user;
    private String password;
    private int maxConn;
    private BlockingQueue<Connection> freeConnections;
    private static ConnectionPool instancePool;

    private ConnectionPool() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("sql_queries");
        this.url = resource.getString("h2.url");
        this.user = resource.getString("h2.user");
        this.password = resource.getString("h2.password");
        this.maxConn = Integer.parseInt(resource.getString("h2.maxConnection"));
        freeConnections = new ArrayBlockingQueue<>(maxConn);
        for (int i = 0; i < maxConn; i++) {
            freeConnections.offer(DriverManager.getConnection(url, user, password));
        }
    }

    public static ConnectionPool getInstance() throws SQLException {
        if (instancePool == null) {
            instancePool = new ConnectionPool();
        }
        return instancePool;
    }

    public static synchronized void init() throws SQLException {
        if (instancePool == null) {
            instancePool = new ConnectionPool();
        }
    }

    public static synchronized void dispose() throws SQLException{
        if (instancePool != null) {
            instancePool.clearPool();
            instancePool = null;
        }
    }

    public Connection getConnection() {
        try {
            return freeConnections.take();
        } catch (InterruptedException e) {
            return null;
        }
    }

    public void returnConnection(Connection connection) throws SQLException {
        if (!connection.isClosed()) {
            freeConnections.offer(connection);
        }
    }

    private void clearPool() throws SQLException {
        Connection connection;
        while ((connection = freeConnections.poll()) != null) {
            if (!connection.getAutoCommit()) {
                connection.commit();
            }
            connection.close();
        }
    }
}


