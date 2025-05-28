package com.banthatlung.services;

import com.banthatlung.Dao.UserDao;
import com.banthatlung.Dao.model.User;

public class AuthService {
    public User checkLogin(String username, String pass){
        UserDao dao = new UserDao();
        User u = dao.findUser(username);
        if(u != null && pass.equals(u.getPass())){
            u.setPass(null);
            return u;
        }
        return null;
    }

    public User findByUserId(String userId){
        UserDao dao = new UserDao();
        return dao.findUserById(userId);
    }


    public boolean register(User user) {
        UserDao dao = new UserDao();
        User u = dao.findUser(user.getUsername());
        if(u != null){
            return false;
        }
        return dao.registerUser(user);
    }

    public boolean changePassword(String userId, String oldPassword, String newPassword) {
        UserDao userDao = new UserDao();
        User user = userDao.findUserById(userId);
        if (user != null && oldPassword.equals(user.getPass())) {
            return userDao.updatePassword(userId, newPassword);
        }
        return false;
    }

}
