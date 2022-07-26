package homework20;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        /*
        Создать таблицу с городами, где живут студенты. +
        Вывести информацию о каждом студенте группы и его родном городе.
        Предусмотреть операции добавления новых городов, новых студентов,
        удаления студентов и удаления городов.
         */
        StudentsFunctions studentsFunctions = new StudentsFunctions();
        try {
            studentsFunctions.getAll().forEach(System.out::println);
            System.out.println(studentsFunctions.getById(2));

            Students students = new Students();

            students.setId(13);
            students.setName("Vika Kat");
            students.setCountry("Belarus");
            students.setCity("Brest");
            studentsFunctions.add(students);

            students.setName("Malachi Wood");
            studentsFunctions.removeByName(students);

            students.setCity("Grodno");
            studentsFunctions.removeByCity(students);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
