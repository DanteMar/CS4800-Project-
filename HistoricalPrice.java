package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class HistoricalPrice {
	private int priceID;
	private double price;
	private Date d;
	private int menuitemID;
	
	HistoricalPrice()
	{
		
	}
	HistoricalPrice(double price, Date d, int menuitemID)
	{
		this.price = price;
		this.d = d;
		this.menuitemID = menuitemID;
	}
	public void newHistoricalPrice(double price, Date d, int menuitemid)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO historicalprice (hprice, hdate, menuitemid) VALUES (?, ?, ?)");

			stmt.setDouble(1, price);
			stmt.setDate(2, d);
			stmt.setInt(3, menuitemid);
			
			stmt.executeUpdate();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void deleteHistoricalPrice(int menuitemid)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM historicalprice WHERE menuitemid = ?");
			stmt.setInt(1, menuitemid);
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
