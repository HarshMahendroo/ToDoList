package com.example.mycrudoperations;

import java.io.Serializable;
public class UserModel implements Serializable {
    private String name;
    private int id;
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
    /*public String getModel() {
        return model;
    }*/
 /*   public void setHobby(String model) {
        this.model = model;
    }*/
}