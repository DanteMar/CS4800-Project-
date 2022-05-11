import java.util.*;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println("successfully connected");
        int mid=3;
        int bi=11;
        java.sql.Date d1= java.sql.Date.valueOf("2000-01-21");
        java.sql.Date d2= java.sql.Date.valueOf("2008-01-24");
        RevClass revt=new RevClass();
        revt=RevReport.getRevenue(d1, d2,mid);
        System.out.println("foodname,  bid, orderid,  odate,  quantity, hprice");
        for(int i=0;i<revt.getoid().size() ;i++)
        {   
            System.out.println(revt.getfname().get(i)+revt.getoid().get(i)+revt.getodate().get(i)+revt.getquantity().get(i)+revt.gethprice().get(i));
        }
        System.out.println("Sum:"+revt.gettotalstotal());
        /*System.out.println("firstname,  lastname,  orderid,  odate, foodname, quantity, total");
        for(int i=0;i<revt.getoid().size() ;i++)
        {
            System.out.println(revt.getfn().get(i)+"  "+revt.getln().get(i)+"  "+revt.getoid().get(i)+revt.getodate().get(i)+revt.getfname().get(i)+revt.getquantity().get(i)+revt.gettotal().get(i));
        }
        System.out.println("Sum:"+revt.gettotalstotal());
        */
       /*revt=RevReport.getRevenue(d1, d2);
        System.out.println("orderid,  broncoid,  firstname,  lastname, odate, foodname, quantity, total");
        for(int i=0;i<revt.getoid().size() ;i++)
        {
            System.out.println(revt.getoid().get(i)+"  "+revt.getbid().get(i)+"  "+revt.getfn().get(i)+revt.getln().get(i)+revt.getodate().get(i)+revt.getfname().get(i)+revt.getquantity().get(i)+revt.gettotal().get(i));
        }
        System.out.println("Sum:"+revt.gettotalstotal());
        */
        
    }
}
