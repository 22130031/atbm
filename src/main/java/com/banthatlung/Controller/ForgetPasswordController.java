package com.banthatlung.Controller;

import com.banthatlung.services.ForgetPasswordService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ForgetPasswordController", urlPatterns = {"/forgot-password"})
public class ForgetPasswordController extends HttpServlet {

    private final ForgetPasswordService forgetPasswordService;

    public ForgetPasswordController() {
        this.forgetPasswordService = new ForgetPasswordService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/View/forgot-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        String typeMessage;
        String message;

        if (email == null || email.trim().isEmpty()) {
            typeMessage = "alert-danger";
            message = "Vui lòng nhập email!";
        } else {
            // Gọi dịch vụ để xử lý quên mật khẩu
            boolean result = forgetPasswordService.handleForgotPassword(email);

            if (result) {
                typeMessage = "alert-success";
                message = "Mật khẩu tạm đã được gửi đến email của bạn.";
            } else {
                typeMessage = "alert-danger";
                message = "Không tìm thấy tài khoản với email này. Vui lòng kiểm tra lại!";
            }
        }

        request.setAttribute("typeMessage", typeMessage);
        request.setAttribute("message", message);

        request.getRequestDispatcher("/View/forgot-password.jsp").forward(request, response);
    }
}
