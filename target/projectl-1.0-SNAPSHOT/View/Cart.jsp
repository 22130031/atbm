<%@ page import="java.util.HashMap" %>
<%@ page import="com.banthatlung.Dao.model.ProductCart" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <title>Shopping Cart</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        <%@include file="/asset/css/style.css" %>
    </style>
    <style>
        <%@include file="../css/footer.css" %>
    </style>
    <style>
        <%@include file="/css/header.css" %>
    </style>
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
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


        <div class="icons d-flex pt-1">

            <div class="dropdown pt-1">
                <a href="#" class="text-white mx-2" id="user-dropdown-toggle" data-bs-toggle="dropdown"
                   aria-expanded="false">
                    <i class="fa-solid fa-user"></i>
                </a>
                <ul class="dropdown-menu" aria-labelledby="user-dropdown-toggle">
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/login">Đăng nhập</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/change-password">Đổi mật
                        khẩu</a></li>
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

            <a href="<%=request.getContextPath()%>/Cart?action=showCart" class="text-white mx-2 pt-1"><i
                    class="fa-solid fa-cart-shopping fa-lg"></i></a>
        </div>

    </div>
</header>

<main class="page">
    <div id="alert-box" class="container mt-3" style="display:none;">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <span id="alert-message">Sản phẩm đã được cập nhật!</span>
            <button type="button" class="close" data-dismiss="alert" aria-label="Đóng">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </div>

    <section class="shopping-cart dark">
        <div class="container">
            <div class="block-heading">
                <h2>Giỏ Hàng</h2>
            </div>
            <div class="content">
                <div class="row">
                    <div class="col-md-12 col-lg-8">
                        <div class="items">
                            <div id="cart-content">
                                <c:choose>
                                    <c:when test="${cart != null}">
                                        <div class="items">
                                            <div class="product">
                                                <%
                                                    int total = 0;
                                                    HashMap<Integer, ProductCart> carts = (HashMap<Integer, ProductCart>) request.getAttribute("cart");
                                                    for (Map.Entry<Integer, ProductCart> entry : carts.entrySet()) {
                                                        Integer key = entry.getKey();
                                                        ProductCart value = entry.getValue();
                                                        int subtotal = value.getQuantity() * value.getProduct().getPrice();
                                                        total += subtotal;
                                                %>
                                                <div class="row mb-4 border-bottom pb-3">
                                                    <div class="col-md-3">
                                                        <img class="img-fluid mx-auto d-block image fix_img_inCart"
                                                             src="images/<%= value.getProduct().getImage() %>" alt="">
                                                    </div>
                                                    <div class="col-md-8">
                                                        <div class="info">
                                                            <div class="row">
                                                                <div class="col-md-5 product-name">
                                                                    <a href="#"><%= value.getProduct().getName() %></a>
                                                                    <div class="product-info">
                                                                        <div>Loại thắt lưng: <span class="value"><%= value.getProduct().getDescription() %></span></div>
                                                                        <div>Màu sắc: <span class="value">Màu đen</span></div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4 quantity">
                                                                    <div class="quantity-control">
                                                                        <button type="button" class="quantity-decrease btn btn-sm btn-outline-secondary" data-id="<%= key %>">-</button>
                                                                        <input type="text" value="<%= value.getQuantity() %>" class="quantity-input form-control d-inline w-25 text-center" readonly>
                                                                        <button type="button" class="quantity-increase btn btn-sm btn-outline-secondary" data-id="<%= key %>">+</button>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 price">
                                                                    <span><%= String.format("%,d", value.getProduct().getPrice()) %> VNĐ</span>
                                                                </div>
                                                                <div class="col-md-1 price">
                                                                    <button class="remove-item btn btn-sm btn-danger" data-id="<%= value.getProduct().getId() %>">
                                                                        <i class="fa-solid fa-x"></i>
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <% } %>
                                            </div>
                                        </div>

                            </div>
                        </div>
                    </div>
                    <!-- Thêm cột tổng cộng và thanh toán -->
                    <div class="col-md-12 col-lg-4">
                        <div class="summary card p-4">
                            <h3 class="card-title">Tóm tắt đơn hàng</h3>
                            <div class="summary-item border-bottom py-3">
                                <span class="text-muted">Tổng cộng</span>
                                <span class="float-right font-weight-bold"><%= String.format("%,d", total) %> VNĐ</span>
                            </div>
                            <div class="summary-item py-3">
                                <span class="text-muted">Phí vận chuyển</span>
                                <span class="float-right">Miễn phí</span>
                            </div>
                            <div class="summary-item border-top py-3">
                                <span class="font-weight-bold">Thành tiền</span>
                                <span class="float-right font-weight-bold text-danger"><%= String.format("%,d", total) %> VNĐ</span>
                            </div>
                            <button class="btn btn-primary btn-lg btn-block mt-3" onclick="location.href='${pageContext.request.contextPath}/CheckOut'">
                                Thanh toán
                            </button>
                        </div>
                    </div>
                    </c:when>
                    <c:otherwise>
                        <h1 class="text-center">Bạn không có sản phẩm nào trong giỏ</h1>
                    </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </section>
</main>

<!-- Footer không thay đổi, giữ nguyên như code gốc -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function updateCart(action, id) {
        $.ajax({
            url: "Cart",
            type: "GET",
            data: {
                action: action,
                id: id
            },
            success: function(response) {
                $('#cart-content').html($(response).find('#cart-content').html());

                // Kiểm tra xem giỏ hàng có trống không
                if ($('#cart-content').text().trim().length === 0 || $('#cart-content').find('.product').length === 0) {
                    showAlert("Không còn sản phẩm nào trong giỏ!", "warning");
                } else {
                    showAlert("Cập nhật giỏ hàng thành công!", "success");
                }

                updateSummary();
            }

        });
    }
    function showAlert(message, type = "success") {
        const alertBox = $('#alert-box');
        const alertElement = alertBox.find('.alert');

        alertElement.removeClass('alert-success alert-danger alert-warning alert-info')
            .addClass('alert-' + type);

        $('#alert-message').text(message);
        alertBox.fadeIn();

        setTimeout(function() {
            alertBox.fadeOut();
        }, 3000);
    }


    // Hàm cập nhật phần tóm tắt
    function updateSummary() {
        var total = 0;
        $('.price span').each(function() {
            var price = parseInt($(this).text().replace(/[^0-9]/g, ''));
            var quantity = parseInt($(this).closest('.row').find('.quantity-input').val());
            total += price * quantity;
        });
        $('.summary-item .float-right.font-weight-bold').eq(0).text(total.toLocaleString('vi-VN') + ' VNĐ');
        $('.summary-item .float-right.text-danger').text(total.toLocaleString('vi-VN') + ' VNĐ');
    }

    $(document).on('click', '.quantity-decrease', function(e) {
        e.preventDefault();
        var id = $(this).data('id');
        var currentQuantity = parseInt($(this).siblings('.quantity-input').val());

        if (currentQuantity <= 1) {
            Swal.fire({
                title: 'Sản phẩm sẽ bị xóa',
                text: 'Bạn có chắc muốn xóa sản phẩm này không?',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#d33',
                cancelButtonColor: '#6c757d',
                confirmButtonText: 'Xóa',
                cancelButtonText: 'Hủy'
            }).then((result) => {
                if (result.isConfirmed) {
                    updateCart('decrease', id);
                    showAlert("Sản phẩm đã được xóa!", "success");
                }
            });
        } else {
            updateCart('decrease', id);
        }
    });



    $(document).on('click', '.quantity-increase', function(e) {
        e.preventDefault();
        var id = $(this).data('id');
        updateCart('increase', id);
    });

    $(document).on('click', '.remove-item', function(e) {
        e.preventDefault();
        var id = $(this).data('id');

        Swal.fire({
            title: 'Xác nhận xóa',
            text: 'Bạn có chắc muốn xóa sản phẩm này không?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#6c757d',
            confirmButtonText: 'Xóa',
            cancelButtonText: 'Hủy'
        }).then((result) => {
            if (result.isConfirmed) {
                updateCart('remove', id);
                showAlert("Sản phẩm đã được xóa!", "success");
            }
        });
    });


</script>
</body>
</html>