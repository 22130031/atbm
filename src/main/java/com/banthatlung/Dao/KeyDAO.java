package com.banthatlung.Dao;





import com.banthatlung.Dao.model.KeyEntity;

import java.util.*;

public class KeyDAO {
    private static final List<KeyEntity> keys = new ArrayList<>();
    private static int currentId = 1;

    public static void addKey(int keysize) {
        KeyEntity key = new KeyEntity(currentId++, new Date(), keysize, false);
        keys.add(key);
    }

    public static List<KeyEntity> getAllKeys() {
        return keys;
    }

    public static void revokeKey(int id) {
        for (KeyEntity key : keys) {
            if (key.getId() == id) {
                key.setRevoked(true);
                break;
            }
        }
    }
}

