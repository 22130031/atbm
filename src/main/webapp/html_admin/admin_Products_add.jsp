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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .custom-upload-form {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: 20px auto;
        }

        .custom-upload-form .form-label {
            font-weight: bold;
            color: #333;
        }

        .custom-upload-form .form-control,
        .custom-upload-form .form-select {
            border: 1px solid #ccc;
            border-radius: 5px;
            transition: all 0.3s ease;
        }

        .custom-upload-form .form-control:focus,
        .custom-upload-form .form-select:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        .custom-upload-form .btn {
            background-color: #007bff;
            color: #fff;
            font-weight: bold;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .custom-upload-form .btn:hover {
            background-color: #0056b3;
        }

        .custom-upload-form h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
    </style>

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
                    <h2>Thêm chất liệu thắt lưng</h2>
                </div>
            </div>
            <!-- /. ROW  -->

            <form method="POST">
                <div class="mb-3">
                    <label for="price" class="form-label">Tên sản phẩm</label>
                    <input type="text" name="name" class="form-control" id="name"
                           placeholder="Loại chất liệu sản phẩm">
                </div>
                <div class="mb-3">
                    <label for="price" class="form-label">Giá</label>
                    <input type="text" name="price" class="form-control" id="price"
                           placeholder="Loại chất liệu sản phẩm">
                </div>
                <div class="mb-3">
                    <label for="description" class="form-label">Mô tả</label>
                    <input type="text" name="description" class="form-control" id="description"
                           placeholder="Loại chất liệu sản phẩm">
                </div>
                <div class="mb-3">--%>
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
                        <label for="price" class="form-label">SỐ lượng</label>
                        <input type="text" name="quantity" class="form-control" id="quantity"
                               placeholder="Loại chất liệu sản phẩm">
                    </div>
                    <div class="mb-3">
                        <label for="image">Hình ảnh:</label>
                        <input type="file" id="image" name="image" accept="image/*" required><br><br>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>

    <%--            <form class="custom-upload-form" method="POST" enctype="multipart/form-data">--%>
    <%--                    <div class="mb-3">--%>
    <%--                        <label for="name" class="form-label">Product Name:</label>--%>
    <%--                        <input type="text" class="form-control" name="name" id="name" required>--%>
    <%--                    </div>--%>
    <%--                    <div class="mb-3">--%>
    <%--                        <label for="price" class="form-label">Price:</label>--%>
    <%--                        <input type="text" class="form-control" name="price" id="price" required>--%>
    <%--                    </div>--%>
    <%--                    <div class="mb-3">--%>
    <%--                        <label for="description" class="form-label">Description:</label>--%>
    <%--                        <input type="text" class="form-control" name="description" id="description">--%>
    <%--                    </div>price--%>
    <%--                    <div class="mb-3">--%>
    <%--                        <label for="status" class="form-label">Tình trạng:</label>--%>
    <%--                        <select class="form-select" name="status" id="status">--%>
    <%--                            <option value="1">Hiện</option>--%>
    <%--                            <option value="0">Ẩn</option>--%>
    <%--                        </select>--%>
    <%--                    </div>--%>
    <%--                    <div class="mb-3">--%>
    <%--                        <label for="quantity" class="form-label">Số lượng:</label>--%>
    <%--                        <input type="number" class="form-control" name="quantity" id="quantity">--%>
    <%--                    </div>--%>
    <%--                                <div class="mb-3">--%>
    <%--                                    <label for="category" class="form-label">Chất liệu:</label>--%>
    <%--                                    <select class="form-select" name="category" id="category">--%>
    <%--                                        <c:forEach var="option" items="${categoryList}">--%>
    <%--                                            <option value="${option.getId()}">${option.getName()}</option>--%>
    <%--                                        </c:forEach>--%>
    <%--                                    </select>--%>
    <%--                    </div>--%>
    <%--                    <div class="mb-3">--%>
    <%--                        <label for="brand" class="form-label">Thương hiệu:</label>--%>
    <%--                        <select class="form-select" name="brand" id="brand">--%>
    <%--                            <c:forEach var="option" items="${brandList}">--%>
    <%--                                <option value="${option.getId()}">${option.getName()}</option>--%>
    <%--                            </c:forEach>--%>
    <%--                        </select>--%>
    <%--                    </div>--%>
    <%--                                <div class="mb-3">--%>
    <%--                                    <label for="image">Hình ảnh:</label>--%>
    <%--                                    <input type="file" id="image" name="image" accept="image/*" required><br><br>--%>
    <%--                                </div>--%>
    <%--                    <button type="submit" class="btn btn-primary w-100">Upload</button>--%>
    <%--                </form>--%>
</div>

<a href="${pageContext.request.contextPath}/admin_Products">Quay về</a>
</div>
</div>

</body>
</html>
