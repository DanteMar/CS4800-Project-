import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.Date;

public class RevReport {    
    public static RevClass getRevenue(java.sql.Date d1, java.sql.Date d2, int bid) // returns the total amount of money made from a certain broncoID between 2 dates
    {
        try
        {
            RevClass revc=new RevClass();
            double t=0.0;
            int oiid=-1;
	        int counter=0;
        	Connection connection = DBconnecter.getConnection();
        	PreparedStatement stmt = connection.prepareStatement("select cu.firstname, cu.lastname, ao.orderid, ao.odate,  mi.foodname, mio.quantity, cu.discount, ao.total from aorder as ao, menuitem_order as mio, menuitem as mi, customer as cu where cu.broncoid in (select ao.broncoid where ao.odate between ? AND ? AND ao.broncoid = ? AND ao.orderid in (select mio.orderid " 
                                                                                                            +" where mio.menuitemid =mi.menuitemid ))"	   
                                                                 +" order by ao.orderid, ao.odate, mi.foodname, mio.quantity;");
        	stmt.setDate(1, d1);
        	stmt.setDate(2, d2);
            stmt.setInt(3, bid);
        	ResultSet rs = stmt.executeQuery();
        	while(rs.next())
            {
                revc.addReportbid(rs.getString("firstname"),rs.getString("lastname"),rs.getInt("orderid"),
                                  rs.getDate("odate"),rs.getString("foodname"),rs.getInt("quantity"),rs.getDouble("discount"), rs.getDouble("total"));
                if(revc.getoid().get(counter)!=oiid)
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
    public static RevClass getRevenue(java.sql.Date d1, java.sql.Date d2) //returns Revclass
    {
    	try
		{
            RevClass revc=new RevClass();
            double t=0.0;
			Connection connection = DBconnecter.getConnection();
			PreparedStatement stmt = connection.prepareStatement("Select ao.orderid, cu.broncoid,cu.firstname, cu.lastname, ao.odate,  mi.foodname, mio.quantity, ao.total "+
                                                                "From aorder as ao, menuitem_order as mio, menuitem as mi, customer as cu "+
                                                                "Where ao.odate between ? AND ? AND ao.broncoid= cu.broncoid AND ao.orderid in (select mio.orderid "+ 
                                                                                                                                                "where mio.menuitemid =mi.menuitemid )"+
                                                                "Order by ao.orderid, ao.odate, mi.foodname, mio.quantity;");
			stmt.setDate(1,d1);
            stmt.setDate(2,d2);
			ResultSet rs = stmt.executeQuery();
            int oiid=-1;
			int counter=0;
			while(rs.next())
            {
                
                revc.addReportdates(rs.getInt("orderid"),rs.getInt("broncoid"),rs.getString("firstname"),
                rs.getString("lastname"),rs.getDate("odate"),rs.getString("foodname"),rs.getInt("quantity"),rs.getDouble("total"));
                if(revc.getoid().get(counter)!=oiid)
                {
		            oiid=revc.getoid().get(counter);
                    t=t+revc.gettotal().get(counter);
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
        RevClass revc=new RevClass();
		Connection connection = DBconnecter.getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * from historicalprice where menuitemid = ? order by hdate ASC;");
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
    public static RevClass getRevenue(int menuitid, java.sql.Date d1, java.sql.Date d2)
    {
        try
        {
            RevClass revc=new RevClass();
            double total=0.0;
            int counter=0;
            Connection connection = DBconnecter.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select me.foodname, ao.broncoid, ao.orderid, ao.odate, mio.quantity, cu.discount "+
            " from  aorder as ao, menuitem as me, menuitem_order as mio, customer as cu "+
            " where me.menuitemid in (select mio.menuitemid where  mio.menuitemid=? AND ao.odate between ? AND ? AND mio.orderid in (select ao.orderid "+
            " where ao.broncoid=cu.broncoid))"+
            " order by ao.odate ASC;");

            stmt.setInt(1, menuitid);
            stmt.setDate(2, d1);
            stmt.setDate(3,d2);
            ResultSet rs = stmt.executeQuery();
            RevClass revcdum=new RevClass();
            revcdum=getHistoricalPrice(menuitid);
            int hdatecounter=0;//
            java.util.Date ddumy1;
            java.util.Date ddumy2;
            while(rs.next())
            {
                //hdatecounter=0;
                revc.addReportmid(rs.getString("foodname"), rs.getInt("broncoid"), rs.getInt("orderid"), rs.getDate("odate"), rs.getInt("quantity"),rs.getDouble("discount"));
                ddumy1=new java.util.Date(revc.getodate().get(counter).getTime());//odate
                ddumy2=new  java.util.Date(revcdum.gethdate().get(hdatecounter).getTime());//hdate
                while((hdatecounter<revcdum.gethdate().size()) && (ddumy2.compareTo(ddumy1)<0))
                {
                    hdatecounter++;
                    if(hdatecounter<revcdum.gethdate().size())
                     ddumy2=new  java.util.Date(revcdum.gethdate().get(hdatecounter).getTime());
                    
                }
                if(ddumy2.compareTo(ddumy1)>0 || hdatecounter>=revcdum.gethdate().size())
                {
                    hdatecounter=hdatecounter-1;
                }
                //incase which would normally not happend, only happened due to bad data
                if(hdatecounter<0)
                    hdatecounter++;
                revc.addhprice(revcdum.gethprice().get(hdatecounter));
            
                if(revc.getmdiscount().get(counter)==0.0)
                  { 
                       total=total+(revc.gethprice().get(counter)*revc.getquantity().get(counter));
                       revc.addtotal(revc.gethprice().get(counter)*revc.getquantity().get(counter));
                  }
                else
                {
                    total=total+(revc.gethprice().get(counter)*revc.getquantity().get(counter)*(1-revc.getmdiscount().get(counter)));
                    revc.addtotal(revc.gethprice().get(counter)*revc.getquantity().get(counter)*(1-revc.getmdiscount().get(counter)));
                }
                counter++;
            }
            revc.addtotalstotal(total);
            stmt.close();
            rs.close();
            return revc;
            }catch (Exception e) {
        	System.out.println(e);
        }
        return null;
    }
}