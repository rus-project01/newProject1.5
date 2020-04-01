package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import model.User;
import util.DBHelper;

public class UserJdbcDAO implements UserDAO {

    private Connection connection = DBHelper.getConnection();

    public void addUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into users(name, password, money) values (?, ?, ?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getMoney());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement("update users set name=?, password=?, money=? where name=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getMoney());
            ps.setString(4, user.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setMoney(rs.getLong("money"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public boolean checkUserByName(User user)  {
        List<User> list = new ArrayList<>();
        User users = new User();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("select * from users where name=?");
            ps.setString(1, user.getName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                users.setName(rs.getString("name"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.size() == 0;
    }

}