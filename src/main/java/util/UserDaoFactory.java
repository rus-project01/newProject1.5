package util;

import dao.UserDAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;

import java.io.IOException;
import java.util.Properties;

public class UserDaoFactory {
    public UserDAO daoClass() {
        switch (ReaderFile.readDaoType()) {
            case "UserHibernateDAO": return new UserHibernateDAO();
            case "UserJdbcDAO": return new UserJdbcDAO();
            default: throw new IllegalStateException("Ошибка при инициилизации класса");
        }
    }
}