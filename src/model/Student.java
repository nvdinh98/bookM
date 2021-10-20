package model;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String studentCode;
    private String age;
    private String classRoom;
    private double balance;

    public Student() {
    }

    public Student(String name, String studentCode, String age, String classRoom, double balance) {
        this.name = name;
        this.studentCode = studentCode;
        this.age = age;
        this.classRoom = classRoom;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", age='" + age + '\'' +
                ", classRoom='" + classRoom + '\'' +
                ", balance=" + balance +
                '}';
    }
}
