package homework20;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentsConnection {
    static final String host = "127.0.0.1";
    static final String post = "5432";
    static final String base = "postgres";
    static final String user = "postgres";
    static final String pass = "root";
    String url = "jdbc:postgresql://" + host + ":" + post + "/" + base;
    Connection connection = null;
    Statement statement = null;

    public Connection getConnection() throws SQLException {
        System.out.println("connecting to database.. ");
        connection = DriverManager.getConnection(url, user, pass);
        if (connection != null) {
            System.out.println("connection ok");
        } else {
            System.out.println("connection failed");
        }
        System.out.println("executing sql query...");
        statement = connection.createStatement();
        return connection;
    }
}
