<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh sách đơn hàng</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f7f7f7; padding: 20px; }
        h2 { text-align: center; }
        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #f0f0f0;
        }
        .btn-edit {
            padding: 6px 12px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<h2>Quản lý đơn hàng</h2>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>User ID</th>
        <th>Mã đơn hàng</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
        <th>Đã ký</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${OrderList}">
        <tr>
            <td>${order.id}</td>
            <td>${order.userId}</td>
            <td>${order.orderCode}</td>
            <td>${order.totalPrice} đ</td>
            <td>${order.orderDate}</td>
            <td>
                <c:choose>
                    <c:when test="${order.signed}">Đã ký</c:when>
                    <c:otherwise>Chưa ký</c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${order.status == 1}">Mới</c:when>
                    <c:when test="${order.status == 2}">Đã giao</c:when>
                    <c:otherwise>Khác</c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/admin_Order/edit?id=${order.id}" class="btn-edit">Sửa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
