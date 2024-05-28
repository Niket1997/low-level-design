package org.creational;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Niket", "Seawoods");
        Student clonedStudent = (Student) student.clone();
    }
}