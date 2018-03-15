package dao;


import controllers.ConnectionPool;

import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

public abstract class AbstractDAO<E, K> {
    protected Connection connection;
    ResourceBundle sqlQueries = ResourceBundle.getBundle("sql_queries_dao");
    ConnectionPool pool = ConnectionPool.getInstance("jdbc:h2:~/labmarch", "root", "root", 5);;

    public abstract void add(E entity);
    public abstract E get(K id);
    public abstract List<E> getAll();
    public abstract void remove(K id);

}
