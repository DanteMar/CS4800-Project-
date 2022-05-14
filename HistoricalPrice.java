
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "historicalprice")
public class HistoricalPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "priceid")
	private int priceid;

	@Column (name = "menuitemid")
	private int menuitemid;

	@Column (name = "hdate")
	private Date hdate;

	@Column (name = "hprice")
	private double hprice;


	HistoricalPrice()
	{

	}
	HistoricalPrice(double price, Date d, int menuitemID)
	{

		this.hprice = price;
		this.hdate = d;
		this.menuitemid = menuitemID;
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
		return priceid;
	}
	public Date getDate()
	{
		return hdate;
	}
	public double getPrice()
	{
		return hprice;
	}
	public void setID(int id)
	{
		priceid = id;
	}
	public void setDate(Date d)
	{
		hdate = d;
	}
	public void setPrice(double p)
	{
		hprice = p;
	}
}
