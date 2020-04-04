package service;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.DBHelper;
import util.UserDaoFactory;

public class UserService {

    private UserDAO dao = new UserDaoFactory().daoClass();
    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void addUser(User user) {
        if(existUser(user)) {
            dao.addUser(user);
        } else {
            updateUser(user);
        }
    }

    public void updateUser(User user) {
        dao.updateUser(user);
    }

    public boolean existUser(User user) {
        return dao.existUser(user);
    }

    public void deleteUser(Long id) {
        dao.deleteUser(id);
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public User checkUserByName(User user) {
        return dao.checkUserByName(user);
    }
}
