package util;

import dao.UserDAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;

import java.util.Properties;

public class UserDaoFactory  {
//    public UserDAO daoClass(String typeOfDao) {
//        switch (typeOfDao) {
//            case "UserHibernateDAO" : return new UserHibernateDAO(DBHelper.getSessionFactory());
//            case "UserJdbcDAO" : return new UserJdbcDAO(DBHelper.getConnect());
//            default: return null;
//        }
//    }
}
