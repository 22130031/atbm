<%--
  Created by IntelliJ IDEA.
  User: mcuon
  Date: 5/29/2025
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Lịch sử mua hàng</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      padding: 40px;
      background-color: #f8f9fa;
    }

    h2 {
      text-align: center;
      margin-bottom: 30px;
      font-size: 28px;
      color: #333;
    }

    .filter-buttons {
      text-align: center;
      margin-bottom: 30px;
    }

    .btn-filter {
      margin: 0 10px;
      padding: 10px 18px;
      background-color: #007bff;
      color: white;
      text-decoration: none;
      border: none;
      border-radius: 6px;
      font-size: 16px;
      cursor: pointer;
    }

    .btn-filter.active {
      background-color: #0056b3;
    }

    .table-container {
      width: 90%;
      margin: auto;
      background-color: white;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      overflow: hidden;
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }

    thead {
      background-color: #e9ecef;
    }

    th, td {
      padding: 14px;
      border-bottom: 1px solid #dee2e6;
      text-align: center;
      font-size: 16px;
    }

    th {
      font-weight: bold;
    }

    input[type="checkbox"] {
      transform: scale(1.2);
      cursor: pointer;
    }

    p.empty-message {
      text-align: center;
      margin-top: 20px;
      font-style: italic;
      color: #666;
    }
  </style>
</head>
<body>

<h2>Lịch sử mua hàng</h2>

<div class="filter-buttons">
  <a href="${pageContext.request.contextPath}/history?filter=all" class="btn-filter ${filter == 'all' ? 'active' : ''}">Tất cả</a>
  <a href="${pageContext.request.contextPath}/history?filter=signed" class="btn-filter ${filter == 'signed' ? 'active' : ''}">Đã ký</a>
  <a href="${pageContext.request.contextPath}/history?filter=unsigned" class="btn-filter ${filter == 'unsigned' ? 'active' : ''}">Chưa ký</a>
</div>

<div class="table-container">
  <c:if test="${not empty historyList}">
    <table>
      <thead>
      <tr>
        <th>STT</th>
        <th>Chọn</th>
        <th>Mã đơn hàng</th>
        <th>Ngày đặt</th>
        <th>Tổng tiền</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="order" items="${historyList}" varStatus="loop">
        <tr>
          <td>${loop.index + 1}</td>
          <td><input type="checkbox" name="selectedOrders" value="${order.orderId}" /></td>
          <td>${order.orderId}</td>
          <td>${order.orderDate}</td>
          <td>${order.totalPrice} đ</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>

  <c:if test="${empty historyList}">
    <p class="empty-message">Không có đơn hàng nào phù hợp.</p>
  </c:if>
</div>

</body>
</html>


