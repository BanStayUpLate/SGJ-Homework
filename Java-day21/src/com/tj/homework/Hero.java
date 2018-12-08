package com.tj.homework;

public class Hero {
    private int id;
    private String name;
    private String city;
    private String sex;
    private int bir;
    private int death;
    private int power;

    public Hero(int id, String name, String city, String sex, int bir, int death, int power) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.sex = sex;
        this.bir = bir;
        this.death = death;
        this.power = power;
    }

    public Hero() {

    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", sex='" + sex + '\'' +
                ", bir=" + bir +
                ", death=" + death +
                ", power=" + power +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getBir() {
        return bir;
    }

    public void setBir(int bir) {
        this.bir = bir;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
