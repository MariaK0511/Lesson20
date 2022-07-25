package homework20;

import java.sql.*;


public class StudentsConnection {

    String host = "127.0.0.1";
    String post = "5432";
    String base = "postgres";
    String user = "postgres";
    String pass = "root";
    String url = "jdbc:postgresql://" + host + ":" + post + "/" + base;


    public Statement getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, pass);
        assert connection != null : "connection is null";

        return connection.createStatement();
    }

}
