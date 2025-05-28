<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Simple Responsive Admin</title>

    <link href="../asset/css/bootstrap.css" rel="stylesheet"/>

    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <style>
        <%@include file="../asset/css/style.css" %>
    </style>
    <style>
        <%@include file="../asset/css/custom.css" %>
    </style>
    <style>
        <%@include file="../asset/css/bootstrap.css" %>
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">


</head>
<body>


<div id="wrapper">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="adjust-nav">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="../home.html">Quản Lý Trang Web Thắt Lưng</a>
            </div>

            <span class="logout-spn">
                  <a href="#" style="color:#fff;">Xin chào admin</a>

                </span>
        </div>
    </div>
    <!-- /. NAV TOP  -->

    <nav class="navbar-default navbar-side" role="navigation">
        <%@ include file="/html_admin/SideBar.jsp" %>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2>Cập nhật đơn hàng</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <form method="POST">
                <label for="id"></label>
                <input type="text" id="id" name="id" value="${order.getId()}"  readonly><br><br>

                <div class="mb-3">
                    <label for="name" class="form-label">Tên loại thắt lưng</label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="Loại sản phẩm" value="${order.getName()}">
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Số điện thoại</label>
                    <input type="text" name="phone" class="form-control" id="phone" placeholder="Loại sản phẩm" value="${order.getphone()}">
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Địa chỉ</label>
                    <input type="text" name="address" class="form-control" id="address" placeholder="Địa chỉ" value="${order.getAddress()}">
                </div>
                <div class="mb-3">
                    <label for="status"  class="form-label">Tình trạng:</label>
                    <select class="form-select"  name="status" id="status">
                        <option value=1>Chờ xác thực</option>
                        <option value=0>Đang vận chuyển</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">Tổng tiền</label>
                    <input type="number" name="total" class="form-control" id="total" placeholder="Loại sản phẩm" value="${order.getTotal_amount()}">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <a href="${pageContext.request.contextPath}/admin_Orders">Quay về</a>
        </div>
    </div>
</div>
</body>
</html>
