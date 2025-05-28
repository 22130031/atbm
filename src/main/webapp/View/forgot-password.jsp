<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Quên mật khẩu</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<header class="bg-dark text-white py-3">
  <div class="container d-flex justify-content-between align-items-center">
    <!-- Logo và Trang chủ -->
    <a href="${pageContext.request.contextPath}/home" class="text-white">
      <h1 class="m-0">Trang chủ</h1>
    </a>

    <!-- Menu điều hướng -->
    <div class="menu d-flex">
      <a href="${pageContext.request.contextPath}/home" class="text-white mx-3">Danh mục sản phẩm</a>
      <a href="#" class="text-white mx-3">Giới thiệu</a>
      <a href="#" class="text-white mx-3">Chính sách</a>
      <a href="#" class="text-white mx-3">Liên hệ</a>
    </div>


    <div class="icons d-flex pt-1"  >

      <div class="dropdown">
        <a href="#" class="text-white mx-2" id="user-dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
          <i class="fa-solid fa-user"></i>
        </a>
        <ul class="dropdown-menu" aria-labelledby="user-dropdown-toggle">
          <li><a class="dropdown-item" href="${pageContext.request.contextPath}/login">Đăng nhập</a></li>
          <li><a class="dropdown-item" href="${pageContext.request.contextPath}/change-password">Đổi mật khẩu</a></li>
        </ul>
      </div>

      <div class="search-container me-4">
        <form action="${pageContext.request.contextPath}/search" method="get">
          <div class="input-group input-group-sm">
            <input type="text" class="form-control" name="search" placeholder="Tìm kiếm...">
            <button class="btn btn-sm btn-outline-secondary" type="submit">
              <i class="fa-solid fa-magnifying-glass"></i>
            </button>
          </div>
        </form>
      </div>

      <a href="<%=request.getContextPath()%>/Cart?action=showCart" class="text-white mx-2"><i class="fa-solid fa-cart-shopping fa-lg"></i></a>
    </div>

  </div>
</header>

<section id="forgot-password" class="container py-5">
  <h2 class="text-center mb-4">Quên mật khẩu</h2>
  <form action="${pageContext.request.contextPath}/forgot-password" method="post">
    <div class="form-group">
      <label for="email">Nhập email của bạn</label>
      <input type="email" id="email" name="email" class="form-control" required placeholder="example@gmail.com">
    </div>

    <!-- Thông báo -->
    <c:if test="${not empty typeMessage}">
      <div class="alert ${typeMessage} mt-3" role="alert">
          ${message}
      </div>
    </c:if>

    <div class="text-center mt-4">
      <button type="submit" class="btn btn-primary">Gửi mã xác nhận</button>
    </div>
  </form>
</section>

<footer class="bg-dark text-white py-4">
  <div class="container">
    <!-- Thông tin giới thiệu và các mạng xã hội -->
    <div class="row text-center mb-4">
      <div class="col-12">
        <p>CHUYÊN CUNG CẤP CÁC LOẠI THẮT LƯNG.</p>
        <p>Chất lượng - Uy tín - Tin cậy</p>
      </div>
      <div class="col-12">
        <div class="social-icons">
          <a href="https://www.facebook.com" target="_blank" class="text-white mx-2">
            <i class="fa-brands fa-facebook fa-2x"></i>
          </a>
          <a href="https://www.instagram.com" target="_blank" class="text-white mx-2">
            <i class="fa-brands fa-instagram fa-2x"></i>
          </a>
          <a href="https://www.youtube.com" target="_blank" class="text-white mx-2">
            <i class="fa-brands fa-youtube fa-2x"></i>
          </a>
          <a href="https://www.twitter.com" target="_blank" class="text-white mx-2">
            <i class="fa-brands fa-twitter fa-2x"></i>
          </a>
        </div>
      </div>
    </div>

    <!-- Các liên kết footer (4 mục nằm ngang) -->
    <div class="row mb-4">
      <div class="col-lg-3 col-md-6">
        <h5>Sản phẩm</h5>
        <ul class="list-unstyled">
          <li><a href="#" class="text-white">Thắt lưng nam</a></li>
          <li><a href="#" class="text-white">Thắt lưng nữ</a></li>
          <li><a href="#" class="text-white">Phụ kiện</a></li>
          <li><a href="#" class="text-white">Khuyến mãi</a></li>
        </ul>
      </div>
      <div class="col-lg-3 col-md-6">
        <h5>Chính sách</h5>
        <ul class="list-unstyled">
          <li><a href="#" class="text-white">Chính sách đổi trả</a></li>
          <li><a href="#" class="text-white">Chính sách bảo mật</a></li>
          <li><a href="#" class="text-white">Chính sách vận chuyển</a></li>
          <li><a href="#" class="text-white">Hướng dẫn thanh toán</a></li>
        </ul>
      </div>
      <div class="col-lg-3 col-md-6">
        <h5>Hỗ trợ</h5>
        <ul class="list-unstyled">
          <li><a href="#" class="text-white">Liên hệ</a></li>
          <li><a href="#" class="text-white">Hỗ trợ</a></li>
          <li><a href="#" class="text-white">Tuyển dụng</a></li>
        </ul>
      </div>
      <div class="col-lg-3 col-md-6">
        <h5>Liên hệ</h5>
        <p>Địa chỉ: Số 8, Tam Bình, Thủ Đức</p>
        <p>Điện thoại: 0397526965</p>
        <p>Email: <a href="mailto:storethatlung@gmail.com" class="text-white">storethatlung@gmail.com</a></p>
        <p>Thời gian làm việc: 8:00 - 22:00 (hàng ngày)</p>
      </div>
    </div>

    <!-- Thông tin bản quyền -->
    <div class="footer-bottom text-center">
      <p>&copy; 2024 Chuyên cung cấp thắt lưng các loại. Hotline: <a href="tel:0397526965" class="text-white">0397526965</a></p>
    </div>
  </div>
</footer>ss

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
