package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {
    Connection connection;
    private static databaseConnection databaseConnection = new databaseConnection();

    //    private constructor to prevent further initialization by other classes
    private databaseConnection() {

    }
    //return the instance
    public static databaseConnection getInstance() {
        return databaseConnection;
    }

    public Connection getConnected() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/examinator?serverTimezone=UTC", "root", ""
            );
            if (connection != null) {
                System.out.println("Connected To Database");
            } else {
                System.out.println("Failed To Connect");
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage() + "..." + e.getSQLState());
            ;
        }
        return connection;
    }

}
