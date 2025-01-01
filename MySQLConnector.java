package util;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnector {

    private static Connection databaseConnection = null;

    public static Connection getConnection() {
        if (databaseConnection == null) {
            try {
                databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myexpensestracker", "root", "root");
                System.out.println("Connected to database");
            } catch (SQLException ex) {
                Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return databaseConnection;
    }
}
