package com.banthatlung.Dao;


import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.PurchaseHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseHistoryDao {
    public List<PurchaseHistory> getHistoryByUser(String userId) throws SQLException {
        List<PurchaseHistory> list = new ArrayList<>();
        String sql = "SELECT * FROM purchase_history WHERE user_id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setString(1, userId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PurchaseHistory ph = new PurchaseHistory(
                    rs.getInt("id"),
                    rs.getString("user_id"),
                    rs.getInt("order_id"),
                    rs.getInt("total_price"),
                    rs.getDate("order_date").toString(),
                    rs.getBoolean("signed")
            );
            list.add(ph);
        }
        return list;
    }
}

