package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.MySQLConnector;

public class TrackerController {

    public TrackerController() {

    }

    public boolean saveProduct(String Month, String Category, double MoneySpend) {

        Connection c = MySQLConnector.getConnection(); //get connection

        try {
            PreparedStatement ps = c.prepareStatement //prepare SQL statement
                    ("INSERT INTO number  (Month, Category, MoneySpend)VALUES(?,?,?)");
            ps.setString(1, Month);
            ps.setString(2, Category);
            ps.setDouble(3, MoneySpend);
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(TrackerController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public ResultSet getTrackerList() {
        Connection c = MySQLConnector.getConnection();
        ResultSet results = null;

        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM number");
            results = ps.executeQuery(); //return result            

        } catch (SQLException ex) {
            Logger.getLogger(TrackerController.class.getName()).log(Level.SEVERE, null, ex);

        }
        return results;

    }

 

    public boolean addTracker(String Month, String Category, double MoneySpend) {

        Connection c = MySQLConnector.getConnection();
        PreparedStatement ps = null;
        boolean success = false;

        try {
            String query = "INSERT INTO number (Month, Category, Money_Spend) VALUES (?, ?, ?)";
            ps = c.prepareStatement(query);
            ps.setString(1, Month);
            ps.setString(2, Category);
            ps.setDouble(3, MoneySpend);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(TrackerController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TrackerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }
    
    public void addTracker(String month, String category) {
    addTracker(month, category, 0.0);
}

    public boolean deleteTracker(int Number) {

     boolean isSuccess = false;
        String query = "DELETE FROM number WHERE Number = ?";

        try (Connection connection = MySQLConnector.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, Number);
            int rowsAffected = preparedStatement.executeUpdate();
            isSuccess = rowsAffected > 0;

            if (isSuccess) {
                System.out.println("Successfully deleted item with Number: " + Number);
            } else {
                System.out.println("No item found with Number: " + Number);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrackerController.class.getName()).log(Level.SEVERE, "Error deleting item", ex);
        }

        return isSuccess;
      
    
}
    
}
     
  

     
