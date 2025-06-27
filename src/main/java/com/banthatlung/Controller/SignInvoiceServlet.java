package com.banthatlung.controller;

import com.banthatlung.security.DigitalSigner;
import com.banthatlung.Dao.db.DBConnect2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.PreparedStatement;
import java.util.Base64;

@WebServlet("/SignInvoiceServlet")
public class SignInvoiceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String orderCode = req.getParameter("orderCode");
            String totalPrice = req.getParameter("totalPrice");
            String orderDate = req.getParameter("orderDate");

            String privateKeyBase64 = req.getParameter("privateKey").replaceAll("\\s", "");
            String publicKeyBase64 = req.getParameter("publicKey").replaceAll("\\s", "");

            // Tạo private key từ base64
            byte[] keyBytes = Base64.getDecoder().decode(privateKeyBase64);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(keySpec);

            // Dữ liệu cần ký
            String data = orderCode + "|" + totalPrice + "|" + orderDate;
            String signature = DigitalSigner.sign(data, privateKey);

            // Gọi DBConnect2 để cập nhật
            String sql = "UPDATE orders SET digital_signature=?, public_key=?, is_signed=TRUE WHERE order_code=?";
            PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
            ps.setString(1, signature);
            ps.setString(2, publicKeyBase64);
            ps.setString(3, orderCode);
            ps.executeUpdate();

            req.setAttribute("signature", signature);
            req.getRequestDispatcher("/security_ui/sign_invoice.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(500, "Lỗi khi ký hóa đơn và cập nhật DB.");
        }
    }
}
