package homework20;

import java.sql.SQLException;
import java.util.List;

public interface StudentsDAO {
    //create
    void add(Students students) throws SQLException;
    //read
    List<Students>getAll() throws SQLException;
    Students getById(long id) throws SQLException;
    //update
    void update(Students students) throws SQLException;
    //delete
    void remove(Students students) throws SQLException;
}
