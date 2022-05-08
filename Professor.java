import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class Professor extends Customer {

	private String department;
	private String office;
	private String research;
	
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
			
			PreparedStatement stmt = connection.prepareStatement("update customer set department = ?, office = ?, research = ? where broncoid = ?");
			stmt.setString(1, department);
			stmt.setString(2, office);
			stmt.setString(3, research);
			stmt.setInt(4, broncoID);
			
			stmt.executeUpdate();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
}
