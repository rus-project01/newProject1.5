package dao;
import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;


public class UserHibernateDAO implements UserDAO {
    private SessionFactory sessionFactory = DBHelper.getSessionFactory();

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> cars = session.createQuery("FROM User").list();
        session.close();
        return cars;
    }

    public void deleteUser(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where id = :id");
        query.setParameter("id", id);
        List<User> cars = query.list();
        session.delete(cars.get(0));
        transaction.commit();
        session.close();
    }

    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update User set password = :password, money = :money, role = :role where name = :name");
        query.setParameter("password", user.getPassword());
        query.setLong("money", user.getMoney());
        query.setParameter("role", user.getRole());
        query.setParameter("name", user.getName());
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public boolean existUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where name = :name and password = :password");
        query.setParameter("name", user.getName());
        query.setParameter("password", user.getPassword());
        List<User> cars = query.list();
        transaction.commit();
        session.close();
        return cars.size() == 0;
    }

    public User checkUserByName(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where name = :name");
        query.setParameter("name", user.getName());
        List<User> cars = query.list();
        transaction.commit();
        session.close();
        return cars.get(0);
    }
}
