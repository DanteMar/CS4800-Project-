import java.sql.Connection;
import java.sql.Date;
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
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO foodorder (menuitemID, orderID, quantity) VALUES (?, ?, ?)");

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