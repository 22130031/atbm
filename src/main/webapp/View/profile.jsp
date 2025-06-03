<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/30/2024
  Time: 12:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hồ Sơ Người Dùng</title>
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
        /* Toàn bộ trang */
        body {
            font-family: Arial, sans-serif;
            background-color: #212121;
            color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        .container {
            display: flex;
            justify-content: space-around;
            width: 80%;
            color: #ffffff;
            border-right: 2px solid #3a3a3a;
        }

        /* Sidebar */
        .sidebar {
            width: 250px;
            background-color: #333;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            border-radius: 10px;
        }

        .user-info {
            text-align: center;
            margin-bottom: 20px;
        }

        .avatar img {
            width: 80px;
            height: 80px;
            border-radius: 50%;
            border: 3px solid #e63946;
            object-fit: cover;
        }
        .avatar img:hover {
            transform: scale(1.1); /* Phóng to nhẹ khi hover */
        }

        .username {
            font-size: 16px;
            font-weight: bold;
            margin: 10px 0;
        }


        .edit-profile {
            font-size: 14px;
            color: #e63946;
            cursor: pointer;
        }

        .menu-text p {
            margin: 10px 0;
            font-size: 14px;
        }

        .menu-text a {
            text-decoration: none;
            color: #f0f0f0;
            transition: color 0.3s;
        }

        .menu-text a:hover {
            color: #e63946;
        }

        /* Content */
        .content {
            flex: 1;
            padding: 20px;
        }

        .subtitle {
            font-size: 12px;
            color: #aaa;
            margin-bottom: 20px;
        }

        /* Form */
        .profile-form {
            background-color: #222;
            padding: 20px;
            border-radius: 10px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            font-size: 14px;
            display: block;
            margin-bottom: 5px;
        }

        input[type="email"], input[type="date"] {
            width: 100%; /* Thu nhỏ chiều rộng input */
            max-width: 400px; /* Giới hạn kích thước lớn nhất */
            padding: 10px;
            font-size: 14px;
            border: 1px solid #444;
            border-radius: 5px;
            background-color: #333;
            color: #f0f0f0;
        }

        input[type="email"]:focus, input[type="date"]:focus {
            border-color: #e63946;
            outline: none;
            box-shadow: 0 0 5px #e63946;
        }
        .name-input{
            width: 100%; /* Thu nhỏ chiều rộng input */
            max-width: 400px; /* Giới hạn kích thước lớn nhất */
            padding: 10px;
            font-size: 14px;
            border: 1px solid #444;
            border-radius: 5px;
            background-color: #333;
            color: #f0f0f0;
        }
        .name-input:focus{
            border-color: #e63946;
            outline: none;
            box-shadow: 0 0 5px #e63946;
        }

        .gender-options label {
            margin-right: 15px;
            font-size: 14px;
            cursor: pointer;
        }

        .gender-options input {
            margin-right: 5px;
        }

        .save-button {
            width: 10%;
            max-width: 400px;
            padding: 12px;
            font-size: 16px;
            color: #fff;
            background-color: #e63946;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }

        .save-button:hover {
            background-color: #d72f3e;
        }

        .avatar-upload-label {
            display: block;
            margin-top: 10px;
            font-size: 14px;
            color: #e63946;
            cursor: pointer;
            text-decoration: underline;
        }

        .avatar-upload-label:hover {
            color: #d72f3e;
        }

    </style>

</head>
<body>
<!--Header-->
<header>
    <div class="header">
        <a href="${pageContext.request.contextPath}/home"><h1>Trang chủ</h1></a>
        <div class="menu">
            <div class="dropdown">
                <a href="${pageContext.request.contextPath}/home">Danh mục sản phẩm</a>
                <div class="dropdown-content">
                    <a href="#">Thắt lưng nam</a>
                    <a href="#">Thắt lưng nữ</a>
                </div>
            </div>
            <a href="#">Giới thiệu</a>
            <a href="#">Chính sách</a>
            <a href="#">Liên hệ</a>
        </div>
        <div class="icons">
            <form action="${pageContext.request.contextPath}/search" method="get">
                <div class="search-container">
                    <div class="search-box">
                        <button class="search-icon">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                        <label>
                            <input type="text" class="search-input" name="search" placeholder="Search..">
                        </label>
                    </div>
                </div>
            </form>
            <c:if test="${sessionScope.auth ==null}">
                <div class="dropdown-user">
                    <a href="#"><i class="fa-solid fa-user"></i></a>
                    <div class="dropdown-content-user">
                        <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
                    </div>
                </div>
            </c:if>
            <c:if test="${sessionScope.auth !=null}">
                <div class="dropdown-user">
                    <a href="${pageContext.request.contextPath}/profile">
                        <img src="${sessionScope.auth.image}" alt="Avatar"
                             style="width: 30px; height: 30px; border-radius: 50%;">
                    </a>
                    <div class="dropdown-content-user">
                        <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
                    </div>
                </div>
                <a href=${pageContext.request.contextPath}/Cart?action=showCart><i class="fa-solid fa-cart-shopping"></i></a>
            </c:if>
        </div>
    </div>
</header>
<div class="container">
    <!-- Sidebar -->
    <div class="sidebar">
        <div class="user-info">
            <div class="avatar">
                <img id="profile-avatar" src="${sessionScope.auth.image}" alt="Avatar">
                <form action="${pageContext.request.contextPath}/update-avatar" method="post" enctype="multipart/form-data">
                    <label for="avatar-upload" class="avatar-upload-label">Đổi Avatar</label>
                    <input type="file" id="avatar-upload" name="avatar" accept="image/*" onchange="this.form.submit();" style="display: none;">
                </form>
            </div>
            <p class="username">${sessionScope.auth.name}</p>
            <p class="edit-profile">Sửa Hồ Sơ</p>
        </div>
        <div class="menu-text">
            <p><a href="#">Hồ Sơ</a></p>
            <p><a href="${pageContext.request.contextPath}/favorite">Sản phẩm yêu thích</a></p>
            <p><a href="${pageContext.request.contextPath}/purchase-history">Lịch sử mua hàng</a></p>
            <p><a href="${pageContext.request.contextPath}/change-password">Đổi mật khẩu</a></p>
        </div>
    </div>

    <!-- Content -->
    <div class="content">
        <h1>Hồ Sơ Của Tôi</h1>
        <p class="subtitle">Quản lý thông tin hồ sơ để bảo mật tài khoản</p>
        <div class="profile-form">
            <form action="${pageContext.request.contextPath}/profile" method="post">
                <div class="form-group">
                    <label for="name">Tên:</label>
                    <input type="text" id="name" class="name-input" name="name" value="${sessionScope.auth.name}">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" value="${sessionScope.auth.email}">
                </div>
                <div class="form-group">
                    <label for="phone">Số điện thoại:</label>
                    <input type="text" id="phone" class="name-input" name="phone" value="${sessionScope.auth.phone}">
                </div>
                <div class="form-group">
                    <label for="dob">Ngày sinh:</label>
                    <input type="date" id="dob" name="dob" value="${sessionScope.auth.birthday}">
                </div>
                <div class="form-group">
                    <label>Giới tính: ${sessionScope.auth.gender}</label>
                </div>
                <button type="submit" class="save-button">Lưu</button>
            </form>
        </div>
    </div>
</div>
<!-- Footer -->
<footer class="footer">
    <div class="footer-brand">
        <p>CHUYÊN CUNG CẤP CÁC LOẠI THẮT LƯNG.</p>
        <p>   Chất lượng - Uy tín - Tin cậy</p>
        <div class="social-icons">
            <a href="https://www.facebook.com" target="_blank">
                <img src="../asset/image/icons8-facebook-48.png" alt="Facebook"></a>
                <a href="https://www.instagram.com" target="_blank">
                    <img src="../asset/image/logoInsta.png" alt="Instagram">
                </a>
                <a href="https://www.youtube.com" target="_blank">
                    <img src="../asset/image/logoytb.jpg" alt="YouTube">
                </a>
                <a href="https://www.twitter.com" target="_blank">
                    <img src="../asset/image/twitter.jpg" alt="Twitter">
                </a>
        </div>
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
<script>
    document.getElementById("avatar-upload").addEventListener("change", function (event) {
        const file = event.target.files[0];
        if (file) {
            const reader = new FileReader();

            // Hiển thị hình ảnh được chọn
            reader.onload = function (e) {
                document.getElementById("profile-avatar").src = e.target.result;
            };

            reader.readAsDataURL(file);
        }
    });
</script>
</body>
</html>

