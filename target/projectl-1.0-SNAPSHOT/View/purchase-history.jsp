<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Lịch sử mua hàng</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      padding: 40px;
      background-color: #f8f9fa;
    }

    h2 {
      text-align: center;
      margin-bottom: 30px;
      color: #333;
    }

    table {
      width: 90%;
      margin: auto;
      border-collapse: collapse;
      background: white;
      border-radius: 8px;
      box-shadow: 0 0 8px rgba(0,0,0,0.1);
    }

    th, td {
      padding: 14px;
      border-bottom: 1px solid #ddd;
      text-align: center;
    }

    thead {
      background-color: #e9ecef;
    }

    .btn-comment {
      padding: 6px 12px;
      background-color: #ffc107;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

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

    .popup textarea {
      resize: vertical;
    }

    .btn-submit {
      margin-top: 15px;
      background-color: #28a745;
      color: white;
      border: none;
      padding: 8px 14px;
      border-radius: 4px;
      cursor: pointer;
    }

    .btn-cancel {
      margin-top: 15px;
      background-color: #dc3545;
      color: white;
      border: none;
      padding: 8px 14px;
      border-radius: 4px;
      margin-left: 10px;
      cursor: pointer;
    }
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
<body>

<h2>Lịch sử mua hàng</h2>

<table>
  <thead>
  <tr>
    <th>STT</th>
    <th>Mã đơn hàng</th>
    <th>Sản phẩm</th>
    <th>Số lượng</th>
    <th>Giá</th>
    <th>Bình luận</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="item" items="${historyList}" varStatus="loop">
    <tr>
      <td>${loop.index + 1}</td>
      <td>${item.order_id}</td>
      <td>${item.productName}</td>
      <td>${item.quantity}</td>
      <td>${item.price} đ</td>
      <td>
        <button class="btn-comment"
                onclick="showPopup(${item.product_id}, '${item.productName}')">
          Bình luận
        </button>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

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

      <button type="submit" class="btn-submit">Gửi Đánh Giá</button>
      <button type="button" class="btn-cancel" onclick="hidePopup()">Hủy</button>
    </form>
  </div>
</div>

</body>
</html>
