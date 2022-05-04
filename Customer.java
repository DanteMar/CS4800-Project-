import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Connection;

public class Customer {
	private int customerID;
	private String first_name;
	private String last_name;
	private int dob;
	private int phone;
	private String street;
	private String address_number;
	private int zip_code;
	private String city;
	private String state;
	private double discount = 0;
	
	public Customer()
	{
	}
	
	public void newCustomer(String first_name, String last_name, int dob, int phone, String street, String address_number, int zip_code, String city, String state)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			String query = "INSERT INTO `user` (`first_name`, `last_name`, `dob`, `phone`, `street`, `address_number`, `zip_code`, `city`, `state`)";
			
			// execute the query
			connection.createStatement().executeUpdate(query);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void updateCustomer(int userID, String first_name, String last_name, int dob, int phone, String street, String address_number, int zip_code, String city, String state)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			// all database values will change once database is setup
			connection.createStatement().executeUpdate("UPDATE `customer` SET `first_name` = '" + first_name + "' WHERE `userID` = " + userID);	
			connection.createStatement().executeUpdate("UPDATE `customer` SET `last_name` = '" + last_name + "' WHERE `userID` = " + userID);	
			connection.createStatement().executeUpdate("UPDATE `customer` SET `dob` = '" + dob + "' WHERE `userID` = " + userID);	
			connection.createStatement().executeUpdate("UPDATE `customer` SET `phone` = '" + phone + "' WHERE `userID` = " + userID);	
			connection.createStatement().executeUpdate("UPDATE `customer` SET `street` = '" + street + "' WHERE `userID` = " + userID);	
			connection.createStatement().executeUpdate("UPDATE `customer` SET `address_number` = '" + address_number + "' WHERE `userID` = " + userID);	
			connection.createStatement().executeUpdate("UPDATE `customer` SET `zip_code` = '" + zip_code + "' WHERE `userID` = " + userID);	
			connection.createStatement().executeUpdate("UPDATE `customer` SET `city` = '" + city + "' WHERE `userID` = " + userID);	
			connection.createStatement().executeUpdate("UPDATE `customer` SET `state` = '" + state + "' WHERE `userID` = " + userID);	
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
}
