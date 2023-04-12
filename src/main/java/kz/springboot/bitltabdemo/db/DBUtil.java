package kz.springboot.bitltabdemo.db;

import kz.springboot.bitltabdemo.models.Student;

import java.util.ArrayList;

public class DBUtil {

    private static ArrayList<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L, "Tanat", "Kural", 90, "A"));
        students.add(new Student(2L, "Mark", "Dixon", 38, "F"));
        students.add(new Student(3L, "John", "Wick", 68, "C"));
        students.add(new Student(4L, "Irina", "Shayk", 88, "B"));

    }

    private static Long id = 5L;

    public static ArrayList<Student> getItems() {
        return students;
    }

    public static void addItem(Student student) {
        student.setId(id);
        students.add(student);
        id++;
    }
}
