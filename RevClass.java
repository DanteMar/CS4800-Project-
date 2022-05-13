import java.util.ArrayList;
import java.sql.Date;

public class RevClass {
    
    private ArrayList<String> fname;
    private ArrayList<Double> discount;
    private ArrayList<Integer> bid;
    private ArrayList<Integer> oid;
    private ArrayList<Integer> mid;
    private ArrayList<Date> odate;
    private ArrayList<Integer> quantity;
    //total per order
    private ArrayList<Double> total;
    //sum of all total per order
    private double totalstotal;
    private ArrayList<String> fn;
    private ArrayList<String> ln;
    //for historicalprice
    private ArrayList<Double> hprice;
    private ArrayList<Integer> hpriceid;
    private ArrayList<Date> hdate;
    //functions
    public RevClass()
    {
        fname=new ArrayList<String>();
        discount=new ArrayList<Double>();
        bid=new ArrayList<Integer>();
        oid= new ArrayList<Integer>();
        odate=new ArrayList<Date>();
        quantity= new ArrayList<Integer>();
        total=new ArrayList<Double>();
        totalstotal=0;
        fn=new ArrayList<String>();
        ln=new ArrayList<String>();
        hprice=new ArrayList<Double>();
        hpriceid=new ArrayList<Integer>();
        hdate=new ArrayList<Date>();

    }
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
    public void addhprice(Double d)
    {hprice.add(d);}
    public void addtotalstotal(double t)
    {totalstotal=t;}
    //getters
    public double gettotalstotal()
    {return totalstotal;}
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
