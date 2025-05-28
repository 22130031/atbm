<%--
  Created by IntelliJ IDEA.
  User: BAO ANH
  Date: 12/20/2024
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Simple Responsive Admin</title>

<%--        <link href="D:\Java\testGit\projectltw\src\main\webapp\View\asset\css\bootstrap.css" rel="stylesheet"/>--%>
<%--        <style><%@include file="../asset/fontawsome/fontawsome/css/all.css"%></style>--%>
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <style><%@include file="../asset/css/style.css"%></style>
    <style><%@include file="../asset/css/custom.css"%></style>
    <style><%@include file="../asset/css/bootstrap.css"%></style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">


</head>
<body>
<!--FORM-->
<div class="modal js-modal">


    <form class="form__content" action="" method="POST">
        <div class="form__title">
            <button class="js-modal-close">Đóng</button>
            <h3>Chỉnh sửa thông tin user</h3>

        </div>
        <label for="email">Email</label>
        <div class="form__item">
            <input type="email" id="email" name="email" required placeholder="Email"><br>
        </div>
        <label for="email">Tên người dùng</label>
        <div class="form__item">
            <input type="email" id="name" name="email" required><br>
        </div>
        <label for="matkhau">Mật khẩu</label>
        <div class="form__item">

            <input type="text" id="matkhau" name="pass" required><br>
        </div>
        <label for="phone">Số Điện Thoại:</label>
        <div class="form__item">

            <input type="text" id="phone" name="phone" required><br>
        </div>
        <div class="commit">
            <button>Xác nhận</button>
        </div>
    </form>
</div>
<div id="wrapper">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="adjust-nav">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="../html/home.jsp">
                    Trang chủ
                </a>
            </div>

            <span class="logout-spn">
                  <a href="#" style="color:#fff;">Đăng xuất</a>

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
                    <h2>Trang USER</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <label>
                <input class="search__input" type="text" name="" placeholder="Nhập email, sdt,.. ">
            </label>

            <button class="search__submit">
                <i class="fa-solid fa-magnifying-glass"></i>
                <span>Tìm kiếm</span>
            </button>
            <table class="table table-striped">
                <thead style="background:#5cb85c">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Tên Tài Khoản</th>
                    <th scope="col">Email</th>
                    <th scope="col">Mật khẩu</th>
                    <th scope="col">Số điện thoại</th>
                    <th scope="col">Loại tài khoản</th>
                    <th scope="col">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Nguyễn Văn A</td>
                    <td>abc@yahoo.com</td>
                    <td>132</td>
                    <td>09123</td>
                    <td>admin</td>
                    <td>
                        <button class="btn js-edit"><i class="fa-solid fa-pen-to-square fa_in_admin"></i></button>
                        <button class="btn js-edit"><i class="fa-solid fa-trash fa_in_admin"></i></button>
                    </td>
                </tr>
                </tbody>
            </table>

            <!-- /. ROW  -->
        </div>

    </div>

</div>
<script>
    const editBtns = document.querySelectorAll('.js-edit')
    const modal = document.querySelector('.js-modal')
    const modalClose = document.querySelector('.js-modal-close')

    function showForm() {
        modal.classList.add('open')
    }

    function hideForm() {
        modal.remove('open')
    }

    for (const editBtn of editBtns) {
        editBtn.addEventListener('click', showForm)
    }
    modalClose.addEventListener('click', hideForm)
</script>
</body>
<!--c-->

</html>

