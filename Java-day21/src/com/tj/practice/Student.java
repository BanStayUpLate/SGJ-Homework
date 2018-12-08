package com.tj.practice;

public class Student {

    private String name;
    private String sex;
    private String city;

    public Student() {
    }

    public Student(String name, String sex, String city) {
        this.name = name;
        this.sex = sex;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}