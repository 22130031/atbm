package com.banthatlung.Controller;

import com.banthatlung.Dao.FavoriteDao;
import com.banthatlung.Dao.model.Favorite;
import com.banthatlung.Dao.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FavoriteServlet", value = "/favorite")
public class FavoriteServlet extends HttpServlet {
    private final FavoriteDao favoriteDao = new FavoriteDao();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/View/favorite.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/View/login.jsp");
            return;
        }
        List<Favorite> favoriteProducts = favoriteDao.getAllByUserId(user.getId());

        req.setAttribute("favoriteProducts", favoriteProducts);
        req.getRequestDispatcher("/View/favorite.jsp").forward(req, resp);
    }
}