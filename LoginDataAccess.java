import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginDataAccess {

	public static Connection verifyCredentials() throws ClassNotFoundException, SQLException {

		final String URL = "jdbc:postgresql://localhost:5432/authentication";

		final String USER = "postgres";

		final String PWD = "1234"; //change for your local database

		try 
		{   
			Connection connection = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("Database connected!");
	
		    return connection;	    
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		    throw new IllegalStateException("Cannot connect the database!", e);

		}
	}

}

