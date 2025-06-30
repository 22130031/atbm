<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Quản lý Khóa Người Dùng</title>

  <link href="../asset/css/bootstrap.css" rel="stylesheet"/>
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

  <style><%@include file="../asset/css/style.css" %></style>
  <style><%@include file="../asset/css/custom.css" %></style>
  <style><%@include file="../asset/css/bootstrap.css" %></style>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

  <style>
    td {
      word-break: break-all;
      max-width: 200px;
    }
  </style>
</head>

<body>
<div id="wrapper">
  <div class="navbar navbar-inverse navbar-fixed-top">
    <div class="adjust-nav">
      <div class="navbar-header">
        <a class="navbar-brand" href="../home.html">Quản Lý Trang Web Thắt Lưng</a>
      </div>
      <span class="logout-spn">
        <a href="#" style="color:#fff;">Xin chào admin</a>
      </span>
    </div>
  </div>

  <nav class="navbar-default navbar-side" role="navigation">
    <%@ include file="/html_admin/SideBar.jsp" %>
  </nav>

  <div id="page-wrapper">
    <div id="page-inner">
      <div class="row">
        <div class="col-md-12">
          <h2>Danh sách khóa người dùng</h2>
        </div>
      </div>

      <table id="example" class="display" style="width:100%">
        <thead>
        <tr>
          <th>ID</th>
          <th>User ID</th>
          <th>Email mã hóa</th>
          <th>Public Key</th>
          <th>Private Key</th>
          <th>Trạng thái</th>
          <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${keyList}" var="key">
          <tr>
            <td>${key.id}</td>
            <td>${key.userId}</td>
            <td>${key.encryptedEmail}</td>
            <td>${key.publicKey}</td>
            <td>${key.privateKey}</td>
            <td>
              <c:choose>
                <c:when test="${key.lost}">
                  <span style="color: red;">Mất</span>
                </c:when>
                <c:otherwise>
                  <span style="color: green;">Bình thường</span>
                </c:otherwise>
              </c:choose>
            </td>
            <td>
              <a href="${pageContext.request.contextPath}/admin/delete-key?id=${key.id}" onclick="return confirm('Xác nhận xóa khóa?')">
                <i class="fa-solid fa-trash"></i>
              </a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>

<script>
  $(document).ready(function () {
    $('#example').DataTable({
      pageLength: 10,
      lengthMenu: [5, 10, 25, 50],
      language: {
        search: "Tìm kiếm:",
        lengthMenu: "Hiển thị _MENU_ dòng",
        info: "Hiển thị _START_ đến _END_ của _TOTAL_ dòng",
        paginate: {
          previous: "Trước",
          next: "Sau"
        }
      }
    });
  });
</script>
</body>
</html>
