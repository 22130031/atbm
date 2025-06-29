package com.banthatlung.Dao.model;



import java.util.Date;

public class KeyHistory {
    private Date time;
    private String action;

    public KeyHistory(Date time, String action) {
        this.time = time;
        this.action = action;
    }

    public Date getTime() {
        return time;
    }

    public String getAction() {
        return action;
    }
}

