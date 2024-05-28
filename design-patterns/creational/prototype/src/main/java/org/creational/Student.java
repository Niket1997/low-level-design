package org.creational;

public class Student implements IPrototype{
    private int rollNumber;
    private String name;
    private String address;

    public Student(int rollNumber, String name, String address) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.address = address;
    }

    @Override
    public IPrototype clone() {
        return new Student(rollNumber, name, address);
    }
}
