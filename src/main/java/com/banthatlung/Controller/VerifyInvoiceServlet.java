package com.banthatlung.controller;

import com.banthatlung.security.DigitalSigner;
import com.banthatlung.Dao.db.DBConnect2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

@WebServlet("/VerifyInvoiceServlet")
public class VerifyInvoiceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderCode = req.getParameter("orderCode");

        try {
            String sql = "SELECT total_price, order_date, digital_signature, public_key FROM orders WHERE order_code=?";
            PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
            ps.setString(1, orderCode);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                resp.sendError(404, "Không tìm thấy đơn hàng.");
                return;
            }

            int totalPrice = rs.getInt("total_price");
            String orderDate = rs.getString("order_date");
            String signature = rs.getString("digital_signature");
            String publicKeyBase64 = rs.getString("public_key");

            String data = orderCode + "|" + totalPrice + "|" + orderDate;

            byte[] pubBytes = Base64.getDecoder().decode(publicKeyBase64);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubBytes);
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(keySpec);

            boolean isValid = DigitalSigner.verify(data, signature, publicKey);

            req.setAttribute("isValid", isValid);
            req.setAttribute("orderCode", orderCode);
            req.getRequestDispatcher("/security_ui/verify_result.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(500, "Lỗi khi xác minh chữ ký hóa đơn.");
        }
    }
}
