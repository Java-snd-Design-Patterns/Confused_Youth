package library;

import java.util.Scanner;

public class student {
    private String studentName;
    private String regNum;

    private student(String studentName, String regNum) {
        this.studentName = studentName;
        this.regNum = regNum;
    }

    public static student createStudent() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Student Name:");
        String studentName = input.nextLine();
        System.out.println("Enter Reg Number:");
        String regNum = input.nextLine();

        return new student(studentName, regNum);
    }

    // Getters and setters...

    @Override
    public String toString() {
        return "Student Name: " + studentName + "\nRegistration Number: " + regNum;
    }
}
