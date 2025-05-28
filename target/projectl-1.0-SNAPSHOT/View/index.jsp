<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>
    <c:if test="${sessionScope.auth ==null}">
        <h1>chua dang nhap</h1>
    </c:if>
    <c:if test="${sessionScope.auth !=null}">
        <h1>   dang nhap</h1>
    </c:if>
</h1>
<br/>
</body>
</html>