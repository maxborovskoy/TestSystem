package controllers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {
    private String url;
    private String user;
    private String pass;
    private int maxConn;
    private ArrayList<Connection> freeConnections = new ArrayList<>();
    private static ConnectionPool instancePool;

    private ConnectionPool(String url, String user, String pass, int maxConn) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.maxConn = maxConn;

    }

    public static synchronized ConnectionPool getInstanse(String url, String user, String pass, int maxConn){
        if (instancePool == null) {
            instancePool = new ConnectionPool(url, user, pass, maxConn);
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
            connection = DriverManager.getConnection(url, user, pass);

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


