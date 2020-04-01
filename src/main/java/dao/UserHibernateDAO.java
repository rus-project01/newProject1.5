package dao;
import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;


public class UserHibernateDAO implements UserDAO {

    public List<User> getAllUsers() {
        Session session = DBHelper.getSessionFactory().openSession();
        List<User> cars = session.createQuery("FROM User").list();
        session.close();
        return cars;
    }

    public void deleteUser(Long id) {
        Session session = DBHelper.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where id = :id");
        query.setParameter("id", id);
        List<User> cars = query.list();
        session.delete(cars.get(0));
        transaction.commit();
        session.close();
    }

    public void addUser(User user) {
        Session session = DBHelper.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void updateUser(User user) {
        Session session = DBHelper.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update User set password = :password, money = :money where name = :name");
        query.setParameter("password", user.getPassword());
        query.setLong("money", user.getMoney());
        query.setParameter("name", user.getName());
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public boolean checkUserByName(User user) {
        Session session = DBHelper.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where name = :name");
        query.setParameter("name", user.getName());
        List<User> cars = query.list();
        transaction.commit();
        session.close();
        return cars.size() == 0;
    }
}
