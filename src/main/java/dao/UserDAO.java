package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDAO {

    void updateUser(User user);

    void addUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();

    User checkUserByName(User user);

    boolean existUser(User user);

}
