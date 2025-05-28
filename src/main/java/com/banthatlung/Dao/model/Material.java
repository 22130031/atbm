package com.banthatlung.Dao.model;

public class Material {
    private int id;
   public  String name;

    public Material(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Material(String name) {
        this.name = name;
    }

    public Material() {

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
}
