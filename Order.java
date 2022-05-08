import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Time;

public class Order {
	private int orderID;
	private String status;
	private Date date;
	private Time time;
	private double total;
	private int customerID;
	
	public Order () 
	{
	}
	public void newOrder(Date date, Time time, int customerID)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO order (date, time, customerID) VALUES (?, ?, ?)");

			stmt.setDate(1, date);
			stmt.setTime(2, time);
			stmt.setDouble(3, customerID);
			
			stmt.executeUpdate();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void updateOrder(int orderID, Date date, Time time, int customerID)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			// all database values will change once database is setup
			
			PreparedStatement stmt = connection.prepareStatement("update order set date = ?, time = ?, customerid = ? where orderid = ?");
			stmt.setDate(1, date);
			stmt.setTime(2, time);
			stmt.setInt(3, customerID);
			stmt.setInt(4, orderID);
			
			stmt.executeUpdate();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public static void deleteOrder(int orderIDInput)
	{
		try
		{
			// all database values will change once database is setup
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM order WHERE orderIDInput = ?");
			stmt.setInt(1, orderIDInput);
			stmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public double calculatePrice()
	{
		double priceSum = 0;
		int quant = 0;
		int itemID=0;
		//select query through all menuitem_order objects of this orderId and sum
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// all database values will change once database is setup
			PreparedStatement stmt = connection.prepareStatement("SELECT quantity, menuitemID from foodorder WHERE  orderID = ?");
			stmt.setInt(1, orderID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) 
			{
				quant = rs.getInt("quantity");
				itemID = rs.getInt("menuitemID");
				
				PreparedStatement stmt2 = connection.prepareStatement("SELECT price from menuitem WHERE menuitemID = ?");
				stmt.setInt(1, itemID);
				ResultSet rs2 = stmt2.executeQuery();
				while (rs.next()) 
				{
					priceSum = priceSum + rs2.getDouble("price") * quant;
				}
			}
			total = priceSum;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return 0.0;
	}
	public double applyDiscount() //select query of this order's customer to get discount amount and multiply with the price
	{
		double discount = 0;
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// all database values will change once database is setup
			PreparedStatement stmt = connection.prepareStatement("SELECT discount from customer WHERE customerID = ?");
			stmt.setInt(1, customerID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) 
			{
				discount = rs.getDouble("discount");
			}
			total = total - total * discount;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		return 0.0;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date d) {
		date=d;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time t) {
		time=t;
	}
	public int getCustomer() {
		return customerID;
	}
	public void setCustomerID(int c) {
		customerID = c;
	}
	public double getTotalPrice() {
		return total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String s) {
		status=s;
	}
}