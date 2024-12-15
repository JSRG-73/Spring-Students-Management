package com.jorgerosas.student.management.domain;

public class Student {
    private int ID, age;
    private String name, email, course;

    public Student(int ID, int age, String name, String email, String course) {
        this.ID = ID;
        this.age = age;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}