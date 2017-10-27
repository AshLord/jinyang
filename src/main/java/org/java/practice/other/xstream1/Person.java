package org.java.practice.other.xstream1;

import java.util.List;

/**
 * Created by yang.jin on 27/10/2017.
 */
public class Person {

    //姓名
    private String name;
    //性别
    private String sex;
    //年龄
    private int age;
    //地址
    private List<Address> Address;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<org.java.practice.other.xstream1.Address> getAddress() {
        return Address;
    }

    public void setAddress(List<org.java.practice.other.xstream1.Address> address) {
        Address = address;
    }
}
