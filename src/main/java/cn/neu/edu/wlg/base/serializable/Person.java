//http://www.blogjava.net/jiangshachina/archive/2012/02/13/369898.html

package cn.neu.edu.wlg.base.serializable;

import java.io.*;

public class Person implements Externalizable {

    private String name;
    private Gender gender;
    transient private Integer age;

    public Person() {
        System.out.println("执行无参构造方法");
    }
    public Person(String name, Gender gender, Integer age) {

        this.name = name;
        this.gender = gender;
        this.age = age;
        System.out.println("执行有参构造方法");
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {

        oos.defaultWriteObject();
        oos.writeInt(age);
    }


    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeObject(name);
        out.writeInt(age);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        name = (String) in.readObject();
        age = in.readInt();
    }

    private  void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {

        ois.defaultReadObject();
        age = ois.readInt();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[name: " + name + ",gender: " + gender + ",age: " + age + "]";
    }
}

enum Gender {
    MALE, FEMALE;
}





//package com.wlg.serializable;
//
//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//
//public class Person implements Serializable {
//
//    private String name;
//    private Gender gender;
//    transient private Integer age;
//
//    public Person(String name, Gender gender, Integer age) {
//
//        this.name = name;
//        this.gender = gender;
//        this.age = age;
//    }
//
//    private void writeObject(ObjectOutputStream oos) throws IOException {
//
//        oos.defaultWriteObject();
//        oos.writeInt(age);
//    }
//    private  void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
//
//        ois.defaultReadObject();
//        age = ois.readInt();
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Gender getGender() {
//        return gender;
//    }
//
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "[name: " + name + ",gender: " + gender + ",age: " + age + "]";
//    }
//}
//
//enum Gender {
//    MALE, FEMALE;
//}
