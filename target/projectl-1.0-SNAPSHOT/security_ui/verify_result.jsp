<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Kết quả xác minh chữ ký</title>
</head>
<body>
<h2>Kết quả xác minh đơn hàng: ${orderCode}</h2>

<c:choose>
    <c:when test="${isValid}">
        ✅ <strong style="color:green">Chữ ký HỢP LỆ</strong>
    </c:when>
    <c:otherwise>
        ❌ <strong style="color:red">Chữ ký KHÔNG hợp lệ</strong>
    </c:otherwise>
</c:choose>

<br/><br/>
<a href="${pageContext.request.contextPath}/security_ui/verify_invoice.jsp">← Quay lại xác minh khác</a>
</body>
</html>
