<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sửa đơn hàng</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f7f7f7; padding: 30px; }
        form {
            width: 400px;
            margin: auto;
            padding: 20px;
            background: white;
            border-radius: 6px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 { text-align: center; }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }
        .btn-submit {
            width: 100%;
            padding: 10px;
            background: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-submit:hover {
            background: #218838;
        }
    </style>
</head>
<body>

<h2>Sửa đơn hàng</h2>

<form action="${pageContext.request.contextPath}/admin_Order/edit" method="post">
    <input type="hidden" name="id" value="${order.id}" />

    <label>User ID:</label>
    <input type="text" name="userId" value="${order.userId}" required />

    <label>Mã đơn hàng:</label>
    <input type="number" name="orderCode" value="${order.orderCode}" required />

    <label>Tổng tiền:</label>
    <input type="number" name="totalPrice" value="${order.totalPrice}" required />

    <label>Trạng thái ký:</label>
    <select name="signed">
        <option value="true" ${order.signed ? "selected" : ""}>Đã ký</option>
        <option value="false" ${!order.signed ? "selected" : ""}>Chưa ký</option>
    </select>

    <label>Trạng thái đơn hàng:</label>
    <select name="status">
        <option value="1" ${order.status == 1 ? "selected" : ""}>Mới</option>
        <option value="2" ${order.status == 2 ? "selected" : ""}>Đã giao</option>
        <option value="3" ${order.status == 3 ? "selected" : ""}>Khác</option>
    </select>

    <button type="submit" class="btn-submit">Cập nhật</button>
</form>

</body>
</html>
