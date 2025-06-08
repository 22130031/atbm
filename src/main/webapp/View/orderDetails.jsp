<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Chi tiết hóa đơn</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <style>
    table { box-shadow: 0 0 10px rgba(0,0,0,0.1); }
    th, td { text-align: center; }
    .popup-overlay {
      display: none;
      position: fixed;
      top: 0; left: 0;
      width: 100%; height: 100%;
      background-color: rgba(0, 0, 0, 0.4);
      z-index: 1000;
    }
    .popup {
      position: absolute;
      top: 50%; left: 50%;
      transform: translate(-50%, -50%);
      background-color: white;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 0 10px #000;
      width: 420px;
    }
    .popup label {
      display: block;
      margin-top: 10px;
      font-weight: bold;
    }
    .popup input[type="text"],
    .popup select,
    .popup textarea {
      width: 100%;
      padding: 10px;
      margin-top: 5px;
      border: 1px solid #ccc;
      border-radius: 6px;
      font-size: 14px;
    }
    .popup textarea { resize: vertical; }
  </style>
  <script>
    function showPopup(productId, productName) {
      document.getElementById("popupOverlay").style.display = "block";
      document.getElementById("productIdInput").value = productId;
      document.getElementById("popupTitle").innerText = productName;
    }
    function hidePopup() {
      document.getElementById("popupOverlay").style.display = "none";
    }
  </script>
</head>
<body class="bg-gray-100 font-sans">
<div class="container mx-auto p-6">
  <h2 class="text-2xl font-bold mb-4 text-center">Chi tiết hóa đơn</h2>
  <div class="bg-white p-6 rounded shadow mb-6">
    <p><strong>Mã hóa đơn:</strong> ${order.orderCode}</p>
    <p><strong>Tổng tiền:</strong> ${order.totalPrice} đ</p>
    <p><strong>Ngày đặt:</strong> ${order.orderDate}</p>
    <p><strong>Đã ký:</strong> ${order.signed ? 'Đã ký' : 'Chưa ký'}</p>
    <p><strong>Trạng thái:</strong>
      <c:choose>
        <c:when test="${order.status == 1}">Mới</c:when>
        <c:when test="${order.status == 2}">Đã giao</c:when>
      </c:choose>
    </p>
  </div>

  <!-- Bảng chi tiết hóa đơn -->
  <div class="overflow-x-auto">
    <table class="min-w-full bg-white border">
      <thead>
      <tr class="bg-gray-200">
        <th class="p-2 border">STT</th>
        <th class="p-2 border">Sản phẩm</th>
        <th class="p-2 border">Số lượng</th>
        <th class="p-2 border">Giá</th>
        <th class="p-2 border">Bình luận</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="detail" items="${orderDetails}" varStatus="loop">
        <tr>
          <td class="p-2 border">${loop.index + 1}</td>
          <td class="p-2 border">${detail.productName}</td>
          <td class="p-2 border">${detail.quantity}</td>
          <td class="p-2 border">${detail.price} đ</td>
          <td class="p-2 border">
            <button class="bg-yellow-500 text-white px-4 py-2 rounded hover:bg-yellow-600"
                    onclick="showPopup(${detail.product_id}, '${detail.productName}')">
              Bình luận
            </button>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <a href="orders" class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 mt-4 inline-block">Quay lại</a>

  <!-- Popup bình luận -->
  <div id="popupOverlay" class="popup-overlay">
    <div class="popup">
      <form action="${pageContext.request.contextPath}/review" method="post">
        <h3>Bình luận sản phẩm: <span id="popupTitle"></span></h3>
        <input type="hidden" name="pid" id="productIdInput" />
        <label for="reviews-rating">Đánh Giá (1–5 Sao):</label>
        <select name="rating" id="reviews-rating" required>
          <option value="5">5 Sao</option>
          <option value="4">4 Sao</option>
          <option value="3">3 Sao</option>
          <option value="2">2 Sao</option>
          <option value="1">1 Sao</option>
        </select>
        <label for="reviews-url">Hình Ảnh/Video (URL):</label>
        <input type="text" name="url" id="reviews-url" placeholder="URL hình ảnh hoặc video">
        <label for="reviews-text">Nội Dung Đánh Giá:</label>
        <textarea name="reviewText" id="reviews-text" rows="4" placeholder="Viết đánh giá của bạn..." required></textarea>
        <button type="submit" class="bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600 mt-4">Gửi Đánh Giá</button>
        <button type="button" class="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600 mt-4 ml-2" onclick="hidePopup()">Hủy</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>