package com.banthatlung.services;

import com.banthatlung.Dao.UserDao;
import com.banthatlung.Dao.model.User;

import java.sql.SQLException;

public class ProfileService {
    static UserDao userDao = new UserDao();
    public boolean updateUserProfile(User u) throws SQLException {
        return userDao.updateProfile(u);
    }
}
