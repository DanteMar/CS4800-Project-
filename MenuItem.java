package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;

public class MenuItem {
	private int itemID;
	private String name;
	private double price;
	
	MenuItem(String name, double price)
	{
		this.name = name;
		this.price = price;
	}
	public void newMenuItem(String name, double price)
	{
		this.name = name;
		this.price = price;
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO menuitem (foodname, price) VALUES (?, ?)");

			stmt.setString(1, name);
			stmt.setDouble(2, price);
			
			stmt.executeUpdate();
			
			PreparedStatement stmt2 = connection.prepareStatement("SELECT menuitemid from menuitem WHERE foodname = ? AND price = ?");

			stmt2.setString(1, name);
			stmt2.setDouble(2, price);
			
			ResultSet rs = stmt2.executeQuery();
			rs.next();
			itemID=rs.getInt("menuitemid");
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void updateMenuItem(int itemID, String name, double price)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// all database values will change once database is setup
			PreparedStatement stmt = connection.prepareStatement("SELECT price from menuitem WHERE menuitemid = ?");
			stmt.setInt(1, itemID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) 
			{
				this.price = rs.getDouble("price");
			}
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
		if (this.price != price)
		{
			// create a new historical price
			HistoricalPrice hprice = new HistoricalPrice();
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			hprice.newHistoricalPrice(this.price, date, itemID);
		}
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			// all database values will change once database is setup
			
			PreparedStatement stmt = connection.prepareStatement("update menuitem set foodname = ?, price = ? where menuitemid = ?");
			stmt.setString(1, name);
			stmt.setDouble(2, price);
			stmt.setInt(3, itemID);
			
			stmt.executeUpdate();
			this.name = name;
			this.price = price;
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void deleteMenuItem(int menuItemIDInput)
	{
		try
		{
			
			// all database values will change once database is setup
			Connection connection = LoginDataAccess.verifyCredentials();
			
			HistoricalPrice test = new HistoricalPrice();
			test.deleteHistoricalPrice(menuItemIDInput);
			
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM menuitem WHERE menuitemid = ?");
			stmt.setInt(1, menuItemIDInput);
			stmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public int getID()
	{	
		if(itemID==0) {
			try {
				Connection connection = LoginDataAccess.verifyCredentials();
				PreparedStatement stmt2 = connection.prepareStatement("SELECT menuitemid from menuitem WHERE foodname = ? AND price = ?");

				stmt2.setString(1, name);
				stmt2.setDouble(2, price);
				
				ResultSet rs = stmt2.executeQuery();
				rs.next();
				itemID=rs.getInt("menuitemid");
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		return itemID;
	}
	public String getName()
	{
		return name;
	}
	public double getPrice()
	{
		return price;
	}
}
