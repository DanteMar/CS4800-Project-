package objects;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class Student extends Customer{
	
	private	Date EnterDate;
	private	Date GradDate;
	private	String major;
	private	String minor;
	private double discount = 0.05; // 5% off
	Student()
	{
		
	}
	public void updateStudent(int broncoID, Date EnterDate, Date GradDate, String major, String minor)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			// all database values will change once database is setup
			
			PreparedStatement stmt = connection.prepareStatement("update customer set edate = ?, gdate = ?, major = ?, minor = ?, discount = ? where broncoid = ?");
			stmt.setDate(1, EnterDate);
			stmt.setDate(2, GradDate);
			stmt.setString(3, major);
			stmt.setString(4, minor);
			stmt.setDouble(5, discount); // last addition overwrites discount amount
			stmt.setInt(6, broncoID);
			
			stmt.executeUpdate();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
}
