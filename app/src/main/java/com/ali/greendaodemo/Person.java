package com.ali.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by mumu on 2018/7/6.
 */

@Entity(nameInDb = "person")
public class Person {

    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "name")
    private String name1;
    private int age;
    @Transient
    private int gender;
    @Generated(hash = 159489363)
    public Person(Long id, String name1, int age) {
        this.id = id;
        this.name1 = name1;
        this.age = age;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName1() {
        return this.name1;
    }
    public void setName1(String name1) {
        this.name1 = name1;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name1='" + name1 + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
