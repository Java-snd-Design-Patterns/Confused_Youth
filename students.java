package library;

import java.util.ArrayList;
import java.util.List;

public class students {
    private List<student> studentList;

    private static students instance;

    private students() {
        studentList = new ArrayList<>();
    }

    public static students getInstance() {
        if (instance == null) {
            instance = new students();
        }
        return instance;
    }

    public void addStudent() {
        student newStudent = student.createStudent();
        studentList.add(newStudent);
        System.out.println("Student registered successfully!");
    }

    public void showAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        System.out.println("Showing all registered students:");
        for (student s : studentList) {
            System.out.println(s);
            System.out.println("-----------------------------");
        }
    }
}
