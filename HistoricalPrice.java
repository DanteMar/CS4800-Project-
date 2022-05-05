import java.sql.Connection;

public class HistoricalPrice {
	private int priceID;
	private double price;
	private Date d;
	
	public void newHistoricalPrice(double price, Date d)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			String query = "INSERT INTO `historicalPrice` (`price`, `d`)";
			
			// execute the query
			connection.createStatement().executeUpdate(query);
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
