package com.banthatlung.Controller;

import com.banthatlung.Dao.model.User;
import com.banthatlung.services.ProfileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AvatarController", value = "/update-avatar")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class AvatarController extends HttpServlet {
    private static final String UPLOAD_DIR = "avatars";
    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList(".jpg", ".jpeg", ".png", ".gif");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");

        // Kiểm tra đăng nhập
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/View/login.jsp");
            return;
        }

        try {
            Part filePart = req.getPart("avatar");
            if (filePart == null || filePart.getSize() == 0) {
                session.setAttribute("message", "Vui lòng chọn một file ảnh!");
                resp.sendRedirect(req.getContextPath() + "/View/profile.jsp");
                return;
            }

            // Lấy tên file và kiểm tra định dạng
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            if (!isValidFileExtension(fileName)) {
                session.setAttribute("message", "Chỉ chấp nhận file ảnh (jpg, jpeg, png, gif)!");
                resp.sendRedirect(req.getContextPath() + "/View/profile.jsp");
                return;
            }

            // Tạo thư mục upload
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Xóa ảnh cũ nếu tồn tại
            deleteOldAvatar(user, uploadPath);

            // Tạo tên file unique
            String uniqueFileName = user.getId() + "_" + System.currentTimeMillis() + "_" + fileName;
            String avatarPath = uploadPath + File.separator + uniqueFileName;

            // Lưu file
            filePart.write(avatarPath);

            // Cập nhật đường dẫn ảnh
            String avatarUrl = UPLOAD_DIR + "/" + uniqueFileName;
            user.setImage(avatarUrl);

            // Cập nhật vào cơ sở dữ liệu
            ProfileService profileService = new ProfileService();
            profileService.updateUserProfile(user);

            // Cập nhật session
            session.setAttribute("auth", user);
            session.setAttribute("message", "Cập nhật ảnh đại diện thành công!");

        } catch (Exception e) {
            session.setAttribute("message", "Lỗi khi upload ảnh: " + e.getMessage());
            throw new ServletException("Error uploading avatar", e);
        }

        resp.sendRedirect(req.getContextPath() + "/View/profile.jsp");
    }

    // Kiểm tra định dạng file
    private boolean isValidFileExtension(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return false;
        }
        String fileExt = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        return ALLOWED_EXTENSIONS.contains(fileExt);
    }

    // Xóa ảnh cũ nếu tồn tại
    private void deleteOldAvatar(User user, String uploadPath) {
        String oldAvatar = user.getImage();
        if (oldAvatar != null && !oldAvatar.isEmpty() && !oldAvatar.equals("images/default-avatar.jpg")) {
            File oldFile = new File(uploadPath + File.separator +
                    oldAvatar.substring(oldAvatar.lastIndexOf("/") + 1));
            if (oldFile.exists()) {
                oldFile.delete();
            }
        }
    }
}