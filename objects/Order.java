package objects;
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
	private int broncoID;
	
	public Order () 
	{
	}
	public Order (String status, Date date, Time time, double total, int broncoID) 
	{
		this.status = status;
		this.date = date;
		this.time = time;
		this.total = total;
		this.broncoID = broncoID;
	}
	public int newOrder(Date date, Time time, int broncoID) //returns the orderID of the new order
	{
		int id = -1;
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO aorder (odate, otime, broncoid, total) VALUES (?, ?, ?, ?)");

			stmt.setDate(1, date);
			stmt.setTime(2, time);
			stmt.setDouble(3, broncoID);
			stmt.setDouble(4, 0.0);
			stmt.executeUpdate();
			
			//finds the id of the new order
			PreparedStatement stmt2 = connection.prepareStatement("SELECT orderid FROM aorder WHERE odate = ? AND otime = ? AND broncoid = ?");
			stmt2.setDate(1, date);
			stmt2.setTime(2, time);
			stmt2.setInt(3, broncoID);
			ResultSet rs = stmt2.executeQuery();
			rs.next();
			id = rs.getInt("orderid");
			orderID=id;
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
		return id;
	}
	public void updateOrder(int orderID, Date date, Time time, int broncoID)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			// all database values will change once database is setup
			
			PreparedStatement stmt = connection.prepareStatement("update aorder set odate = ?, otime = ?, broncoid = ? where orderid = ?");
			stmt.setDate(1, date);
			stmt.setTime(2, time);
			stmt.setInt(3, broncoID);
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
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM aorder WHERE orderid = ?");
			stmt.setInt(1, orderIDInput);
			stmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void calculatePrice(int orderID)
	{
		double priceSum = 0;
		int quant = 0;
		int itemID=0;
		//select query through all menuitem_order objects of this orderId and sum
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// all database values will change once database is setup
			PreparedStatement stmt = connection.prepareStatement("SELECT quantity, menuitemid from menuitem_order WHERE orderid = ?");
			stmt.setInt(1, orderID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) 
			{
				quant = rs.getInt("quantity");
				itemID = rs.getInt("menuitemid");
				PreparedStatement stmt2 = connection.prepareStatement("SELECT price from menuitem WHERE menuitemid = ?");
				stmt2.setInt(1, itemID);
				ResultSet rs2 = stmt2.executeQuery();
				while (rs2.next()) 
				{
					priceSum = priceSum + rs2.getDouble("price") * quant;
				}
			}
			total = priceSum;
			
			System.out.println(total);
			setTotal(total, orderID);
			applyDiscount(orderID);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public double applyDiscount(int orderID) //select query of this order's customer to get discount amount and multiply with the price
	{
		double discount = 0;
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			
			
			PreparedStatement stmt2 = connection.prepareStatement("SELECT total, broncoid from aorder WHERE orderid = ?");
			stmt2.setInt(1, orderID);
			ResultSet rs2 = stmt2.executeQuery();
			rs2.next();
			total = rs2.getDouble("total");
			broncoID = rs2.getInt("broncoid");
			// all database values will change once database is setup
			PreparedStatement stmt = connection.prepareStatement("SELECT discount from customer WHERE broncoid = ?");
			stmt.setInt(1, broncoID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) 
			{
				discount = rs.getDouble("discount");
			}
			total = total - total * discount;
			System.out.println(total); 
			setTotal(total, orderID);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		return 0.0;
	}
	public void setTotal(double total, int orderID)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("update aorder set total = ? where orderid = ?");
			stmt.setDouble(1, total);
			stmt.setInt(2, orderID);
			stmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void setStatus(String status, int orderID)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("update aorder set status = ? where orderid = ?");
			stmt.setString(1, status);
			stmt.setInt(2, orderID);
			stmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
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
	public int getBroncoID() {
		return broncoID;
	}
	public void setbroncoID(int c) {
		broncoID = c;
	}
	public double getTotal() {
		return total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String s) {
		status=s;
	}
	public int getorderID() {
		return orderID;
	}
	
	public Date getDate(int orderID) {
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("SELECT odate from aorder WHERE orderid = ?");
			stmt.setInt(1, orderID);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			date = rs.getDate("odate");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return date;
	}
	public Time getTime(int orderID) {
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("SELECT otime from aorder WHERE orderid = ?");
			stmt.setInt(1, orderID);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			time = rs.getTime("otime");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return time;
	}
	public int getBroncoID(int orderID) {
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("SELECT broncoid from aorder WHERE orderid = ?");
			stmt.setInt(1, orderID);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			broncoID = rs.getInt("broncoid");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return broncoID;
	}
	public double getTotal(int orderID) {
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("SELECT total from aorder WHERE orderid = ?");
			stmt.setInt(1, orderID);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			total = rs.getDouble("total");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return total;
	}
	public String getStatus(int orderID) {
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("SELECT status from aorder WHERE orderid = ?");
			stmt.setInt(1, orderID);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			status = rs.getString("status");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}