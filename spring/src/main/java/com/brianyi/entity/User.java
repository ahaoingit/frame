package com.brianyi.entity;

/**
 * TODO
 *
 * @author ahao 2020-11-02
 */
public class User {
    private String name;
    private Integer age;
    private String gender;
    public User() {
//        System.out.println("user 创建");
    }

    public void  init() {
        System.out.println("init");
    }

    public void destory() {
        System.out.println("destory");
    }

    public User(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
