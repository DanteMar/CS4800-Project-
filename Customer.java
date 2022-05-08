import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;

public class Customer {
	private String first_name;
	private String last_name;
	private Date dob;
	private int phone;
	private String street;
	private int address_number;
	private int zip_code;
	private String city;
	private String state;
	private double discount = 0;
	
	public Customer()
	{
	}
	
	public void newCustomer(String first_name, String last_name, Date dob, int phone, String street, int address_number, int zip_code, String city, String state)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO customer (first_name, last_name, dob, phone, street, address_number, zip_code, city, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			stmt.setString(1, first_name);
			stmt.setString(2, last_name);
			stmt.setDate(3, dob);
			stmt.setInt(4, phone);
			stmt.setString(5, street);
			stmt.setInt(6, address_number);
			stmt.setInt(7, zip_code);
			stmt.setString(8, city);
			stmt.setString(9, state);
			
			stmt.executeUpdate();
			
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void updateCustomer(int customerID, String first_name, String last_name, Date dob, int phone, String street, int address_number, int zip_code, String city, String state)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			// all database values will change once database is setup
			
			PreparedStatement stmt = connection.prepareStatement("update customer set first_name = ?, last_name = ?, dob = ?, phone = ?, street = ?, address_number = ?, zip_code = ?, city = ?, state = ? where customerid = ?");
			stmt.setString(1, first_name);
			stmt.setString(2, last_name);
			stmt.setDate(3, dob);
			stmt.setInt(4, phone);
			stmt.setString(5, street);
			stmt.setInt(6, address_number);
			stmt.setInt(7, zip_code);
			stmt.setString(8, city);
			stmt.setString(9, state);
			stmt.setInt(10, customerID);
			
			stmt.executeUpdate();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void deleteCustomer(int customerIDInput)
	{
		try
		{
			// all database values will change once database is setup
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM customer WHERE customerid = ?");
			stmt.setInt(1, customerIDInput);
			stmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
