import java.util.ArrayList;
import java.sql.Date;

public class RevClass {
    
    ArrayList<String> fname;
    ArrayList<Double> discount;
    ArrayList<Integer> bid;
    ArrayList<Integer> oid;
    ArrayList<Date> odate;
    ArrayList<Integer> quantity;
    //total per order
    ArrayList<Double> total;
    //sum of all total per order
    double totalstotal;
    ArrayList<String> fn;
    ArrayList<String> ln;
    //for historicalprice
    ArrayList<Double> hprice;
    ArrayList<Integer> hpriceid;
    ArrayList<Date> hdate;
    //functions
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
    public void addHptice(int priceid, Date d, double hp)
    {
        hprice.add(hp);
        hpriceid.add(priceid);
        hdate.add(d);
    }
    public void addReportmid(String foodn, int brid, int oiid, Date od, int quant)
    {
        fname.add(foodn);
        bid.add(brid);
        oid.add(oiid);
        odate.add(od);
        quantity.add(quant);
    }
    public void addhpirce(Double d)
    {hprice.add(d);}
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
    public ArrayList<Double> gettotal()
    {return total;}
    public ArrayList<String> getfn()
    {return fn;}
    public ArrayList<String> getln()
    {return ln;}
    public ArrayList<Double> gethprice()
    {return hprice;}
    public ArrayList<Integer> gethpriceid()
    {return hpriceid;}
    public ArrayList<Date> gethdate()
    {return hdate;}

}
