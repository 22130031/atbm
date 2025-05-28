<%@ page import="com.banthatlung.Dao.model.ProductCart" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
          integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <style>
        <%@include file="../css/footer.css" %>
    </style>
    <style>
        <%@include file="../css/header.css" %>
    </style>
    <style>
        <%@include file="../css/thanhtoan.css" %>
    </style>
    <style>
        <%@include file="../asset/css/bootstrap.css" %>
    </style>
</head>
<body>
<header>
    <div id="fullscreen-search" class="fullscreen-search">
        <span class="close-btn">&times;</span>
        <div class="search-container">
            <div class="search-box">
                <input type="text" class="search-input" placeholder="Search..">
                <button class="search-icon">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </div>
        </div>
    </div>
    <div class="header">
        <a href="home.html"><h1>Trang chủ</h1></a>
        <div class="menu">
            <div class="dropdown">
                <a href="danhmucsp.html">Danh mục sản phẩm</a>
                <div class="dropdown-content">
                    <a href="#">Thắt lưng nam</a>
                    <a href="#">Thắt lưng nữ</a>
                </div>
            </div>
            <a href="#">Giới thiệu</a>
            <a href="#">Chính sách </a>
            <a href="#">Liên hệ</a>
        </div>
        <div class="icons">
            <a href="#" id="open-search"><i class="fa-solid fa-magnifying-glass"></i></a>
            <div class="dropdown-user">
                <a href="profile.html"><i class="fa-solid fa-user"></i></a>
                <div class="dropdown-content-user">
                    <a href="Login.html">Đăng nhập</a>
                </div>
            </div>
            <a href="Cart.html"><i class="fa-solid fa-cart-shopping"></i></a>
        </div>
    </div>
</header>
<script src="../fullscreensearch.js"></script>

<main class="checkout-container">
    <h2>Thanh toán</h2>
    <div class="checkout-content">
        <!-- Order Summary -->
        <div class="order-summary">
            <h3>Các sản phẩm: </h3>
            <ul>
                <c:if test="${cart != null}">
                    <%
                        int total = 0;
                        HashMap<Integer, ProductCart> carts = (HashMap<Integer, ProductCart>) request.getAttribute("cart");
                        for (Map.Entry<Integer, ProductCart> entry : carts.entrySet()) {
                            Integer key = entry.getKey();
                            ProductCart value = entry.getValue();
                            total += value.getQuantity() * value.getProduct().getPrice();
                    %>
                    <li> - <%= value.getProduct().getName()%><span><%= value.getProduct().getPrice()%></span>x <%= value.getQuantity()%></li>

                    <% } %>

                <li class="total">Tổng cộng :<span><%=total%></span></li>
            </ul>
        </div>
        </c:if>
        <!-- Payment Form -->
        <div class="payment-form">
            <h3>Chi tiết đơn hàng </h3>
            <form method="POST">
                <div class="mb-3">
                    <label for="name" class="form-label">Tên </label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="Loại sản phẩm">
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">SDT</label>
                    <input type="text" name="phone" class="form-control" id="phone" placeholder="Mô tả">
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Địa chỉ</label>
                    <input type="text" name="address" class="form-control" id="address" placeholder="Mô tả">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>
    </div>
</main>

<!-- Footer -->
<footer class="footer">
    <div class="footer-brand">
        <p>CHUYÊN CUNG CẤP CÁC LOẠI THẮT LƯNG.</p>
        <p> Chất lượng - Uy tín - Tin cậy</p>
        <div class="social-icons">
            <a href="https://www.facebook.com" target="_blank">
                <img src="../asset/image/icons8-facebook-48.png" alt="Facebook">
                <a href="https://www.instagram.com" target="_blank">
                    <img src="../asset/image/logoInsta.png" alt="Instagram">
                </a>
                <a href="https://www.youtube.com" target="_blank">
                    <img src="../asset/image/logoytb.jpg" alt="YouTube">
                </a>
                <a href="https://www.twitter.com" target="_blank">
                    <img src="../asset/image/twitter.jpg" alt="Twitter">
                </a></a></div>
    </div>
    <div class="footer-container">
        <!-- Logo và mạng xã hội -->

        <div class="footer-brand">
            <img src="../asset/image/logoSaleNoti.png" alt="Logo" class="footer-logo">
            <p>Chất lượng - Uy tín - Tin cậy</p>
            <div class="social-icons">
                <i class="fa-brands fa-facebook"></i>
                <i class="fa-brands fa-instagram"></i>
                <i class="fa-solid fa-phone"></i>
                <i class="fa-brands fa-youtube"></i>
            </div>
        </div>

        <!-- Danh sách liên kết -->
        <div class="footer-links">
            <div>
                <h3>Sản phẩm</h3>
                <ul>
                    <li><a href="#">Thắt lưng nam</a></li>
                    <li><a href="#">Thắt lưng nữ</a></li>
                    <li><a href="#">Phụ kiện</a></li>
                    <li><a href="#">Khuyến mãi</a></li>
                </ul>
            </div>
            <div>
                <h3>Chính sách</h3>
                <ul>
                    <li><a href="#">Chính sách đổi trả</a></li>
                    <li><a href="#">Chính sách bảo mật</a></li>
                    <li><a href="#">Chính sách vận chuyển</a></li>
                    <li><a href="#">Hướng dẫn thanh toán</a></li>
                </ul>
            </div>
            <div>
                <h3>Hỗ trợ</h3>
                <ul>
                    <li><a href="#">Liên hệ</a></li>
                    <li><a href="#">Hỗ trợ</a></li>
                    <li><a href="#">Tuyển dụng</a></li>
                </ul>
            </div>
        </div>

        <!-- Thông tin công ty -->
        <div class="footer-contact">
            <h3>Liên hệ</h3>
            <p>Địa chỉ: Số 8, Tam Bình, Thủ Đức</p>
            <p>Điện thoại: 0397526965</p>
            <p>Email: storethatlung@gmail.com</p>
            <p>Thời gian làm việc: 8:00 - 22:00 (hàng ngày)</p>
        </div>
    </div>
    <div class="footer-bottom">
        <p>&copy; 2024 Chuyên cung cấp thắt lưng các loại. Hotline: <a href="tel:0397526965">0397526965</a></p>
    </div>
</footer>
</body>
</html>
