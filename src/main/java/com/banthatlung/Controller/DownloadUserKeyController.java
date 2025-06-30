package com.banthatlung.Controller;

import com.banthatlung.Dao.KeyDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "DownloadKeyController", value = "/download-user-key")
public class DownloadKeyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        if (userId == null && session.getAttribute("auth") != null) {
            userId = ((com.banthatlung.Dao.model.User) session.getAttribute("auth")).getId();
        }

        if (userId == null || !KeyDAO.hasKey(userId)) {
            resp.setContentType("text/plain");
            resp.getWriter().write("Không tìm thấy khóa cho người dùng.");
            return;
        }

        String privateKey = KeyDAO.getPrivateKeyByUserId(userId);
        if (privateKey == null) {
            resp.setContentType("text/plain");
            resp.getWriter().write("Khóa riêng không tồn tại.");
            return;
        }

        // Thiết lập tải file
        resp.setContentType("application/x-pem-file");
        resp.setHeader("Content-Disposition", "attachment; filename=\"privatekey.pem\"");

        // Ghi nội dung khóa vào output stream
        OutputStream out = resp.getOutputStream();
        out.write(privateKey.getBytes(StandardCharsets.UTF_8));
        out.flush();
        out.close();
    }
}
