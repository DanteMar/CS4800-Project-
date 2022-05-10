import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
/*return report based on order number: 1. name 2. bronco id 3. food items 4. date 5. total price
return based on bronco id: 1. name 2. bronco id 3. order number 4. date(s) 5. total price
return based on date: 1. name(s) 2. date. bronco id(s) 4. total price
^for revenue reports*/
public class RevClass {
    
    ArrayList<String> fname;
    ArrayList<Double> discount;
    ArrayList<Integer> bid;
    ArrayList<Integer> oid;
    ArrayList<Date> odate;
    ArrayList<Integer> quantity;
    ArrayList<Double> hprice;
    //total per order
    ArrayList<Double> total;
    //sum of all total per order
    double totalstotal;
    ArrayList<String> fn;
    ArrayList<String> ln;
    public void addReportdates(int od, int bd, String fin,String lin, Date d, String foodn, int qt, double t)
    {
        bid.add(bd);
        oid.add(od);
        odate.add(d);
        fn.add(fin);
        ln.add(lin);
        odate.add(d);
        fname.add(foodn);
        quantity.add(qt);
        total.add(t);
    }
    public void addReportbid(String fin,String lin,int od, Date d, String foodn, int qt, double t)
    {
    oid.add(od);
    odate.add(d);
    fn.add(fin);
    ln.add(lin);
    odate.add(d);
    fname.add(foodn);
    quantity.add(qt);
    total.add(t);

    }
    /*public void addReportmid()
    {

    }*/
    public void addtotalstotal(double t)
    {totalstotal=t;}
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
