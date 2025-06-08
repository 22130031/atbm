package com.banthatlung.Controller;

import com.banthatlung.Dao.OrderDao;
import com.banthatlung.Dao.model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/orders"})
public class OrderController extends HttpServlet {
    private final OrderDao orderDao = new OrderDao();

    // Đường dẫn file private key
    private static final String PRIVATE_KEY_PATH = "D:\\keys\\private_key.pem";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String filter = req.getParameter("filter");
        String search = req.getParameter("search");

        try {
            List<Order> orderList = orderDao.getAllOrders();
            if (filter != null && !filter.isEmpty() && !"all".equals(filter)) {
                orderList = orderList.stream()
                        .filter(order -> "signed".equals(filter) ? order.isSigned() : !order.isSigned())
                        .collect(Collectors.toList());
            }
            if (search != null && !search.isEmpty()) {
                String finalSearch = search;
                orderList = orderList.stream()
                        .filter(order -> String.valueOf(order.getOrderCode()).contains(finalSearch))
                        .collect(Collectors.toList());
            }
            req.setAttribute("OrderList", orderList);
            req.getRequestDispatcher("/View/orders.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Không thể xử lý yêu cầu.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("sign".equals(action)) {
            String[] ids = req.getParameter("ids").split(",");
            try {
                // Đọc và tạo PrivateKey từ file PEM
                byte[] keyBytes = Files.readAllBytes(Paths.get(PRIVATE_KEY_PATH));
                String keyPEM = new String(keyBytes)
                        .replace("-----BEGIN PRIVATE KEY-----", "")
                        .replace("-----END PRIVATE KEY-----", "")
                        .replaceAll("\\s", "");
                byte[] decodedKey = Base64.getDecoder().decode(keyPEM);
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

                Signature signature = Signature.getInstance("SHA1withRSA");
                signature.initSign(privateKey);

                for (String idStr : ids) {
                    int id = Integer.parseInt(idStr);
                    Order order = orderDao.getOrderById(id);
                    if (order != null) {
                        String dataToSign = order.getOrderCode() + "|" + order.getTotalPrice() + "|" + order.getOrderDate();

                        signature.update(dataToSign.getBytes());
                        byte[] signBytes = signature.sign();
                        String signBase64 = Base64.getEncoder().encodeToString(signBytes);

                        orderDao.updateOrderSignature(id, true, signBase64);
                    }
                }
                resp.sendRedirect("orders");
            } catch (Exception e) {
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Không thể ký hóa đơn.");
            }
        }
    }
}
