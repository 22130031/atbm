package com.banthatlung.Dao.model;

import java.sql.Date;
import java.time.LocalDate;

public class Brand {
    private int id;
    private String name;
    private String createAt;

    public Brand(int id, String name, String createAt) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
    }

    public Brand(String name, String createAt) {
        this.name = name;
        this.createAt = createAt;
    }

    public Brand() {
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
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

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createAt=" + createAt +
                '}';
    }

    public String getCreateAt() {
        return createAt;
    }
}

