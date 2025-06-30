package com.banthatlung.Controller.admin;



import com.banthatlung.Dao.KeyDAO;
import com.banthatlung.Dao.model.UserKey;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminKeyController", value = "/admin_Keyys")
public class AdminKeyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserKey> keyList = KeyDAO.getAllKeys();
        request.setAttribute("keyList", keyList);
        request.getRequestDispatcher("/html_admin/admin_keys.jsp").forward(request, response);
    }
}

