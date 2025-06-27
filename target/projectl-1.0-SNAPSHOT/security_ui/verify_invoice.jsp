<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xác minh chữ ký hóa đơn</title>
</head>
<body>
<h2>Xác minh chữ ký hóa đơn</h2>

<form method="post" action="${pageContext.request.contextPath}/VerifyInvoiceServlet">
    <label for="orderCode">Nhập mã đơn hàng:</label>
    <input type="text" id="orderCode" name="orderCode" required />
    <button type="submit">Xác minh</button>
</form>

<br/>
<a href="${pageContext.request.contextPath}/security_ui/sign_invoice.jsp">← Quay lại ký hóa đơn</a>
</body>
</html>
