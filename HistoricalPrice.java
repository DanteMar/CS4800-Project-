import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class HistoricalPrice {
	private int priceID;
	private double price;
	private Date d;
	
	public void newHistoricalPrice(double price, Date d)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO historicalprice (price, date) VALUES (?, ?)");

			stmt.setDouble(1, price);
			stmt.setDate(2, d);
			
			stmt.executeUpdate();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public int getID()
	{
		return priceID;
	}
	public Date getDate()
	{
		return d;
	}
	public double getPrice()
	{
		return price;
	}
}
