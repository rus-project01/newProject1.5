package service;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import dao.UserHibernateDAO;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.DBHelper;

public class UserService {

    private UserDAO dao;
    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public void addUser(User user) {
        if(checkUserByName(user)) {
            dao.addUser(user);
        } else {
            updateUser(user);
        }
    }

    public void updateUser(User user) {
        dao.updateUser(user);
    }

    public void deleteUser(Long id) {
        dao.deleteUser(id);
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public boolean checkUserByName(User user) {
        return dao.checkUserByName(user);
    }

}
