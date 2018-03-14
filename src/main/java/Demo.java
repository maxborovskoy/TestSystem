import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {


    public static void main(String[] args) {

//        try {
//            Class.forName("org.h2.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        try (
            Connection connection = DriverManager.getConnection("jdbc:h2:~/labmarch", "root", "root");
            Statement statement = connection.createStatement();
        ) {
            statement.execute("CREATE TABLE IF NOT EXISTS users (id BIGINT NOT NULL PRIMARY KEY,\n"
                + "                    name VARCHAR(100),\n"
                + "                    pass VARCHAR(100),\n"
                + "                    isAdmin BOOLEAN);\n");


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (
            Connection connection = DriverManager.getConnection("jdbc:h2:~/labmarch", "root", "root");
            Statement statement = connection.createStatement();
        ) {
            statement.execute("INSERT INTO users VALUES (3, 'Ramesh', 'root', TRUE ); ");


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (
            Connection connection = DriverManager.getConnection("jdbc:h2:~/labmarch", "root", "root");
            Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            StringBuilder builder = new StringBuilder();
            while (resultSet.next()) {
                builder.append(resultSet.getInt("id"))
                    .append(" ")
                    .append(resultSet.getString("name"))
                    .append(" ")
                    .append(resultSet.getString("pass"))
                    .append(" ")
                    .append(resultSet.getBoolean("isAdmin"))
                    .append("\n");
            }

            System.out.println(builder.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
