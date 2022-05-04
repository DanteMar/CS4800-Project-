import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
//connect to database
//make sureto chaangethe database url according to ur credential.
public class DBConnecter
{
    private static final String DATABASE_DRIVER = "postgresql-42.3.4.jar";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/BCDM";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12345";
    private static Connection connection=null;
    
    public static Connection getConnection()
    {
        try
        {
            if(connection!=null)
            {
                Class.forName(DATABASE_DRIVER);
                connection=DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
            }
            return connection;

        }
        catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
        
    }
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    

    
    
}
