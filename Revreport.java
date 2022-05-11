import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;

public class RevReport {    
    public static Revclass getRevenue(Date d1, Date d2, int bid) // returns the total amount of money made from a certain broncoID between 2 dates
    {
        try
        {
            RevClass revc;
            double t=0.0;
            int oiid=-1;
	    int counter=0;
        	Connection connection = LoginDataAccess.verifyCredentials();
        	PreparedStatement stmt = connection.prepareStatement(
        		"select cu.firstname, cu.lastname, ao.orderid, ao.odate,  mi.foodname, mio.quantity, ao.total
                from aorder as ao, menuitem_order as mio, menuitem as mi, customer as cu
                where cu.broncoid in (select ao.broncoid 
                                      where ao.odate between ? AND ? AND ao.broncoid = ? AND ao.orderid in (select mio.orderid 
                                                                                                            where mio.menuitemid =mi.menuitemid ))	   
                order by ao.orderid, ao.odate, mi.foodname, mio.quantity;");
        	stmt.setDate(1, d1);
        	stmt.setDate(2, d2);
                stmt.setInt(3, bid);
        	ResultSet rs = stmt.executeQuery();
        	while(rs.next())
            {
                revc.addReportbid(rs.getString("firstname"),rs.getString("lastname"),rs.getInt("orderid"),
                                  rs.getDate("odate"),rs.getString("foodname"),rs.getInt("quantity"),rs.getDouble("total"));
                if(rev.getoid().get(counter)!=oiid)
                {
                    oiid=rs.getInt("orderid");
                    t=t+rs.getDouble("total");
                }
		    counter++;
            }
            revc.addtotalstotal(t);
	    stmt.close();
			rs.close();
            return revc;
        }
	    catch (Exception e)
	    {
            System.out.println(e);
        }
        return null;
    }    

    
    public static RevClass getRevenue(Date d1, Date d2) //returns Revclass
    {
    	try
		{
            RevClass revc;
            double t=0.0;
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("Select ao.orderid, cu.broncoid,cu.firstname, cu.lastname, ao.odate,  mi.foodname, mio.quantity, ao.total
                                                                From aorder as ao, menuitem_order as mio, menuitem as mi, customer as cu
                                                                Where ao.odate between ? AND ? AND ao.broncoid= cu.broncoid AND ao.orderid in (select mio.orderid 
                                                                                                                                                where mio.menuitemid =mi.menuitemid )
                                                                Order by ao.orderid, ao.odate, mi.foodname, mio.quantity;");
			stmt.setDate(1,d1);
            stmt.setDate(2,d2);
			ResultSet rs = stmt.executeQuery();
            int oiid=-1;
									     int counter++;
			while(rs.next())
            {
                
                revc.addReportdates(rs.getInt("orderid"),rs.getInt("broncoid"),rs.getString("firstname"),
                rs.getString("lastname"),rs.getDate("odate"),rs.getString("foodname"),rs.getInt("quantity"),rs.getDouble("total"));
                if(rev.getoid().get(counter)!=oiid)
                {
		    oiid=rs.getInt("orderid");
                    t=t+rs.getDouble("total");
                }
		 counter++;
                
            }
            revc.addtotalstotal(t);
	 stmt.close();
									     rs.close();
            return revc;
		}
		catch (Exception e) {
			System.out.println(e);
		}
    	return null;
    }
   public static RevClass getHistoricalPrice(int menuitemID) 
 {
 	try
	{
         RevClass revc;
         double t=0.0;
		Connection connection = LoginDataAccess.verifyCredentials();
		PreparedStatement stmt = connection.prepareStatement("SELECT * from historicalprice where menuitemid = ?");
		stmt.setInt(1, menuitemID);
		ResultSet rs = stmt.executeQuery();
         while(rs.next())
         {
             revc.addHptice(rs.getInt("priceid"),rs.getDate("hdate"),rs.getDouble("hprice"));
 	 }
		stmt.close();
		rs.close();
		return revc;
	}
	catch (Exception e) {
		System.out.println(e);
	}
 	return null;
 }


























  
  
  
    public static RevClass getRevenue(int menuitid, Date d1, Date d2)
    {
        try
        {
            RevClass revc;
            double t=0.0;
            int counter=0;
            Connection connection = LoginDataAccess.verifyCredential99();
            PreparedStatement stmt = connection.prepareStatement("select me.foodname, ao.broncoid, ao.orderid, ao.odate, mio.quantity from  aorder as ao, menuitem as me, menuitem_order as mio where me.menuitemid in (select mio.menuitemid where  mio.orderid = ao.orderid AND mio.menuitemid= ? AND ao.odate between ? AND ? order by ao.odate DESC; ");
            stmt.setInt(1, menuitid);
            stmt.setDate(2, d1);
            stmt.setDate(3,d2);
            ResultSet rs = stmt.executeQuery();
            RevClass revcdum;
            int hdatecounter;
            int bronid=0;
            while(rs.next())
            {
                hdatecounter=0;
                revc.addReportmid(rs.getString("foodname"), rs.getInt("broncoid"), rs.getInt("orderid"), rs.getDate("odate"), rs.getInt("quantity"));
                //queryy date to compare
                revcdum=getHistoricalPrice(menuitid);
                //if(rs.get)
                //{
                    while((revcdum.gethdate().get(hdatecounter)!=null)&&(revc.getodate().get(counter).getTime()>=revcdum.gethdate().get(hdatecounter).getTime()));
                    {
                        hdatecounter++;
                    }
                    revc.addhprice(revcdm.gethprice().get(hdatecounter++));
                    total=total+revc.gethprice.get(counter);
                    counter++;
                //}
            }
            revc.addtotalstotal(t);
            stmt.close();
            rs.close();
            return revc;
            }catch (Exception e) {
        	System.out.println(e);
        }
        return null;
    }

    
}
