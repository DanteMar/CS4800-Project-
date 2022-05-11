package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;

public class RevReport2 {
    public static double getRevenue(Date d1, Date d2)    //returns the total amount of money made within 2 dates
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
    public static double getRevenue(int broncoID)    // returns the total amount of money made from a certain broncoID
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
    public static RevClass2 getRevenueSet(Date d1, Date d2) //returns a resultset of broncoid, fname, lastname and orderdate between a 2 date range
    {
    	try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("select customer.broncoid, customer.firstname, customer.lastname, aorder.odate, aorder.orderid  FROM customer INNER JOIN aorder ON aorder.broncoid = customer.broncoid where odate between ? and ?");
			stmt.setDate(1, d1);
        	stmt.setDate(2, d2);
			ResultSet rs = stmt.executeQuery();
			RevClass2 dlist = new RevClass2();
			String fname;
			String lname;
			String broncoid;
			String date3;
			String orderid;
			while (rs.next()) 
			{
				fname = rs.getString("firstname");
				lname = rs.getString("lastname");
				broncoid = String.valueOf(rs.getInt("broncoid"));
				date3 = rs.getDate("odate").toString();
				orderid = String.valueOf(rs.getInt("orderid"));
				dlist.addReportdates(orderid, broncoid, fname, lname, date3);
			}
			
			return dlist;
		}
		catch (Exception e) {
			System.out.println(e);
		}
    	return null;
    }
    public static RevClass2 getRevenueSet(int broncoID) //returns a resultset of broncoid, fname, lastname, orderid and orderdate for a given broncoID
    {
    	try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("select customer.broncoid, customer.firstname, customer.lastname, aorder.odate, aorder.orderid  FROM customer INNER JOIN aorder ON aorder.broncoid = customer.broncoid where aorder.broncoid = ?");
			stmt.setInt(1, broncoID);
			ResultSet rs = stmt.executeQuery();
			RevClass2 dlist = new RevClass2();
			String fname;
			String lname;
			String broncoid;
			String date3;
			String orderid;
			while (rs.next()) 
			{
				fname = rs.getString("firstname");
				lname = rs.getString("lastname");
				broncoid = String.valueOf(rs.getInt("broncoid"));
				date3 = rs.getDate("odate").toString();
				orderid = String.valueOf(rs.getInt("orderid"));
				dlist.addReportdates(orderid, broncoid, fname, lname, date3);
			}
			
			return dlist;
		}
		catch (Exception e) {
			System.out.println(e);
		}
    	return null;
    }
}
