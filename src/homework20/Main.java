package homework20;

import jdk.jshell.execution.Util;
import org.postgresql.core.Utils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        Создать таблицу с городами, где живут студенты.
        Вывести информацию о каждом студенте группы и его родном городе.
        Предусмотреть операции добавления новых городов, новых студентов,
        удаления студентов и удаления городов.
         */
        StudentsConnection studentsConnection = new StudentsConnection();
        StudentsService studentsService = new StudentsService();
        String user ="postgres";
        String password = "root";

        try {
            Statement statement = studentsService.getAll();
            List<Students> studentsList = new ArrayList<>();
            for (Students s : studentsList) {
                System.out.println(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
