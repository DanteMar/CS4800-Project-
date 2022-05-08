import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class Student extends Customer{
	
	Date EnterDate;
	Date GradDate;
	String major;
	String minor;
	
	Student()
	{
		
	}
	public void updateStudent(int customerID, Date EnterDate, Date GradDate, String major, String minor)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			// all database values will change once database is setup
			
			PreparedStatement stmt = connection.prepareStatement("update customer set enterdate =, graddate = ?, major = ?, minor = ? where customerid = ?");
			stmt.setDate(1, EnterDate);
			stmt.setDate(2, GradDate);
			stmt.setString(3, major);
			stmt.setString(4, minor);
			stmt.setInt(5, customerID);
			
			stmt.executeUpdate();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
}
