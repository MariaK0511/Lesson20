package homework20;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsFunctions extends StudentsConnection {
    Connection connection;

    {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Students> getAll() { //this method return all students from the table
        List<Students> studentsList = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Students students = new Students();
                students.setId(resultSet.getLong("id"));
                students.setName(resultSet.getString("name"));
                students.setCountry(resultSet.getString("country"));
                students.setCity(resultSet.getString("city"));
                studentsList.add(students);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    public List<Students> getById(long id) {
        List<Students> studentsList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID, NAME, COUNTRY, CITY FROM students WHERE ID=?";
        //   Students students = new Students();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Students students = new Students();
                students.setId(resultSet.getLong("id"));
                students.setName(resultSet.getString("name"));
                students.setCountry(resultSet.getString("country"));
                students.setCity(resultSet.getString("city"));
                studentsList.add(students);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    public void add(Students students) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO students (id,name,country,city) VALUES (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, students.getId());
            preparedStatement.setString(2, students.getName());
            preparedStatement.setString(3, students.getCountry());
            preparedStatement.setString(4, students.getCity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeByName(Students students) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM students WHERE NAME=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, students.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeByCity(Students students) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM students WHERE CITY=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, students.getCity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }


//    public void update(Students students) throws SQLException {
//        PreparedStatement preparedStatement = null;
//        String sql = "UPDATE ADDRESS SET NAME=?, COUNTRY=?, CITY=?  WHERE ID=?";
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, students.getName());
//            preparedStatement.setString(2, students.getCountry());
//            preparedStatement.setString(3, students.getCity());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (preparedStatement != null) {
//                preparedStatement.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        }
//    }

}
