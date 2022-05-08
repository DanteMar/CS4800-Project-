import java.sql.Connection;
import java.sql.PreparedStatement;

public class Food_Order {
	private int menuitemID;
	private int orderID;
	private int quantity;
	
	public Food_Order() 
	{
	}
	
	public void newFoodOrder(int menuitemID, int orderID, int quantity)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO menuitem_order (menuitemid, orderid, quantity) VALUES (?, ?, ?)");

			stmt.setInt(1, menuitemID);
			stmt.setInt(2, orderID);
			stmt.setInt(3, quantity);
			
			stmt.executeUpdate();
			
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void deleteFoodOrder(int menuitemID, int orderID)
	{
		try
		{
			// all database values will change once database is setup
			Connection connection = LoginDataAccess.verifyCredentials();
					
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM menuitem_order WHERE menuitemid = ? AND orderid = ?");
			stmt.setInt(1, menuitemID);
			stmt.setInt(2, orderID);
			stmt.executeUpdate();
			
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public int getmenuitemID() {
		return menuitemID;
	}
	public int getorderID() {
		return orderID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int q) {
		quantity=q;
	}
}