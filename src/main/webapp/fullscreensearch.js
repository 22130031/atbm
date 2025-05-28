// Mở và đóng tìm kiếm toàn màn hình
const openSearch = document.getElementById('open-search');
const fullscreenSearch = document.getElementById('fullscreen-search');
const closeSearch = fullscreenSearch.querySelector('.close-btn');

openSearch.addEventListener('click', function (e) {
    e.preventDefault(); // Ngăn chặn hành vi mặc định
    fullscreenSearch.style.display = 'flex';
});

closeSearch.addEventListener('click', function () {
    fullscreenSearch.style.display = 'none';
});

// Đóng khi nhấn phím Escape
document.addEventListener('keydown', function (e) {
    if (e.key === 'Escape') {
        fullscreenSearch.style.display = 'none';
    }
});