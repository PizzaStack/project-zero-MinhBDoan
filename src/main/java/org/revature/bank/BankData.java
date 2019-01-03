package org.revature.bank;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class BankData {
	
	public BankData(){
		
	}
	
	protected void AccountLookUp(String tablestatement) throws SQLException{
		
	        DisplayRecords(tablestatement);
	    }

	    private void DisplayRecords(String tablestatement) throws SQLException {
	    	try {
	            DBUtilities dbUtilities = new DBUtilities();

	            String sql_stmt = tablestatement;
	            ResultSet resultSet = dbUtilities.ReadRecords(sql_stmt);

	            
	            if (resultSet.next()) {

	                ResultSetMetaData metaData = resultSet.getMetaData();
	                int numberOfColumns = metaData.getColumnCount();


	                for (int i = 1; i <= numberOfColumns; i++) {
	                    System.out.printf("%-30s|", metaData.getColumnName(i));
	                }
	                System.out.println();

	                do {
	                    for (int i = 1; i <= numberOfColumns; i++) {
	                        System.out.printf("%-30s|", resultSet.getObject(i));
	                    }
	                    System.out.println();
	                } while (resultSet.next());
	                
	                System.out.println();

	            } else {
	                System.out.println("No database records found");
	            }

	            
	            dbUtilities.DisconnectFromDB();
	        } catch (SQLException ex) {
	            System.out.println("The following error has occured: " + ex.getMessage());
	        } finally {
	            
	        }
	    }
	   

	
	
	 void createAccount() throws SQLException{
		Scanner userInput = new Scanner(System.in);
        System.out.println("You selected option 1: Create Single User Bank Account: ");
        String username;
        System.out.println("Enter username: ");
        username = userInput.next();

        String password;
        System.out.println("Enter password: ");
        password = userInput.next();

        String address;
        System.out.println("Enter address: ");
        address = userInput.next();
        
        Integer phonenumber;
        System.out.println("Enter phone number: ");
        phonenumber = userInput.nextInt();
        
        Integer socialsecuritynumber;
        System.out.println("Enter social security number: ");
        socialsecuritynumber = userInput.nextInt();
       
        String status;
        status = "pending";
        DBUtilities dbUtilities = new DBUtilities();
        
        String sql_stmt = "INSERT INTO customer (username,password,address,phonenumber,socialsecuritynumber,status) VALUES ('" + username + "','" + password + "','" + address + "','" + phonenumber + "','" + socialsecuritynumber + "','" + status + "')";
        
        dbUtilities.ExecuteSQLStatement(sql_stmt);
        
        System.out.println("Single User Bank Account Successfully Created");
        App.DisplayMenu();
   
	}
	 void createJointAccount() throws SQLException{
		 Scanner userInput = new Scanner(System.in);
	        System.out.println("You selected option 2: Create Joint User Bank Account: ");
	        String username;
	        System.out.println("Enter username: ");
	        username = userInput.next();

	        String password;
	        System.out.println("Enter password: ");
	        password = userInput.next();

	        String address;
	        System.out.println("Enter address: ");
	        address = userInput.next();
	        
	        Integer phonenumber;
	        System.out.println("Enter phone number: ");
	        phonenumber = userInput.nextInt();
	        
	        Integer socialsecuritynumber;
	        System.out.println("Enter social security number: ");
	        socialsecuritynumber = userInput.nextInt();
	  //--------------------------------------
	        

	        String jointaddress;
	        System.out.println("Enter joint address: ");
	        jointaddress = userInput.next();
	        
	        Integer jointphonenumber;
	        System.out.println("Enter joint phone number: ");
	        jointphonenumber = userInput.nextInt();
	        
	        Integer jointsocialsecuritynumber;
	        System.out.println("Enter joint social security number: ");
	        jointsocialsecuritynumber = userInput.nextInt();
	       
	        String status;
	        status = "pending";
	        DBUtilities dbUtilities = new DBUtilities();
	        
	        String sql_stmt = "INSERT INTO jointcustomer (username,password,address,phonenumber,socialsecuritynumber,jointaddress,jointphonenumber,jointsocialsecuritynumber,status) VALUES ('" + username + "','" + password + "','" + address + "','" + phonenumber + "','" + socialsecuritynumber + "','" + jointaddress + "','" + jointphonenumber + "','" + jointsocialsecuritynumber + "','" + status + "')";	        
	        dbUtilities.ExecuteSQLStatement(sql_stmt);
	        
	        System.out.println("Joint User Bank Account Successfully Created");
	        App.DisplayMenu();
	}
	 void UpdateBalance(String updatebalancestatement, String displaybalancestatement) throws SQLException{
		 
	        Scanner userInput = new Scanner(System.in);

	       
	        

	        DBUtilities dbUtilities = new DBUtilities();

	        String sql_stmt = updatebalancestatement;

	        dbUtilities.ExecuteSQLStatement(sql_stmt);

	        DisplayRecords(displaybalancestatement);
	        
	    }

	    
	    protected void StatusUpdate(String statusstatement, String displaystatement) throws SQLException{
			 
	        Scanner userInput = new Scanner(System.in);

	        

	        DBUtilities dbUtilities = new DBUtilities();

	        String sql_stmt = statusstatement;
	        
	        dbUtilities.ExecuteSQLStatement(sql_stmt);

	        DisplayRecords(displaystatement);
	        
	    }
	    void CancelAccount(String cancelstatement) throws SQLException {
	    	
	            

	            
	                DBUtilities dbUtilities = new DBUtilities();

	                String sql_stmt = cancelstatement;

	                dbUtilities.ExecuteSQLStatement(sql_stmt);
	                
	                System.out.println("The Record has successfully being deleted");
	            }

	            
	        

	    
	    
	
	void loggingIn(String username, String password, String accountchoice, String tablestatement, Integer checkingindex, Integer savingindex) throws SQLException{

		 DisplayResults(username, password, accountchoice, tablestatement, checkingindex, savingindex);
	    }

	    private void DisplayResults(String username, String password, String accountchoice, String tablestatement, Integer checkingindex, Integer savingindex ) throws SQLException {
	    	List<Double> balancelist= new ArrayList<Double>();
	    	Integer id = 0;
	    	
	    	try {
				DBUtilities dbUtilities = new DBUtilities();

				String sql_stmt = tablestatement;
				ResultSet resultSet = dbUtilities.ReadRecords(sql_stmt);

				if (resultSet.next()) {

					ResultSetMetaData metaData = resultSet.getMetaData();
					int numberOfColumns = metaData.getColumnCount();

					for (int i = 1; i <= numberOfColumns; i++) {
						System.out.println(metaData.getColumnName(i) + ": " + resultSet.getObject(i));
					}
					id = resultSet.getInt(1);

					double checkingbalance = resultSet.getDouble(checkingindex);
					double savingbalance = resultSet.getDouble(savingindex);

					balancelist.add(checkingbalance);
					balancelist.add(savingbalance);

					System.out.println();
				} else {
					System.out.println("No database records foundn");
				}

				dbUtilities.DisconnectFromDB();
			} catch (SQLException ex) {
				System.out.println("The following error has occured: " + ex.getMessage());
			} finally {
				Transactions(balancelist, id, accountchoice);
			}
	        
	     
	    }
	    

		

		 List<Double> Transactions(List<Double> listbalance, Integer id, String accountchoice) throws SQLException {
			
			return null;
		}

		
	}

