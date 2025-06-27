<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chỉnh sửa đơn hàng</title>
</head>
<body>
<h2>Chỉnh sửa đơn hàng</h2>
<form method="post" action="${pageContext.request.contextPath}/admin_Order/edit">
    <input type="hidden" name="id" value="${order.id}" />

    <label for="userId">ID Người dùng:</label>
    <input type="text" name="userId" id="userId" value="${order.userId}" required /><br/><br/>

    <label for="orderCode">Mã đơn hàng:</label>
    <input type="number" name="orderCode" id="orderCode" value="${order.orderCode}" required /><br/><br/>

    <label for="totalPrice">Tổng tiền:</label>
    <input type="number" name="totalPrice" id="totalPrice" value="${order.totalPrice}" required /><br/><br/>

    <label for="status">Trạng thái:</label>
    <select name="status" id="status" required>
        <option value="1" ${order.status == 1 ? "selected" : ""}>Mới đặt</option>
        <option value="2" ${order.status == 2 ? "selected" : ""}>Đã giao</option>
        <option value="3" ${order.status == 3 ? "selected" : ""}>Đã hủy</option>
    </select><br/><br/>

    <button type="submit">Cập nhật</button>
</form>
<br/>
<a href="${pageContext.request.contextPath}/admin_Orders">← Quay lại danh sách đơn hàng</a>
</body>
</html>
