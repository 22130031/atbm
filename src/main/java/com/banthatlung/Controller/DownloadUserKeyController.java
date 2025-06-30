package com.banthatlung.Controller;



import com.banthatlung.Dao.KeyDAO;
import com.banthatlung.Dao.model.UserKey;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "DownloadUserKeyController", value = "/download-user-key")
public class DownloadUserKeyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");

        if (userId == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thiếu userId");
            return;
        }

        UserKey key = KeyDAO.getKeyByUserId(userId);
        if (key == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy khóa của bạn");
            return;
        }

        // Thiết lập header để tải file
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment; filename=private_key_" + userId + ".txt");

        try (OutputStream out = resp.getOutputStream()) {
            out.write(key.getPrivateKey().getBytes());
            out.flush();
        }
    }
}

