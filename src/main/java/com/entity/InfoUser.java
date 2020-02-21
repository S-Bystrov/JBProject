package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "info")
public class InfoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_info")
    private int idInfo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "city", nullable = false)
    private String city;

    public int getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(int idInfo) {
        this.idInfo = idInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
