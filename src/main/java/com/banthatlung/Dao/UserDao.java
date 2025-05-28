package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private User mapUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getString(1),  // user_id
                rs.getString(2),  // username
                rs.getString(3),  // password
                rs.getInt(4),     // role
                rs.getString(5),  // full_name
                rs.getString(6),  // email
                rs.getString(7),  // phone_number
                rs.getDate(8),    // date_of_birth
                rs.getString(9),  // gender
                rs.getString(10)  // image
        );
    }

    // Lấy tất cả người dùng
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(mapUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Tìm người dùng theo tên đăng nhập
    public User findUser(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = DBConnect2.getPreparedStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapUser(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User findUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement stmt = DBConnect2.getPreparedStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapUser(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Tìm người dùng theo ID
    public User findUserById(String userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement stmt = DBConnect2.getPreparedStatement(sql)) {
            stmt.setString(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapUser(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    // Cập nhật thông tin cá nhân người dùng
    public boolean updateProfile(User user) {
        String sql = "UPDATE users SET full_name = ?, email = ?, phone_number = ?, date_of_birth = ? WHERE user_id = ?";
        try (PreparedStatement stmt = DBConnect2.getPreparedStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhone());
            stmt.setDate(4, user.getBirthday());
            stmt.setString(5, user.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean registerUser(User u) {
        String sql = "INSERT INTO users (username, password, email,user_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = DBConnect2.getPreparedStatement(sql)) {
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getPass());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, "u"+(generateID() +1));
            return stmt.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Đăng ký người dùng mới

    // Sinh mã ID cho người dùng mới
    public int generateID() {
        String query = "SELECT COUNT(*) AS total FROM users";
        try (PreparedStatement stmt = DBConnect2.getPreparedStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        // Thử tìm người dùng với username là "user"
        User user = userDao.findUser("user");

        if (user != null) {
            System.out.println("User found: " + user.getUsername() + ", Password: " + user.getPass());
        } else {
            System.out.println("User not found!");
        }
    }

    // Cập nhật mật khẩu người dùng
    public boolean updatePassword(String userId, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE user_id = ?";
        try (PreparedStatement stmt = DBConnect2.getPreparedStatement(sql)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, userId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
