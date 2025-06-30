package com.banthatlung.Dao.model;

import java.sql.Timestamp;

public class UserKey {
    private int id;
    private String userId;
    private String publicKey;
    private String privateKey;
    private String encryptedEmail;
    private boolean isLost;

    // Constructors
    public UserKey() {
    }

    public UserKey(int id, String userId, String publicKey, String privateKey, String encryptedEmail, boolean isLost) {
        this.id = id;
        this.userId = userId;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.encryptedEmail = encryptedEmail;
        this.isLost = isLost;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getEncryptedEmail() {
        return encryptedEmail;
    }

    public void setEncryptedEmail(String encryptedEmail) {
        this.encryptedEmail = encryptedEmail;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setIsLost(boolean isLost) {
        this.isLost = isLost;
    }
}

// Getters và Setters

