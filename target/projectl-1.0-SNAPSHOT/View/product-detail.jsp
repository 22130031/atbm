<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/20/2024
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi Tiết Sản Phẩm</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        <%@include file="../css/footer.css" %>
    </style>
    <style>
        <%@include file="../css/header.css" %>
    </style>
    <style>
        <%@include file="../css/ProductDetail.css" %>
    </style>
</head>
<body>

<!-- Header -->
<header>
    <div class="header">
        <a href="${pageContext.request.contextPath}/home"><h1>Trang chủ</h1></a>
        <div class="menu">
            <div class="dropdown">
                <a href="${pageContext.request.contextPath}/home">Danh mục sản phẩm</a>
                <div class="dropdown-content">
                    <a href="#">Thắt lưng nam</a>
                    <a href="#">Thắt lưng nữ</a>
                </div>
            </div>
            <a href="#">Giới thiệu</a>
            <a href="#">Chính sách</a>
            <a href="#">Liên hệ</a>
        </div>
        <div class="icons">
            <form action="${pageContext.request.contextPath}/search" method="get">
                <div class="search-container">
                    <div class="search-box">
                        <button class="search-icon">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                        <label>
                            <input type="text" class="search-input" name="search" placeholder="Search..">
                        </label>
                    </div>
                </div>
            </form>
            <c:if test="${sessionScope.auth ==null}">
                <div class="dropdown-user">
                    <a href="#"><i class="fa-solid fa-user"></i></a>
                    <div class="dropdown-content-user">
                        <a href="${pageContext.request.contextPath}/login"/>">Đăng nhập</a>
                    </div>
                </div>
            </c:if>
            <c:if test="${sessionScope.auth !=null}">
                <div class="dropdown-user">
                    <a href="<c:url value='/View/profile.jspe.jsp'/>">
                        <img src="${pageContext.request.contextPath}/${sessionScope.auth.image}" alt="Avatar"
                             style="width: 30px; height: 30px; border-radius: 50%;">
                    </a>
                    <div class="dropdown-content-user">
                        <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
                    </div>
                </div>
                <a href=${pageContext.request.contextPath}/Cart?action=showCart><i class="fa-solid fa-cart-shopping"></i></a>
            </c:if>
        </div>
    </div>
</header>

<!-- Product Detail Section -->
<div class="product-detail">
    <!-- Ảnh Sản Phẩm -->
    <div class="product-image">
        <img src="${pd.image}" alt="${pd.name}">
    </div>

    <!-- Thông Tin Sản Phẩm -->
    <div class="product-info">
        <h2>${pd.name}</h2>
        <p class="price"><fmt:formatNumber value="${pd.price}"/> </p>
        <!-- Chọn Màu Sắc -->
        <div class="color-options">
            <p>Chọn Màu Sắc:</p>
            <div class="color-choices">
                <button class="option-btn color-btn" data-color="Đen">
                    <img src="https://down-vn.img.susercontent.com/file/vn-11134207-7ra0g-m6mcojrgkaxk4b.webp" alt="Đen" class="option-image" width="20" height="20">
                    <span>Đen</span>
                </button>
                <button class="option-btn color-btn" data-color="Nâu">
                    <img src="https://down-vn.img.susercontent.com/file/vn-11134207-7ras8-m5hcmz4l3mdfbf.webp" alt="Nâu" class="option-image" width="20" height="20">
                    <span>Nâu</span>
                </button>
            </div>
            <p>Màu đã chọn: <span id="selected-color">Chưa chọn</span></p>
        </div>

        <!-- Chọn Kích Cỡ -->
        <div class="size-options">
            <p>Chọn Kích Cỡ:</p>
            <div class="size-choices">
                <button class="option-btn size-btn" data-size="S">
                    <img src="https://down-vn.img.susercontent.com/file/vn-11134207-7ras8-m5hcmz4l3mdfbf.webp" alt="S" class="option-image" width="20" height="20">
                    <span>S</span>
                </button>
                <button class="option-btn size-btn" data-size="M">
                    <img src="https://down-vn.img.susercontent.com/file/vn-11134207-7ras8-m5hcmz4l3mdfbf.webp" alt="M" class="option-image" width="20" height="20">
                    <span>M</span>
                </button>
                <button class="option-btn size-btn" data-size="L">
                    <img src="https://down-vn.img.susercontent.com/file/vn-11134207-7ras8-m5hcmz4l3mdfbf.webp" alt="L" class="option-image" width="20" height="20">
                    <span>L</span>
                </button>
                <button class="option-btn size-btn" data-size="XL">
                    <img src="https://down-vn.img.susercontent.com/file/vn-11134207-7ras8-m5hcmz4l3mdfbf.webp" alt="XL" class="option-image" width="20" height="20">
                    <span>XL</span>
                </button>
            </div>
            <p>Kích cỡ đã chọn: <span id="selected-size">Chưa chọn</span></p>
        </div>
        <!-- Điều chỉnh số lượng -->
        <div class="quantity-options">
            <p>Số Lượng:</p>
            <div class="quantity-control">
                <button type="button" class="quantity-decrease">-</button>
                <label>
                    <input type="text" value="1" class="quantity-input">
                </label>
                <button type="button" class="quantity-increase">+</button>
                <span class="available-stock">${pd.quantity} sản phẩm có sẵn</span>
            </div>
        </div>
        <div class="action-buttons">
            <button class="add-to-cart">Thêm Vào Giỏ Hàng</button>
            <button class="buy-now">Mua Ngay</button>
        </div>
        <p class="description">
            Thắt lưng làm từ da thật, thiết kế cổ điển, phù hợp với mọi lứa tuổi và phong cách. Độ bền cao, không bong tróc, mang đến vẻ ngoài sang trọng.
        </p>
        <c:choose>
            <c:when test="${empty sessionScope.auth}">
                <a href="${pageContext.request.contextPath}/login"><button class="favorite-btn">Yêu Thích</button></a>
            </c:when>
            <c:otherwise>
                <form action="${pageContext.request.contextPath}/add-favorite" method="post">
                    <input type="hidden" name="productId" value="${pd.id}">
                    <input type="hidden" name="productName" value="${pd.name}">
                    <input type="hidden" name="imageUrl" value="${pd.image}">
                    <input type="hidden" name="userId" value="${sessionScope.auth.id}">
                    <button type="submit" class="favorite-btn"><i class="fa-solid fa-heart"></i>Yêu Thích</button>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div class="reviews-section">
    <h3>ĐÁNH GIÁ SẢN PHẨM</h3>
    <div class="reviews-summary">
        <div class="reviews-average-rating">
            <span class="reviews-rating-score">5.0</span>
            <span class="reviews-rating-text">trên 5</span>
            <div class="reviews-stars">★★★★★</div>
        </div>
        <form action="${pageContext.request.contextPath}/rfilter" method="get">
            <div class="reviews-rating-filters">
                <input type="hidden" name="pid" value="${pd.id}">
                <button name="filter" value="tatca" class="reviews-filter-btn active">Tất Cả</button>
                <button name="filter" value="5" class="reviews-filter-btn">5 Sao </button>
                <button name="filter" value="4" class="reviews-filter-btn">4 Sao </button>
                <button name="filter" value="3" class="reviews-filter-btn">3 Sao </button>
                <button name="filter" value="2" class="reviews-filter-btn">2 Sao </button>
                <button name="filter" value="1" class="reviews-filter-btn">1 Sao </button>
                <button name="filter" value="Comment" class="reviews-filter-btn">Có Bình Luận</button>
                <button name="filter" value="Img" class="reviews-filter-btn">Có Hình Ảnh / Video</button>
            </div>
        </form>
    </div>
    <c:forEach var="r" items="${reviews}">
        <div class="reviews-item">
            <div class="reviews-header">
                <img src="${r.uimg}" alt="User Avatar" class="reviews-user-avatar">
                <div class="reviews-info">
                    <span class="reviews-username">${r.username}</span>
                    <span class="reviews-stars">
                <c:forEach var="i" begin="1" end="${r.rating}">
                    ★
                </c:forEach>
                </span>
                    <span class="reviews-date">${r.reviewDate}</span>
                </div>
            </div>
            <div class="reviews-content">
                <p> ${r.reviewText}</p>
                <img src="${r.url}" alt="Review Image" class="review-image">
            </div>
        </div>
    </c:forEach>
    <!-- Add Review Section -->
    <div class="reviews-add-review">
        <h4>Thêm Đánh Giá</h4>
        <form action="${pageContext.request.contextPath}/review" method="post">
            <input type="hidden" name="pid" value="${pd.id}">
            <label for="reviews-rating">Đánh Giá (1-5 Sao):</label>
            <select name="rating" id="reviews-rating">
                <option value="5">5 Sao</option>
                <option value="4">4 Sao</option>
                <option value="3">3 Sao</option>
                <option value="2">2 Sao</option>
                <option value="1">1 Sao</option>
            </select>

            <label for="reviews-url">Hình Ảnh, Video:</label>
            <input type="text" name="url" id="reviews-url" placeholder="URL hình ảnh hoặc video">

            <label for="reviews-text">Nội Dung Đánh Giá:</label>
            <textarea name="reviewText" id="reviews-text" rows="4" placeholder="Viết đánh giá của bạn..."></textarea>

            <button type="submit" class="reviews-submit-btn">Gửi Đánh Giá</button>
        </form>
    </div>
</div>


<!-- Footer -->
<footer class="footer">
    <div class="footer-brand">
        <p>CHUYÊN CUNG CẤP CÁC LOẠI THẮT LƯNG.</p>
        <p>   Chất lượng - Uy tín - Tin cậy</p>
        <div class="social-icons">
            <a href="https://www.facebook.com" target="_blank">
                <img src="../asset/image/icons8-facebook-48.png" alt="Facebook">
            </a>
            <a href="https://www.instagram.com" target="_blank">
                <img src="../asset/image/logoInsta.png" alt="Instagram">
            </a>
            <a href="https://www.youtube.com" target="_blank">
                <img src="../asset/image/logoytb.jpg" alt="YouTube">
            </a>
            <a href="https://www.twitter.com" target="_blank">
                <img src="../asset/image/twitter.jpg" alt="Twitter">
            </a>
        </div>
    </div>
    <div class="footer-container">
        <!-- Logo và mạng xã hội -->

        <div class="footer-brand">
            <img src="../asset/image/logoSaleNoti.png" alt="Logo" class="footer-logo">
            <p>Chất lượng - Uy tín - Tin cậy</p>
            <div class="social-icons">
                <i class="fa-brands fa-facebook"></i>
                <i class="fa-brands fa-instagram"></i>
                <i class="fa-solid fa-phone"></i>
                <i class="fa-brands fa-youtube"></i>
            </div>
        </div>

        <!-- Danh sách liên kết -->
        <div class="footer-links">
            <div>
                <h3>Sản phẩm</h3>
                <ul>
                    <li><a href="#">Thắt lưng nam</a></li>
                    <li><a href="#">Thắt lưng nữ</a></li>
                    <li><a href="#">Phụ kiện</a></li>
                    <li><a href="#">Khuyến mãi</a></li>
                </ul>
            </div>
            <div>
                <h3>Chính sách</h3>
                <ul>
                    <li><a href="#">Chính sách đổi trả</a></li>
                    <li><a href="#">Chính sách bảo mật</a></li>
                    <li><a href="#">Chính sách vận chuyển</a></li>
                    <li><a href="#">Hướng dẫn thanh toán</a></li>
                </ul>
            </div>
            <div>
                <h3>Hỗ trợ</h3>
                <ul>
                    <li><a href="#">Liên hệ</a></li>
                    <li><a href="#">Hỗ trợ</a></li>
                    <li><a href="#">Tuyển dụng</a></li>
                </ul>
            </div>
        </div>

        <!-- Thông tin công ty -->
        <div class="footer-contact">
            <h3>Liên hệ</h3>
            <p>Địa chỉ: Số 8, Tam Bình, Thủ Đức</p>
            <p>Điện thoại: 0397526965</p>
            <p>Email: storethatlung@gmail.com</p>
            <p>Thời gian làm việc: 8:00 - 22:00 (hàng ngày)</p>
        </div>
    </div>
    <div class="footer-bottom">
        <p>&copy; 2024 Chuyên cung cấp thắt lưng các loại. Hotline: <a href="tel:0397526965">0397526965</a></p>
    </div>
</footer>
<script>
    // Lấy các phần tử trong DOM
    const decreaseButton = document.querySelector('.quantity-decrease');
    const increaseButton = document.querySelector('.quantity-increase');
    const quantityInput = document.querySelector('.quantity-input');
    const maxStock = ${pd.quantity}; // Số lượng sản phẩm tối đa có sẵn

    // Xử lý khi bấm nút giảm số lượng
    decreaseButton.addEventListener('click', () => {
        let currentQuantity = parseInt(quantityInput.value, 10); // Lấy giá trị hiện tại
        if (currentQuantity > 1) {
            quantityInput.value = currentQuantity - 1; // Giảm 1 nếu lớn hơn 1
        }
    });

    // Xử lý khi bấm nút tăng số lượng
    increaseButton.addEventListener('click', () => {
        let currentQuantity = parseInt(quantityInput.value, 10); // Lấy giá trị hiện tại
        if (currentQuantity < maxStock) {
            quantityInput.value = currentQuantity + 1; // Tăng 1 nếu chưa đạt tối đa
        }
    });

    // Đảm bảo người dùng chỉ nhập số hợp lệ
    quantityInput.addEventListener('input', () => {
        let currentValue = parseInt(quantityInput.value, 10);

        // Nếu nhập sai hoặc nhỏ hơn 1, tự động đặt về 1
        if (isNaN(currentValue) || currentValue < 1) {
            quantityInput.value = 1;
        }

        // Nếu vượt quá số lượng tối đa, đặt về số lượng tối đa
        if (currentValue > maxStock) {
            quantityInput.value = maxStock;
        }
    });
    // Xử lý chọn màu sắc
    const colorButtons = document.querySelectorAll('.color-btn');
    const selectedColor = document.getElementById('selected-color');

    colorButtons.forEach(button => {
        button.addEventListener('click', () => {
            colorButtons.forEach(btn => btn.classList.remove('active'));
            button.classList.add('active');
            selectedColor.textContent = button.getAttribute('data-color');
        });
    });

    // Xử lý chọn kích cỡ
    const sizeButtons = document.querySelectorAll('.size-btn');
    const selectedSize = document.getElementById('selected-size');

    sizeButtons.forEach(button => {
        button.addEventListener('click', () => {
            sizeButtons.forEach(btn => btn.classList.remove('active'));
            button.classList.add('active');
            selectedSize.textContent = button.getAttribute('data-size');
        });
    });
</script>
</body>
</html>