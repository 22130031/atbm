<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ký hóa đơn</title>
</head>
<body>
<h2>Ký hóa đơn</h2>

<form action="SignInvoiceServlet" method="post">
    <label>Mã đơn hàng:</label>
    <input type="text" name="orderCode" required/><br/><br/>

    <label>Tổng tiền:</label>
    <input type="number" name="totalPrice" required/><br/><br/>

    <label>Ngày đặt:</label>
    <input type="text" name="orderDate" placeholder="yyyy-MM-dd" required/><br/><br/>

    <label>Private Key (Base64):</label><br/>
    <textarea name="privateKey" rows="8" cols="80" required></textarea><br/><br/>

    <button type="submit">Ký hóa đơn</button>
</form>

<c:if test="${not empty signature}">
    <h3>Chữ ký đã tạo (Base64):</h3>
    <textarea rows="5" cols="80">${signature}</textarea>
</c:if>
</body>
</html>
