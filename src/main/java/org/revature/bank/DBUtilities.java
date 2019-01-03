package org.revature.bank;
import java.sql.*;

public class DBUtilities {
	                              


    Connection connection = null;
    Statement statement = null; 
    ResultSet resultSet = null; 

    public DBUtilities() throws SQLException {
        
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://database1.cvhwuqdvfqwu.us-east-2.rds.amazonaws.com:5432/database1", "MinhDoan777",
    				"12345678");

        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }

    public void DisconnectFromDB() {

        try {
            resultSet.close();
            statement.close();
            connection.close();
        }                                            
        catch (Exception ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }  
    }

    public ResultSet ReadRecords(String sql_stmt) {
        try {

            statement = connection.createStatement();
                                    
            resultSet = statement.executeQuery(sql_stmt);

            return resultSet;

        } 
        catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }                                                    

        return resultSet;
    }

    public void ExecuteSQLStatement(String sql_stmt) {
        try {
            statement = connection.createStatement();
                                    
            statement.executeUpdate(sql_stmt);
        } 
        catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }
}
