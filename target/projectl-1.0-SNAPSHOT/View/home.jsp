<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!--Header-->
<header class="bg-dark text-white py-3">
    <div class="container d-flex justify-content-between align-items-center">
        <!-- Logo và Trang chủ -->
        <a href="${pageContext.request.contextPath}/home" class="text-white">
            <h1 class="m-0">Trang chủ</h1>
        </a>

        <!-- Menu điều hướng -->
        <div class="menu d-flex">
            <a href="${pageContext.request.contextPath}/home" class="text-white mx-3">Danh mục sản phẩm</a>
            <a href="#" class="text-white mx-3">Giới thiệu</a>
            <a href="#" class="text-white mx-3">Chính sách</a>
            <a href="#" class="text-white mx-3">Liên hệ</a>
        </div>


        <div class="icons d-flex pt-1"  >

            <div class="dropdown pt-1">
                <a href="#" class="text-white mx-2" id="user-dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    <c:if test="${sessionScope.auth ==null}">
                    <i class="fa-solid fa-user"></i>
                    </c:if>
                    <c:if test="${sessionScope.auth !=null}">
                    <img src="${pageContext.request.contextPath}/${sessionScope.auth.image}" alt="Avatar" style="width: 30px; height: 30px; border-radius: 50%;">
                    </c:if>
                </a>
                <ul class="dropdown-menu" aria-labelledby="user-dropdown-toggle">
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/profile">Hồ sơ</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/login">Đăng nhập</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/change-password">Đổi mật khẩu</a></li>
                </ul>
            </div>

            <div class="search-container me-4">
                <form action="${pageContext.request.contextPath}/search" method="get">
                    <div class="input-group input-group-sm">
                        <input type="text" class="form-control" name="search" placeholder="Tìm kiếm...">
                        <button class="btn btn-sm btn-outline-secondary" type="submit">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                    </div>
                </form>
            </div>

            <a href="<%=request.getContextPath()%>/Cart?action=showCart" class="text-white mx-2 pt-1"><i class="fa-solid fa-cart-shopping fa-lg"></i></a>
        </div>

    </div>
</header>

<section id="feature" class="container py-5">
    <div class="row text-center">
        <div class="col-md-2">
            <i class="fa-solid fa-truck fa-3x"></i>
            <h6>Giao hàng miễn phí</h6>
        </div>
        <div class="col-md-2">
            <i class="fa-solid fa-medal fa-3x"></i>
            <h6>Bảo hành 36 tháng</h6>
        </div>
        <div class="col-md-2">
            <i class="fa-sharp fa-solid fa-shield-halved fa-3x"></i>
            <h6>Cam kết da thật 100%</h6>
        </div>
        <div class="col-md-2">
            <i class="fa-solid fa-clipboard fa-3x"></i>
            <h6>Đổi trả trong 7 ngày</h6>
        </div>
        <div class="col-md-2">
            <i class="fa-solid fa-thumbs-up fa-3x"></i>
            <h6>Bảo hành trọn đời</h6>
        </div>
        <div class="col-md-2">
            <i class="fa-solid fa-tag fa-3x"></i>
            <h6>Giảm giá hấp dẫn</h6>
        </div>
    </div>

</section>

<section id="product1" class="container py-5">
    <h2 class="text-center">Sản phẩm nổi bật</h2>
    <p class="text-center">Sang trọng – Mạnh mẽ – Khí chất</p>
    <div class="row">
        <c:forEach var="product" items="${productList}">
            <div class="col-md-3 mb-4">
                <div class="card h-100">
                    <!-- Link đến chi tiết sản phẩm -->

                    <a href="${pageContext.request.contextPath}/product?pid=${product.id != null ? product.id : 'default'}">
                        <!-- Hình ảnh sản phẩm với kiểm tra dữ liệu -->
                        <img src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsyge42i2bh53f.webp"
                             class="card-img-top"
                             alt="${product.name != null ? product.name : 'Sản phẩm không có tên'}"
                             style="object-fit: cover; height: 200px; width: 100%;">
                    </a>
                    <div class="card-body d-flex flex-column text-center">
                        <p class="card-text text-muted">
                                ${product.category != null && product.category.name != null ? product.category.name : 'Không có danh mục'}
                        </p>
                        <!-- Tên sản phẩm -->
                        <h5 class="card-title text-truncate" style="max-width: 100%;">
                                ${product.name != null && !product.name.isEmpty() ? product.name : 'Sản phẩm không có tên'}
                        </h5>
                        <!-- Giá sản phẩm -->
                        <h4 class="card-text">
                            <c:choose>
                                <c:when test="${product.price != null}">
                                    ${product.price} VND
                                </c:when>
                                <c:otherwise>
                                    Liên hệ
                                </c:otherwise>
                            </c:choose>
                        </h4>

                        <form action="${pageContext.request.contextPath}/Cart" method="post">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="id" value="${product.id != null ? product.id : 'default'}">
                            <button type="submit" class="btn btn-warning mt-auto">
                                Thêm vào giỏ hàng
                            </button>
                        </form>

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


    <div class="pagination justify-content-center flex-wrap">
        <!-- Các nút phân trang -->
        <c:forEach var="i" begin="1" end="${totalPages}">
            <button class="btn btn-outline-primary mx-1 my-2" onclick="window.location.href='${pageContext.request.contextPath}/home?page=${i}'">${i}</button>
        </c:forEach>
    </div>

</section>

<footer class="bg-dark text-white py-4">
    <div class="container">
        <!-- Thông tin giới thiệu và các mạng xã hội -->
        <div class="row text-center mb-4">
            <div class="col-12">
                <p>CHUYÊN CUNG CẤP CÁC LOẠI THẮT LƯNG.</p>
                <p>Chất lượng - Uy tín - Tin cậy</p>
            </div>
            <div class="col-12">
                <div class="social-icons">
                    <a href="https://www.facebook.com" target="_blank" class="text-white mx-2">
                        <i class="fa-brands fa-facebook fa-2x"></i>
                    </a>
                    <a href="https://www.instagram.com" target="_blank" class="text-white mx-2">
                        <i class="fa-brands fa-instagram fa-2x"></i>
                    </a>
                    <a href="https://www.youtube.com" target="_blank" class="text-white mx-2">
                        <i class="fa-brands fa-youtube fa-2x"></i>
                    </a>
                    <a href="https://www.twitter.com" target="_blank" class="text-white mx-2">
                        <i class="fa-brands fa-twitter fa-2x"></i>
                    </a>
                </div>
            </div>
        </div>

        <!-- Các liên kết footer (4 mục nằm ngang) -->
        <div class="row mb-4">
            <div class="col-lg-3 col-md-6">
                <h5>Sản phẩm</h5>
                <ul class="list-unstyled">
                    <li><a href="#" class="text-white">Thắt lưng nam</a></li>
                    <li><a href="#" class="text-white">Thắt lưng nữ</a></li>
                    <li><a href="#" class="text-white">Phụ kiện</a></li>
                    <li><a href="#" class="text-white">Khuyến mãi</a></li>
                </ul>
            </div>
            <div class="col-lg-3 col-md-6">
                <h5>Chính sách</h5>
                <ul class="list-unstyled">
                    <li><a href="#" class="text-white">Chính sách đổi trả</a></li>
                    <li><a href="#" class="text-white">Chính sách bảo mật</a></li>
                    <li><a href="#" class="text-white">Chính sách vận chuyển</a></li>
                    <li><a href="#" class="text-white">Hướng dẫn thanh toán</a></li>
                </ul>
            </div>
            <div class="col-lg-3 col-md-6">
                <h5>Hỗ trợ</h5>
                <ul class="list-unstyled">
                    <li><a href="#" class="text-white">Liên hệ</a></li>
                    <li><a href="#" class="text-white">Hỗ trợ</a></li>
                    <li><a href="#" class="text-white">Tuyển dụng</a></li>
                </ul>
            </div>
            <div class="col-lg-3 col-md-6">
                <h5>Liên hệ</h5>
                <p>Địa chỉ: Số 8, Tam Bình, Thủ Đức</p>
                <p>Điện thoại: 0397526965</p>
                <p>Email: <a href="mailto:storethatlung@gmail.com" class="text-white">storethatlung@gmail.com</a></p>
                <p>Thời gian làm việc: 8:00 - 22:00 (hàng ngày)</p>
            </div>
        </div>

        <!-- Thông tin bản quyền -->
        <div class="footer-bottom text-center">
            <p>&copy; 2024 Chuyên cung cấp thắt lưng các loại. Hotline: <a href="tel:0397526965" class="text-white">0397526965</a></p>
        </div>
    </div>
</footer>




<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
