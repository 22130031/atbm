package com.banthatlung.Dao.model;



import java.util.Date;

public class KeyEntity {
    private int id;
    private Date createdAt;
    private int keySize;
    private boolean isRevoked;

    public KeyEntity(int id, Date createdAt, int keySize, boolean isRevoked) {
        this.id = id;
        this.createdAt = createdAt;
        this.keySize = keySize;
        this.isRevoked = isRevoked;
    }

    public int getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getKeySize() {
        return keySize;
    }

    public boolean isRevoked() {
        return isRevoked;
    }

    public void setRevoked(boolean revoked) {
        isRevoked = revoked;
    }
}

