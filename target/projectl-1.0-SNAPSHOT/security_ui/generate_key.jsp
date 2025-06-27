<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo khóa RSA</title>
</head>
<body>
<h2>Tạo khóa RSA mới</h2>

<form action="GenerateKeyServlet" method="post">
    <label for="keysize">Chọn độ dài khóa:</label>
    <select name="keysize" id="keysize">
        <option value="1024">1024</option>
        <option value="2048" selected>2048</option>
        <option value="4096">4096</option>
    </select>
    <button type="submit">Tạo khóa</button>
</form>

<c:if test="${not empty privateKey}">
    <h3>Private Key</h3>
    <textarea rows="10" cols="80">${privateKey}</textarea>
    <h3>Public Key</h3>
    <textarea rows="10" cols="80">${publicKey}</textarea>
</c:if>
</body>
</html>
