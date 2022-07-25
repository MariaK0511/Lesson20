package homework20;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsService extends StudentsConnection implements StudentsDAO {
    Connection connection;

    {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ;


    @Override
    public void add(Students students) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO myTable (id,name,country,city) VALUES (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, students.getId());
            preparedStatement.setString(2, students.getName());
            preparedStatement.setString(3, students.getCountry());
            preparedStatement.setString(4, students.getCity());
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

    @Override
    public List<Students> getAll() throws SQLException { //this method return all students from the table
        List<Students> studentsList = new ArrayList<>();
        String sql = "SELECT ID, NAME, COUNTRY, CITY FROM myTable";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Students students = new Students();
            students.setId(resultSet.getLong("ID"));
            students.setName(resultSet.getString("NAME"));
            students.setCountry(resultSet.getString("COUNTRY"));
            students.setCity(resultSet.getString("CITY"));
            studentsList.add(students);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
        return studentsList;
    }

    @Override
    public Students getById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID, NAME, COUNTRY, CITY FROM myTable WHERE ID=?";
        Students students = new Students();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
                students.setId(resultSet.getLong("ID"));
                students.setName(resultSet.getString("NAME"));
                students.setCountry(resultSet.getString("COUNTRY"));
                students.setCity(resultSet.getString("CITY"));
                preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return students;
    }

    @Override
    public void update(Students students) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE ADDRESS SET NAME=?, COUNTRY=?, CITY=?  WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, students.getName());
            preparedStatement.setString(2, students.getCountry());
            preparedStatement.setString(3, students.getCity());
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

    @Override
    public void remove(Students students) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM STUDENTS WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, students.getId());
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
}
