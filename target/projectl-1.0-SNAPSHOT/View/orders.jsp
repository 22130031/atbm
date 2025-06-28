<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh sách đơn hàng</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans">
<div class="container mx-auto p-6">
    <h2 class="text-2xl font-bold mb-6 text-center text-gray-800">Danh sách đơn hàng</h2>

    <c:if test="${empty orders}">
        <div class="bg-yellow-100 text-yellow-800 p-4 rounded shadow text-center">
            Không có đơn hàng nào.
        </div>
    </c:if>

    <c:if test="${not empty orders}">
        <div class="overflow-x-auto">
            <table class="min-w-full bg-white border border-gray-300 rounded shadow text-center">
                <thead>
                <tr class="bg-gray-200 text-gray-700">
                    <th class="p-3 border">STT</th>
                    <th class="p-3 border">Mã đơn hàng</th>
                    <th class="p-3 border">Tổng tiền</th>
                    <th class="p-3 border">Ngày đặt</th>
                    <th class="p-3 border">Trạng thái</th>
                    <th class="p-3 border">Đã ký</th>
                    <th class="p-3 border">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${orders}" varStatus="loop">
                    <tr class="hover:bg-gray-50">
                        <td class="p-3 border">${loop.index + 1}</td>
                        <td class="p-3 border text-blue-800 font-medium">${order.orderCode}</td>
                        <td class="p-3 border">${order.totalPrice} đ</td>
                        <td class="p-3 border">${order.orderDate}</td>
                        <td class="p-3 border">
                            <c:choose>
                                <c:when test="${order.status == 1}">Mới</c:when>
                                <c:when test="${order.status == 2}">Đã giao</c:when>
                                <c:otherwise>Không rõ</c:otherwise>
                            </c:choose>
                        </td>
                        <td class="p-3 border">
                            <c:choose>
                                <c:when test="${order.signed}">✔️</c:when>
                                <c:otherwise>❌</c:otherwise>
                            </c:choose>
                        </td>
                        <td class="p-3 border">
                            <a href="${pageContext.request.contextPath}/order-details?id=${order.id}"
                               class="text-blue-500 hover:underline">Xem</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>
