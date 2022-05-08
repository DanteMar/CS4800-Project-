import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;

public class MenuItem {
	private int itemID;
	private String name;
	private double price;
	public void newMenuItem(String name, double price)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO menuitem (name, price) VALUES (?, ?)");

			stmt.setString(1, name);
			stmt.setDouble(2, price);
			
			stmt.executeUpdate();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void updateMenuItem(int itemID, String name, double price)
	{
		if (this.price != price)
		{
			// create a new historical price
			HistoricalPrice hprice = new HistoricalPrice();
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			hprice.newHistoricalPrice(this.price, date);
		}
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			// all database values will change once database is setup
			
			PreparedStatement stmt = connection.prepareStatement("update menuitem set name = ?, price = ? where menuitemid = ?");
			stmt.setString(1, name);
			stmt.setDouble(2, price);
			stmt.setInt(3, itemID);
			
			stmt.executeUpdate();
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
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM menuitem WHERE menuItemID = ?");
			stmt.setInt(1, menuItemIDInput);
			stmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public int getID()
	{
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
