package util;

import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    private static Connection connection;

    public static Connection getSessionFactory() {
        if (connection == null) {
            connection = getMysqlConnection();
        }
        return connection;
    }

    private static Connection getMysqlConnection() {
        try{
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("web5?").          //db name
                    append("user=root&").          //login
                    append("password=Qwerty12").       //password
                    append("&serverTimezone=UTC").
                    append("&useSSL=false");
            System.out.println("URL: " + url + "\n");
            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
