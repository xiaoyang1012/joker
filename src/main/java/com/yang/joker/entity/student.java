package com.yang.joker.entity;

public class student {
    private String name;
    private String level;
    private int age;
    private String sex;

    public student(String name,String level,int age,String sex){
        this.age=age;
        this.level=level;
        this.name=name;
        this.sex=sex;
    }
    public student(){

    }
    public student(String name,String level,int age){
        this.age=age;
        this.level=level;
        this.name=name;
    }

    public student(String name,String level){
        this.age=age;
        this.level=level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void  printX(String args){
        System.out.println(args);
    }
    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
