package com.banthatlung.Controller;

import com.banthatlung.Dao.model.Product;
import com.banthatlung.Dao.model.ProductCart;
import com.banthatlung.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(urlPatterns = {"/Cart"})
public class CartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "showCart":
                showCart(req, resp);
                break;
            case "add":
                try {
                    addToCart(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "remove":
                try {
                    remove(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "increase":
                try {
                    increase(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "decrease":
                try {
                    decrease(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "checkOut":
                try {
                    checkOut(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                break;
        }
    }

    private void updateQuantity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = ProductService.getById(id);
        HttpSession session = req.getSession();
    }

    public void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        HashMap<Integer, ProductCart> carts = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        req.setAttribute("cart", carts);

        if (req.getHeader("X-Requested-With") != null) {
            // Nếu yêu cầu là AJAX, chỉ trả về nội dung giỏ hàng
            req.getRequestDispatcher("/View/Cart.jsp").include(req, resp);
        } else {
            // Nếu không phải AJAX, trả về toàn bộ trang
            req.getRequestDispatcher("/View/Cart.jsp").forward(req, resp);
        }
    }

    public static void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String contextPath = req.getContextPath();
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = ProductService.getById(id);
        HttpSession session = req.getSession();
        ProductCart productCart;
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
            productCart = new ProductCart(1, product);
            cart.put(id, productCart);

        } else {
            if (cart.containsKey(id)) {
                productCart = cart.get(id);
                productCart.increaseQuantity();
            } else {
                productCart = new ProductCart(1, product);
                cart.put(id, productCart);
            }
        }
        session.setAttribute("cart", cart);
        resp.sendRedirect(contextPath + "/home");
    }

    public static void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String contextPath = req.getContextPath();
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = ProductService.getById(id);
        HttpSession session = req.getSession();
        ProductCart productCart;
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        } else {
            cart.containsKey(id);
            cart.remove(id);

        }
        session.setAttribute("cart", cart);
        resp.sendRedirect(contextPath + "/Cart?action=showCart");
    }

    public static void increase(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String contextPath = req.getContextPath();
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = ProductService.getById(id);
        HttpSession session = req.getSession();
        ProductCart productCart;
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        cart.get(id).increaseQuantity();
        session.setAttribute("cart", cart);
        resp.sendRedirect(contextPath + "/Cart?action=showCart");
    }

    public static void decrease(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String contextPath = req.getContextPath();
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = ProductService.getById(id);
        HttpSession session = req.getSession();
        ProductCart productCart;
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        if (cart.get(id).getQuantity() == 1) {
            cart.remove(id);
        } else cart.get(id).decrementQuantity();
        session.setAttribute("cart", cart);
        resp.sendRedirect(contextPath + "/Cart?action=showCart");
    }

    public static void checkOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        HttpSession session = req.getSession();
        String contextPath = req.getContextPath();
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        session.setAttribute("cart", cart);
        resp.sendRedirect(contextPath + "/checkOut");
    }
}
