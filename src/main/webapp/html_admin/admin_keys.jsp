<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Quản lý khóa bảo mật</title>

  <link href="../asset/css/bootstrap.css" rel="stylesheet"/>
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

  <style><%@include file="../asset/css/style.css" %></style>
  <style><%@include file="../asset/css/custom.css" %></style>
  <style><%@include file="../asset/css/bootstrap.css" %></style>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
</head>
<body>
<div id="wrapper">

  <!-- NAVBAR -->
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
  <!-- /. NAVBAR -->

  <!-- SIDEBAR -->
  <nav class="navbar-default navbar-side" role="navigation">
    <%@ include file="/html_admin/SideBar.jsp" %>
  </nav>
  <!-- /. SIDEBAR -->

  <!-- MAIN CONTENT -->
  <div id="page-wrapper">
    <div id="page-inner">

      <div class="row">
        <div class="col-md-12">
          <h2>Quản lý khóa bảo mật</h2>
        </div>
      </div>

      <!-- FORM TẠO KHÓA -->
      <form action="${pageContext.request.contextPath}/admin_Keys" method="post" class="form-inline mb-3" style="margin: 15px 0;">
        <label for="keysize">Chọn độ dài khóa: </label>
        <select class="form-control mx-2" name="keysize" id="keysize">
          <option value="1024">1024-bit</option>
          <option value="2048">2048-bit</option>
          <option value="4096">4096-bit</option>
        </select>

        <button type="submit" name="action" value="create" class="btn btn-success">
          <i class="fa-solid fa-plus"></i> Tạo khóa mới
        </button>
      </form>

      <!-- DANH SÁCH KHÓA -->
      <div class="table-responsive">
        <table id="example" class="display table table-striped table-bordered" style="width:100%">
          <thead>
          <tr>
            <th>ID</th>
            <th>Thời gian tạo</th>
            <th>Độ dài khóa</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${keys}" var="k">
            <tr>
              <td>${k.id}</td>
              <td>${k.createdAt}</td>
              <td>${k.keySize}</td>
              <td>
                <c:choose>
                  <c:when test="${k.revoked}">
                    <span class="badge bg-danger">Đã thu hồi</span>
                  </c:when>
                  <c:otherwise>
                    <span class="badge bg-success">Đang sử dụng</span>
                  </c:otherwise>
                </c:choose>
              </td>
              <td>
                <c:if test="${!k.revoked}">
                  <form action="${pageContext.request.contextPath}/admin_Keys" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${k.id}"/>
                    <button type="submit" name="action" value="revoke" class="btn btn-danger btn-sm">
                      <i class="fa fa-ban"></i> Thu hồi
                    </button>
                  </form>
                </c:if>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>

    </div>
    <!-- /. PAGE INNER -->
  </div>
  <!-- /. PAGE WRAPPER -->

</div>
<!-- /. WRAPPER -->

<script>
  $(document).ready(function () {
    $('#example').DataTable({
      "paging": true,
      "searching": true,
      "ordering": true,
      "info": true
    });
  });
</script>
</body>
</html>
