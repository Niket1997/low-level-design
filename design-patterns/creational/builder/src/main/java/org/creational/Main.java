package org.creational;

public class Main {
    public static void main(String[] args) {
        Director directorEng = new Director(new EngineeringStudentBuilder());
        Director directorMBA = new Director(new MBAStudentBuilder());

        Student engineeringStudent = directorEng.createStudent();
        Student mbaStudent = directorMBA.createStudent();

        System.out.println(engineeringStudent.toString());
        System.out.println(mbaStudent.toString());
    }
}