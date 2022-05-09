import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;

public class RevReport {
    public static double getRevenue(Date d1, Date d2, int bid)
    {
        try
        {
        	Connection connection = LoginDataAccess.verifyCredentials();
        	// create the java statement
        	//Generate appropriate query
        	// all database values will change once database is setup
        	PreparedStatement stmt = connection.prepareStatement(
        		"select sum(total) from aorder,customer where broncoid=bid AND aorder.date between ? and ?");
        	stmt.setInt(1, bid);
        	stmt.setDate(2, d1);
        	stmt.setDate(3, d2);
        	ResultSet rs = stmt.executeQuery();
        	stmt.executeUpdate();
        	stmt.close();
        	return rs.getDouble("total");
        }
	    catch (Exception ex)
	    {
            System.out.println(ex);
            return 0.0;
        }
       
    }
    public static double getRevenue(Date d1, Date d2)    
    {
        try
        {
        	Connection connection = LoginDataAccess.verifyCredentials();
        	PreparedStatement stmt = connection.prepareStatement(
        		"select sum(total) from aorder where aorder.date between ? and ?");
        	stmt.setDate(1, d1);
        	stmt.setDate(2, d2);
        	ResultSet rs = stmt.executeQuery();
        	stmt.executeUpdate();
        	stmt.close();
            return rs.getDouble("total");
        }
        catch (Exception ex)
        {
        	System.out.println(ex);
            return 0.0;
        }
    }   

}
