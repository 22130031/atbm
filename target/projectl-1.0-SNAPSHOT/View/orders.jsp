<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Đơn hàng</title></head>
<body>
<h2>Danh sách đơn hàng</h2>
<table border="1">
    <tr>
        <th>Mã đơn</th>
        <th>Ngày đặt</th>
        <th>Tổng tiền</th>
        <th>Trạng thái</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.orderCode}</td>
            <td>${order.orderDate}</td>
            <td>${order.totalPrice}</td>
            <td>${order.status}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
