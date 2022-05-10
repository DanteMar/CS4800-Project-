import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
public class RevClass {
    
    ArrayList<String> fname;
    ArrayList<Double> discount;
    ArrayList<Integer> bid;
    ArrayList<Integer> oid;
    ArrayList<Date> odate;
    ArrayList<Integer> quantity;
    ArrayList<Double> hprice;
    ArrayList<Double> total;
    ArrayList<String> fn;
    ArrayList<String> ln;
    public void setReportoid()
    {
        //parsing rs.get() in here
        bid=bconid;
        fname=fn;
        quantity=qt;
        oid=orderid;
        odate=od;
        total=t;
    }
    public void setReportbid()
    {
        //parsing rs.get() in here
     fname=fn;
     bid=bconid;
     oid=orderid;
     odate=od;
     quantity=qt;
    }
    public void setReportmid()
    {
        //parsing rs.get() in here

    }
    public ArrayList<String> getfname()
    {return fname;} 
    public ArrayList<Integer> getbid()
    {return bid;}
    public ArrayList<Integer> getoid()
    {return oid;}
    public ArrayList<Date> getodate()
    {return odate;}
    public ArrayList<Integer> getquantity()
    {return quantity;}
    public ArrayList<Double> gethprice()
    {return hprice;}
    public ArrayList<Double> gettotal()
    {return total;}
    public ArrayList<String> getfn()
    {return fn;}
    public ArrayList<String> getln()
    {return ln;}

}
