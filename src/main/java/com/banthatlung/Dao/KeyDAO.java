package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;



import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.UserKey;

import java.security.*;
import java.util.Base64;
import javax.crypto.Cipher;
import java.sql.*;
import java.util.List;

public class KeyDAO {

    public static boolean generateKeyForUser(String userId, String email) {
        try {
            // Mã hóa email đơn giản (Base64)
            String encryptedEmail = Base64.getEncoder().encodeToString(email.getBytes());

            // Sinh cặp khóa RSA
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair pair = keyGen.generateKeyPair();

            String publicKeyStr = Base64.getEncoder().encodeToString(pair.getPublic().getEncoded());
            String privateKeyStr = Base64.getEncoder().encodeToString(pair.getPrivate().getEncoded());

            // Lưu vào DB
            String sql = "INSERT INTO user_keys (user_id, public_key, private_key, encrypted_email) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = DBConnect2.getPreparedStatement(sql)) {
                stmt.setString(1, userId);
                stmt.setString(2, publicKeyStr);
                stmt.setString(3, privateKeyStr);
                stmt.setString(4, encryptedEmail);
                return stmt.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean reportLostKey(String userId) {
        String sql = "UPDATE user_keys SET is_lost = TRUE WHERE user_id = ?";
        try (PreparedStatement stmt = DBConnect2.getPreparedStatement(sql)) {
            stmt.setString(1, userId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<UserKey> getAllKeys() {
        List<UserKey> list = new ArrayList<>();
        String sql = "SELECT * FROM user_keys";
        try (PreparedStatement stmt = DBConnect2.getPreparedStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                UserKey key = new UserKey();
                key.setId(rs.getInt("id"));
                key.setUserId(rs.getString("user_id"));
                key.setPublicKey(rs.getString("public_key"));
                key.setPrivateKey(rs.getString("private_key"));
                key.setEncryptedEmail(rs.getString("encrypted_email"));
                key.setIsLost(rs.getBoolean("is_lost"));
                list.add(key);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static UserKey getKeyByUserId(String userId) {
        String sql = "SELECT * FROM user_keys WHERE user_id = ?";
        try (PreparedStatement stmt = DBConnect2.getPreparedStatement(sql)) {
            stmt.setString(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    UserKey key = new UserKey();
                    key.setId(rs.getInt("id"));
                    key.setUserId(rs.getString("user_id"));
                    key.setPublicKey(rs.getString("public_key"));
                    key.setPrivateKey(rs.getString("private_key"));
                    key.setEncryptedEmail(rs.getString("encrypted_email"));
                    key.setIsLost(rs.getBoolean("is_lost"));
                    return key;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean hasKey(String userId) {
        String sql = "SELECT COUNT(*) FROM user_keys WHERE user_id = ?";
        try (PreparedStatement stmt = DBConnect2.getPreparedStatement(sql)) {
            stmt.setString(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

