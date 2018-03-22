package config;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class InitDB extends HttpServlet {

    private final static Logger log = LogManager.getLogger(InitDB.class);

    @Override
    public void init() throws ServletException {
        super.init();
        Statement st = null;
        Connection con = null;
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            con = pool.getConnection();
            ResourceBundle res = ResourceBundle.getBundle("sql_queries");
            String[] sqls = {res.getString("h2.create.user"),
                    res.getString("h2.create.test"),
                    res.getString("h2.create.question"),
                    res.getString("h2.create.answer")};
            st = con.createStatement();
            for (String sql : sqls) {
                st.executeUpdate(sql);
            }
            log.info("Database successfully initialized");
        } catch (SQLException e) {
            log.error("Database didn't initialize", e);
            throw new RuntimeException(e);
        } finally {
            try {
                if (st != null)
                    st.close();
                if (con != null)
                    ConnectionPool.freeConnection(con);
            } catch (SQLException e) {
                log.error("Database didn't initialize", e);
            }
        }
    }
}
