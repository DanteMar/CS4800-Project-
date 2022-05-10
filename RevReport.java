package test;
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
        		"select sum(total) as sum_price from aorder where broncoid = ?  AND odate between ? and ?");
        	stmt.setInt(1, bid);
        	stmt.setDate(2, d1);
        	stmt.setDate(3, d2);
        	ResultSet rs = stmt.executeQuery();
        	rs.next();
            return rs.getDouble("sum_price");
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
        	"select sum(total) as sum_price from aorder where odate between ? and ?");
        	stmt.setDate(1, d1);
        	stmt.setDate(2, d2);
        	ResultSet rs = stmt.executeQuery();
        	rs.next();
            return rs.getDouble("sum_price");
        }
        catch (Exception ex)
        {
        	System.out.println(ex);
            return 0.0;
        }
    }  
    public static double getRevenue(int broncoID)    
    {
        try
        {
        	Connection connection = LoginDataAccess.verifyCredentials();
        	PreparedStatement stmt = connection.prepareStatement(
        	"select sum(total) as sum_price from aorder where broncoid = ?");
        	stmt.setInt(1, broncoID);
        	ResultSet rs = stmt.executeQuery();
        	rs.next();
            return rs.getDouble("sum_price");
        }
        catch (Exception ex)
        {
        	System.out.println(ex);
            return 0.0;
        }
    }  
    public static ResultSet getRevenueSet(Date d1, Date d2) //returns a resultset of broncoid, fname, lastname and orderdate between a 2 date range
    {
    	try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("select customer.broncoid, customer.firstname, customer.lastname, aorder.odate  FROM customer INNER JOIN aorder ON aorder.broncoid = customer.broncoid where odate between ? and ?");
			stmt.setDate(1, d1);
        	stmt.setDate(2, d2);
			ResultSet rs = stmt.executeQuery();
			return rs;
		}
		catch (Exception e) {
			System.out.println(e);
		}
    	return null;
    }
    public static ResultSet getRevenueSet(int broncoID) //returns a resultset of broncoid, fname, lastname, orderid and orderdate for a given broncoID
    {
    	try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("select customer.broncoid, customer.firstname, customer.lastname, aorder.odate, aorder.orderid  FROM customer INNER JOIN aorder ON aorder.broncoid = customer.broncoid where aorder.broncoid = ?");
			stmt.setInt(1, broncoID);
			ResultSet rs = stmt.executeQuery();
			return rs;
		}
		catch (Exception e) {
			System.out.println(e);
		}
    	return null;
    }
}
