<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý khóa</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-6 font-sans">
<h2 class="text-2xl font-bold mb-4">Khóa đã tạo</h2>
<c:forEach var="key" items="${keys}">
    <div class="bg-white rounded shadow p-4 mb-4">
        <p><strong>Key ID:</strong> ${key.id}</p>
        <p><strong>Kích thước:</strong> ${key.keySize} bit</p>
        <p><strong>Ngày tạo:</strong> ${key.createdAt}</p>
        <p><strong>Public Key:</strong></p>
        <textarea readonly rows="4" class="w-full p-2 border border-gray-300 rounded">${key.publicKey}</textarea>
        <p><strong>Private Key:</strong></p>
        <textarea readonly rows="4" class="w-full p-2 border border-gray-300 rounded">${key.privateKey}</textarea>
    </div>
</c:forEach>

<a href="${pageContext.request.contextPath}/profile" class="text-blue-500 hover:underline">← Quay lại hồ sơ</a>
</body>
</html>
