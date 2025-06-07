<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Quản lý hóa đơn</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        table { box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        th, td { text-align: center; }
    </style>
</head>
<body class="bg-gray-100 font-sans">
<div class="container mx-auto p-6">
    <h2 class="text-2xl font-bold mb-4 text-center">Quản lý hóa đơn</h2>

    <!-- Bộ lọc và tìm kiếm -->
    <div class="flex justify-between mb-4">
        <div class="flex space-x-4">
            <select id="filterStatus" name="filter" class="border rounded p-2" onchange="filterInvoices()">
                <option value="all" ${param.filter == 'all' || empty param.filter ? 'selected' : ''}>Tất cả</option>
                <option value="signed" ${param.filter == 'signed' ? 'selected' : ''}>Đã ký</option>
                <option value="unsigned" ${param.filter == 'unsigned' ? 'selected' : ''}>Chưa ký</option>
            </select>
            <input id="searchInput" type="text" placeholder="Tìm kiếm mã hóa đơn..." class="border rounded p-2" value="${param.search}">
            <button onclick="searchInvoices()" class="bg-gray-500 text-white px-4 py-2 rounded hover:bg-gray-600">Tìm</button>
        </div>
        <button onclick="signSelectedInvoices()" class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">Ký hóa đơn</button>
    </div>

    <!-- Bảng hóa đơn -->
    <div class="overflow-x-auto">
        <table class="min-w-full bg-white border">
            <thead>
            <tr class="bg-gray-200">
                <th class="p-2 border"><input type="checkbox" id="selectAll" onclick="toggleSelectAll()"></th>
                <th class="p-2 border">STT</th>
                <th class="p-2 border">Mã hóa đơn</th>
                <th class="p-2 border">Tổng tiền</th>
                <th class="p-2 border">Ngày đặt</th>
                <th class="p-2 border">Đã ký</th>
                <th class="p-2 border">Trạng thái</th>
                <th class="p-2 border">Thao tác</th>
            </tr>
            </thead>
            <tbody id="invoiceTableBody">
            <c:forEach var="order" items="${OrderList}" varStatus="loop">
                <tr>
                    <td class="p-2 border"><input type="checkbox" name="selectedOrders" value="${order.id}" class="selectInvoice"></td>
                    <td class="p-2 border">${loop.index + 1}</td>
                    <td class="p-2 border">${order.orderCode}</td>
                    <td class="p-2 border">${order.totalPrice} đ</td>
                    <td class="p-2 border">${order.orderDate}</td>
                    <td class="p-2 border">
                        <c:choose>
                            <c:when test="${order.signed}">Đã ký</c:when>
                            <c:otherwise>Chưa ký</c:otherwise>
                        </c:choose>
                    </td>
                    <td class="p-2 border">
                        <c:choose>
                            <c:when test="${order.status == 1}">Mới</c:when>
                            <c:when test="${order.status == 2}">Đã giao</c:when>
                        </c:choose>
                    </td>
                    <td class="p-2 border">
                        <a href="order-details?id=${order.id}" class="text-blue-500 hover:underline">Xem chi tiết</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script>
    function toggleSelectAll() {
        const selectAll = document.getElementById("selectAll");
        document.querySelectorAll(".selectInvoice").forEach(checkbox => {
            checkbox.checked = selectAll.checked;
        });
    }

    function signSelectedInvoices() {
        const selected = Array.from(document.querySelectorAll(".selectInvoice:checked"))
            .map(checkbox => checkbox.value);
        if (selected.length === 0) {
            alert("Vui lòng chọn ít nhất một hóa đơn để ký!");
            return;
        }
        window.location.href = "orders?action=sign&ids=" + selected.join(",");
    }

    function filterInvoices() {
        const filter = document.getElementById("filterStatus").value;
        const search = document.getElementById("searchInput").value;
        window.location.href = "orders?filter=" + filter + "&search=" + encodeURIComponent(search);
    }

    function searchInvoices() {
        filterInvoices();
    }
</script>
</body>
</html>