<%--
  Created by IntelliJ IDEA.
  User: mcuon
  Date: 4/13/2025
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sản Phẩm Yêu Thích</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .product-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }
        .product-card {
            border: 1px solid #ddd;
            padding: 10px;
            width: 200px;
            text-align: center;
        }
        .product-card img {
            max-width: 100%;
            height: auto;
        }
        .product-card h3 {
            font-size: 18px;
            margin: 10px 0;
        }
        .product-card p {
            color: #555;
        }
        .remove-btn {
            background-color: #ff4444;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
        .remove-btn:hover {
            background-color: #cc0000;
        }
    </style>
</head>
<body>
<h1>Sản Phẩm Yêu Thích</h1>

<c:if test="${sessionScope.auth == null}">
    <p>Vui lòng <a href="${pageContext.request.contextPath}/login">Đăng nhập</a> để xem sản phẩm yêu thích.</p>
</c:if>

<c:if test="${sessionScope.auth != null}">
    <c:if test="${empty favoriteProducts}">
        <p>Bạn chưa có sản phẩm yêu thích nào.</p>
    </c:if>

    <div class="product-container">
        <c:forEach var="favorite" items="${favoriteProducts}">
            <div class="product-card">
                <img src="${favorite.imageUrl}" alt="${favorite.productName}">
                <h3>${favorite.productName}</h3>
                <form action="${pageContext.request.contextPath}/remove-favorite" method="post">
                    <input type="hidden" name="productId" value="${favorite.productId}">
                    <input type="hidden" name="userId" value="${sessionScope.auth.id}">
                    <button type="submit" class="remove-btn">Xóa</button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>
</body>
</html>
