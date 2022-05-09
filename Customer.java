package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;

public class Customer {
	private int broncoID;
	private String first_name;
	private String last_name;
	private Date dob;
	private int phone;
	//private String street;
	//private int address_number;
	//private int zip_code;
	//private String city;
	//private String state;
	private double discount = 0;
	
	Customer()
	{
		
	}
	Customer(int broncoID, String fname, String lname, Date dob, int phone)
	{
		this.broncoID = broncoID;
		first_name = fname;
		last_name = lname;
		this.dob = dob;
		this.phone = phone;
	}
	
	public void newCustomer( int broncoID ,String first_name, String last_name, Date dob, int phone)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO customer (broncoid, firstname, lastname, dob, phonenum, discount) VALUES (?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, broncoID);
			stmt.setString(2, first_name);
			stmt.setString(3, last_name);
			stmt.setDate(4, dob);
			stmt.setInt(5, phone);
			stmt.setDouble(6, discount);
			stmt.executeUpdate();
			
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void updateCustomer(int broncoID, String first_name, String last_name, Date dob, int phone)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			// all database values will change once database is setup
			
			PreparedStatement stmt = connection.prepareStatement("update customer set firstname = ?, lastname = ?, dob = ?, phonenum = ? where broncoid = ?");
			stmt.setString(1, first_name);
			stmt.setString(2, last_name);
			stmt.setDate(3, dob);
			stmt.setInt(4, phone);
			stmt.setInt(5, broncoID);
			
			stmt.executeUpdate();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void deleteCustomer(int broncoIDInput)
	{
		try
		{
			// all database values will change once database is setup
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM customer WHERE broncoID = ?");
			stmt.setInt(1, broncoIDInput);
			stmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public int getBroncoID()
	{
		return broncoID;
	}
	public String getFirstName()
	{
		return first_name;
	}
	public String getLastName()
	{
		return last_name;
	}
	public Date getdob()
	{
		return dob;
	}
	public int phone()
	{
		return phone;
	}
}
