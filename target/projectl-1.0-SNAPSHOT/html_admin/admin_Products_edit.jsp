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
                    <h2>Thêm loại thắt lưng</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <form method="POST">
                <div class="mb-3">
                    <label for="name" class="form-label">Tên loại thắt lưng</label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="Loại sản phẩm"
                           value="${product.getName()}">
                </div>
                <div class="mb-3">
                    <label for="price" class="form-label">Giá</label>
                    <input type="text" name="price" class="form-control" id="price" placeholder="Loại sản phẩm"
                           value="${product.getPrice()}">
                </div>
                <div class="mb-3">
                    <label for="price" class="form-label">SỐ lượng</label>
                    <input type="text" name="quantity" class="form-control" id="quantity"
                           placeholder="Loại chất liệu sản phẩm" value="${product.getQuantity()}">
                </div>
                <div class="mb-3">
                    <label for="description" class="form-label">Mô tả</label>
                    <input type="text" name="description" class="form-control" id="description"
                           value="${product.getDescription()}">
                </div>
                <div class="mb-3">
                    <label for="status" class="form-label">Tình trạng:</label>
                    <select class="form-select" name="status" id="status">
                        <option value="1">Hiện</option>
                        <option value="0">Ẩn</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="brand" class="form-label">Thương hiệu</label>
                    <select class="form-select" name="brand" id="brand">
                        <c:forEach var="option" items="${brandList}">
                            <option value="${option.getId()}">${option.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="category" class="form-label">Loại</label>
                    <select class="form-select" name="category" id="category">
                        <c:forEach var="option" items="${categoryList}">
                            <option value="${option.getId()}">${option.getName()}</option>
                        </c:forEach>
                    </select>

                    <div class="mb-3">

                        <label for="image">Hình ảnh:</label>
                        <input type="file" id="image" name="image" accept="image/*" required><br><br>
                        <img style="width: 80px; height: auto" src="../images/${product.getImage()}" alt="">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
            <a href="${pageContext.request.contextPath}/admin_Products">Quay về</a>
        </div>
    </div>
</div>
</body>
</html>
