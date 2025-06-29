package com.banthatlung.Dao;




import com.banthatlung.Dao.model.KeyHistory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KeyHistoryDAO {
    private static final List<KeyHistory> historyList = new ArrayList<>();

    public static void add(String action) {
        historyList.add(new KeyHistory(new Date(), action));
    }

    public static List<KeyHistory> getAll() {
        return historyList;
    }
}

