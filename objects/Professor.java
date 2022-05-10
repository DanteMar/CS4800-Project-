package objects;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class Professor extends Customer {

	private String department;
	private String office;
	private String research;
	private double discount = 0.10; // 10% off
	Professor()
	{
		
	}
	public void updateProfessor(int broncoID, String department, String office, String research)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			// all database values will change once database is setup
			
			PreparedStatement stmt = connection.prepareStatement("update customer set department = ?, office = ?, research = ?, discount = ? where broncoid = ?");
			stmt.setString(1, department);
			stmt.setString(2, office);
			stmt.setString(3, research);
			stmt.setDouble(4, discount); // last addition overwrites discount amount
			stmt.setInt(5, broncoID);
			
			stmt.executeUpdate();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
}
