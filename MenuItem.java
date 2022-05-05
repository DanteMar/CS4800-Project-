import java.sql.Connection;
import java.sql.PreparedStatement;

public class MenuItem {
	private int itemID;
	private String name;
	private double price;
	public void newMenuItem(String name, double price)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			String query = "INSERT INTO `menuItem` (`name`, `price`)";
			
			// execute the query
			connection.createStatement().executeUpdate(query);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void updateCustomer(int itemID, String name, double price)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			// all database values will change once database is setup
			connection.createStatement().executeUpdate("UPDATE `menuItem` SET `name` = '" + name + "' WHERE `itemID` = " + itemID);	
			connection.createStatement().executeUpdate("UPDATE `menuItem` SET `price` = '" + price + "' WHERE `itemID` = " + itemID);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public static void deleteMenuItem(int menuItemIDInput)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			String queryDeleteTransaction = "DELETE FROM menuItem WHERE `menuItem`.menuItemID = "
					+ menuItemIDInput;
			PreparedStatement delete = connection.prepareStatement(queryDeleteTransaction);
			delete.executeUpdate();
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
