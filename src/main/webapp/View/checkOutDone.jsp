<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đặt hàng thành công</title>
  <!-- Bootstrap 4 CSS -->
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <div class="card">
        <div class="card-header bg-success text-white text-center">
          <h2>Checkout Successful</h2>
        </div>
        <div class="card-body text-center">
          <p class="lead">Cảm ơn bạn đã mua hàng</p>
          <p>Đơn hàng của bạn sẽ được chúng tôi vận chuyển sớm</p>
          <a href="home.jsp" class="btn btn-primary mt-3">Về trang chủ</a>
<%--          <a href="order-details.jsp" class="btn btn-secondary mt-3">View Order Details</a>--%>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap 4 JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
