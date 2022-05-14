/*This is the unit testing file
This file tests the three types of revenue reports and the price history.
*/
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import java.sql.*;

public class testing {
    /*
    Test on getting price history when the given menuitemid=2
    value input menuitemid=2 
    */
    @Test 
    public void testOnPriceHistory()
    {
        int mid=2;
        int[] ExpectedpriceID={2,6,0,0,0,0,0,0,0,0};
        Date[] ExpectedhistDate={Date.valueOf("2002-07-20"),Date.valueOf("2011-02-20"),null,null,null,null,null,null,null,null};
        Double[] ExpectedhistPrice={2.9,2.5,null,null,null,null,null,null,null,null}; 
        
        RevClass revt=new RevClass();
        revt=RevReport.getHistoricalPrice(mid);
        
        int[] ActualpriceID=new int[10];
        Date[] ActualhisDate=new Date[10];
        Double[] ActualhisPrice=new Double[10];
        for(int i=0;i<revt.gethpriceid().size() ;i++)
        { 
          ActualpriceID[i]=revt.gethpriceid().get(i);
          ActualhisDate[i]=revt.gethdate().get(i);
          ActualhisPrice[i]=revt.gethprice().get(i);
        }   
        assertArrayEquals(ExpectedpriceID, ActualpriceID);
        assertArrayEquals(ExpectedhistDate, ActualhisDate);
        assertArrayEquals(ExpectedhistPrice, ActualhisPrice);                
    }
     /*
    Test on getting price history when the given menuitemid=1
    value input menuitemid=1 
    */
    @Test
    public void testOnPriceHistory2()
    {
        int mid=1;
        int[] ExpectedpriceID={1,3,5,0,0,0,0,0,0,0};
        Date[] ExpectedhistDate={Date.valueOf("2000-01-20"),Date.valueOf("2007-09-23"),Date.valueOf("2010-03-20"),null,null,null,null,null,null,null};
        Double[] ExpectedhistPrice={1.0,2.0,1.4,null,null,null,null,null,null,null}; 
        RevClass revt=new RevClass();
        revt=RevReport.getHistoricalPrice(mid);
        int[] ActualpriceID=new int[10];
        Date[] ActualhisDate=new Date[10];
        Double[] ActualhisPrice=new Double[10];
        for(int i=0;i<revt.gethpriceid().size() ;i++)
        { 
          ActualpriceID[i]=revt.gethpriceid().get(i);
          ActualhisDate[i]=revt.gethdate().get(i);
          ActualhisPrice[i]=revt.gethprice().get(i);
        }   
        assertArrayEquals(ExpectedpriceID, ActualpriceID);
        assertArrayEquals(ExpectedhistDate, ActualhisDate);
        assertArrayEquals(ExpectedhistPrice, ActualhisPrice); 
    }
    /*
    Test on getting revenue when the given dates are "2001-01-01"
    and  "2008-01-22"
    */
    @Test
    public void testOnRevReportDD1()
    {
        //Expected
        int[] ExpectedorderID={3,3,4,5,6,6,8,8,0,0};
        int[] ExpectedbroncoID={13,13,11,12,12,12,13,13,0,0};
        String[] ExpectedFirstName={"Ma","Ma","za","Da","Da","Da","Ma","Ma",null,null};
        String[] ExpectedLastName={"Xm","Xm","la","Te","Te","Te","Xm","Xm",null,null};
        Date[] ExpectedOdate={Date.valueOf("2001-04-23"),Date.valueOf("2001-04-23"),Date.valueOf("2003-05-23"),Date.valueOf("2006-02-23"),Date.valueOf("2007-02-23"),Date.valueOf("2007-02-23"),Date.valueOf("2006-02-23"),Date.valueOf("2006-02-23"),null,null};
        String[] EcpectedFoodName={"oatmeal","sardines","cheese","oatmeal","cheese","sardines","cheese","oatmeal",null,null};
        int[] ExpectedQuantity={3,4,2,2,3,1,2,3,0,0};
        Double[] ExpectedTotal={22.0,22.0,20.0,28.0,30.0,30.0,30.0,30.0,null,null};
        Double ExpectedTotalstotal=130.0;
        //Actual
        int[] ActualorderID= new int[10];
        int[] ActualbroncoID= new int [10];
        String[] ActualFirstName= new String [10];
        String[] ActualLastName= new String [10];
        Date[] ActualOdate= new Date [10];
        String[] ActualFoodName= new String [10];
        int[] ActualQuantity= new int [10];
        Double[] ActualTotal= new Double [10];
        Double ActualTotalstotal=(double) 0;
        //input values
        Date d1= Date.valueOf("2001-01-01");
        Date d2= Date.valueOf("2008-01-22");
        RevClass revt=new RevClass();
        revt=RevReport.getRevenue(d1,d2);
        for(int i=0;i<revt.getoid().size() ;i++)
        {   
            ActualorderID[i]=revt.getoid().get(i);
            ActualbroncoID[i]=revt.getbid().get(i);
            ActualFirstName[i]=revt.getfn().get(i);
            ActualLastName[i]=revt.getln().get(i);
            ActualOdate[i]=revt.getodate().get(i);
            ActualFoodName[i]=revt.getfname().get(i);
            ActualQuantity[i]=revt.getquantity().get(i);
            ActualTotal[i]=revt.gettotal().get(i);
        }
        ActualTotalstotal=new Double(revt.gettotalstotal());
        //testing
        assertArrayEquals(ExpectedFirstName, ActualFirstName);
        assertArrayEquals(ExpectedLastName, ActualLastName);
        assertArrayEquals(EcpectedFoodName, ActualFoodName);
        assertArrayEquals(ExpectedOdate, ActualOdate);
        assertArrayEquals(ExpectedQuantity, ActualQuantity);
        assertArrayEquals(ExpectedTotal, ActualTotal);
        assertArrayEquals(ExpectedbroncoID, ActualbroncoID);
        assertArrayEquals(ExpectedorderID,ActualorderID);
        assertEquals(ExpectedTotalstotal, ActualTotalstotal);
    }
    /*Test on getting revenue when the given dates are "2000-01-01"
    and  "2006-01-22"
    */
    @Test
    public void testOnRevReportDD2()
    {
         //Expected
        String[] EcpectedFoodName={"cheese","oatmeal","sardines","cheese","oatmeal","oatmeal","sardines","cheese",null,null};
        int[] ExpectedQuantity={3,2,1,3,1,3,4,2,0,0};
        Double[] ExpectedTotal={14.0,14.0,14.0,21.0,21.0,22.0,22.0,20.0,null,null};
        Double ExpectedTotalstotal=77.0;    
        int[] ExpectedorderID={1,1,1,2,2,3,3,4,0,0};
        int[] ExpectedbroncoID={11,11,11,12,12,13,13,11,0,0};
        String[] ExpectedFirstName={"za","za","za","Da","Da","Ma","Ma","za",null,null};
        String[] ExpectedLastName={"la","la","la","Te","Te","Xm","Xm","la",null,null};
        Date[] ExpectedOdate={Date.valueOf("2000-02-23"),Date.valueOf("2000-02-23"),Date.valueOf("2000-02-23"),Date.valueOf("2000-03-23"),Date.valueOf("2000-03-23"),Date.valueOf("2001-04-23"),Date.valueOf("2001-04-23"),Date.valueOf("2003-05-23"),null,null};
        //Actual
        int[] ActualorderID= new int[10];
        int[] ActualbroncoID= new int [10];
        String[] ActualFirstName= new String [10];
        String[] ActualLastName= new String [10];
        Date[] ActualOdate= new Date [10];
        String[] ActualFoodName= new String [10];
        int[] ActualQuantity= new int [10];
        Double[] ActualTotal= new Double [10];
        Double ActualTotalstotal=(double) 0;
        //input values
        Date d1= Date.valueOf("2000-01-01");
        Date d2= Date.valueOf("2006-01-22");
        RevClass revt=new RevClass();
        revt=RevReport.getRevenue(d1,d2);


        for(int i=0;i<revt.getoid().size() ;i++)
        {   
            ActualorderID[i]=revt.getoid().get(i);
            ActualbroncoID[i]=revt.getbid().get(i);
            ActualFirstName[i]=revt.getfn().get(i);
            ActualLastName[i]=revt.getln().get(i);
            ActualOdate[i]=revt.getodate().get(i);
            ActualFoodName[i]=revt.getfname().get(i);
            ActualQuantity[i]=revt.getquantity().get(i);
            ActualTotal[i]=revt.gettotal().get(i);
        }
        ActualTotalstotal=new Double(revt.gettotalstotal());
        assertArrayEquals(ExpectedFirstName, ActualFirstName);
        assertArrayEquals(ExpectedLastName, ActualLastName);
        assertArrayEquals(EcpectedFoodName, ActualFoodName);
        assertArrayEquals(ExpectedOdate, ActualOdate);
        assertArrayEquals(ExpectedQuantity, ActualQuantity);
        assertArrayEquals(ExpectedTotal, ActualTotal);
        assertArrayEquals(ExpectedbroncoID, ActualbroncoID);
        assertArrayEquals(ExpectedorderID,ActualorderID);
        assertEquals(ExpectedTotalstotal, ActualTotalstotal);
        
    }
    /*Test on getting revenue when the given dates are "2000-01-01"
    and  "2008-01-22" and broncoid=12
    */
    @Test
    public void testOnRevReportDDB1()
    {
        String[] EcpectedFoodName={"cheese","oatmeal","oatmeal","cheese","sardines",null,null,null,null,null};
        int[] ExpectedQuantity={3,1,2,3,1,0,0,0,0,0};
        Double[] ExpectedTotal={21.0,21.0,28.0,30.0,30.0,null,null,null,null,null};
        Double ExpectedTotalstotal=79.0;    
        int[] ExpectedorderID={2,2,5,6,6,0,0,0,0,0};
        String[] ExpectedFirstName={"Da","Da","Da","Da","Da",null,null,null,null,null};
        String[] ExpectedLastName={"Te","Te","Te","Te","Te",null,null,null,null,null};
        double ExpectedDiscount=0.2;
        Date[] ExpectedOdate={Date.valueOf("2000-03-23"),Date.valueOf("2000-03-23"),Date.valueOf("2006-02-23"),Date.valueOf("2007-02-23"),Date.valueOf("2007-02-23"),null,null,null,null,null};
        //Actual
        int[] ActualorderID= new int[10];
        double ActualDiscount=0.0;
        String[] ActualFirstName= new String [10];
        String[] ActualLastName= new String [10];
        Date[] ActualOdate= new Date [10];
        String[] ActualFoodName= new String [10];
        int[] ActualQuantity= new int [10];
        Double[] ActualTotal= new Double [10];
        Double ActualTotalstotal=(double) 0;
        //input values
        Date d1= Date.valueOf("2000-01-01");
        Date d2= Date.valueOf("2008-01-22");
        int bbid=12;
        RevClass revt=new RevClass();
        revt=RevReport.getRevenue(d1,d2,bbid);
        for(int i=0;i<revt.getoid().size() ;i++)
        {   
            ActualorderID[i]=revt.getoid().get(i);
            ActualFirstName[i]=revt.getfn().get(i);
            ActualLastName[i]=revt.getln().get(i);
            ActualOdate[i]=revt.getodate().get(i);
            ActualFoodName[i]=revt.getfname().get(i);
            ActualQuantity[i]=revt.getquantity().get(i);
            ActualTotal[i]=revt.gettotal().get(i);
        }
        ActualDiscount= revt.getdiscount();
        ActualTotalstotal=new Double(revt.gettotalstotal());
        assertArrayEquals(ExpectedFirstName, ActualFirstName);
        assertArrayEquals(ExpectedLastName, ActualLastName);
        assertArrayEquals(EcpectedFoodName, ActualFoodName);
        assertArrayEquals(ExpectedOdate, ActualOdate);
        assertArrayEquals(ExpectedQuantity, ActualQuantity);
        assertArrayEquals(ExpectedTotal, ActualTotal);
        assertEquals(ExpectedDiscount, ActualDiscount,0.00001);
        assertArrayEquals(ExpectedorderID,ActualorderID);
        assertEquals(ExpectedTotalstotal, ActualTotalstotal);
    }
    /*Test on getting revenue when the given dates are "2003-01-01"
    and "2010-01-22" and broncoid=13
    */  
    @Test
    public void testOnRevReportDDB2()
    {
        String[] EcpectedFoodName={"cheese","oatmeal","sardines","cheese","oatmeal",null,null,null,null,null};
        int[] ExpectedQuantity={3,1,4,2,3,0,0,0,0,0};
        Double[] ExpectedTotal={26.0,26.0,26.0,30.0,30.0,null,null,null,null,null};
        Double ExpectedTotalstotal=56.0;    
        int[] ExpectedorderID={7,7,7,8,8,0,0,0,0,0};
        String[] ExpectedFirstName={"Ma","Ma","Ma","Ma","Ma",null,null,null,null,null};
        String[] ExpectedLastName={"Xm","Xm","Xm","Xm","Xm",null,null,null,null,null};
        double ExpectedDiscount=0.0;
        Date[] ExpectedOdate={Date.valueOf("2008-02-23"),Date.valueOf("2008-02-23"),Date.valueOf("2008-02-23"),Date.valueOf("2006-02-23"),Date.valueOf("2006-02-23"),null,null,null,null,null};

         //Actual
        int[] ActualorderID= new int[10];
        double ActualDiscount=0.0;
        String[] ActualFirstName= new String [10];
        String[] ActualLastName= new String [10];
        Date[] ActualOdate= new Date [10];
        String[] ActualFoodName= new String [10];
        int[] ActualQuantity= new int [10];
        Double[] ActualTotal= new Double [10];
        Double ActualTotalstotal=(double) 0;
        //input values
        Date d1= Date.valueOf("2003-01-01");
        Date d2= Date.valueOf("2010-01-22");
        int bbid=13;
        RevClass revt=new RevClass();
        revt=RevReport.getRevenue(d1,d2,bbid);
        for(int i=0;i<revt.getoid().size() ;i++)
        {   
        ActualorderID[i]=revt.getoid().get(i);
        ActualFirstName[i]=revt.getfn().get(i);
        ActualLastName[i]=revt.getln().get(i);
        ActualOdate[i]=revt.getodate().get(i);
        ActualFoodName[i]=revt.getfname().get(i);
        ActualQuantity[i]=revt.getquantity().get(i);
        ActualTotal[i]=revt.gettotal().get(i);
        }
        ActualDiscount= revt.getdiscount();
        ActualTotalstotal=new Double(revt.gettotalstotal());
        assertArrayEquals(ExpectedFirstName, ActualFirstName);
        assertArrayEquals(ExpectedLastName, ActualLastName);
        assertArrayEquals(EcpectedFoodName, ActualFoodName);
        assertArrayEquals(ExpectedOdate, ActualOdate);
        assertArrayEquals(ExpectedQuantity, ActualQuantity);
        assertArrayEquals(ExpectedTotal, ActualTotal);
        assertEquals(ExpectedDiscount, ActualDiscount,0.00001);
        assertArrayEquals(ExpectedorderID,ActualorderID);
        assertEquals(ExpectedTotalstotal, ActualTotalstotal);
    }
    /*Test on getting revenue when the given dates are "2000-01-21"
    and "2008-01-24" and menuitemid=1
    */  
    @Test
    public void testOnRevReportDDM1()
    {
        String[] EcpectedFoodName={"oatmeal","oatmeal","oatmeal","oatmeal","oatmeal",null,null,null,null,null};
        int[] ExpectedQuantity={2,1,3,2,3,0,0,0,0,0};
        Double[] ExpectedTotal={2.0,0.8,3.0,1.6,3.0,null,null,null,null,null};
        Double ExpectedTotalstotal=10.4;    
        int[] ExpectedorderID={1,2,3,5,8,0,0,0,0,0};
        int[] ExpectedbroncoID={11,12,13,12,13,0,0,0,0,0};
        Date[] ExpectedOdate={Date.valueOf("2000-02-23"),Date.valueOf("2000-03-23"),Date.valueOf("2001-04-23"),Date.valueOf("2006-02-23"),Date.valueOf("2006-02-23"),null,null,null,null,null};
        Double[] ExpectedDiscount={0.0,0.2,0.0,0.2,0.0,null,null,null,null,null};
         //Actual
         int[] ActualorderID= new int[10];
         Date[] ActualOdate= new Date [10];
         String[] ActualFoodName= new String [10];
         int[] ActualQuantity= new int [10];
         Double[] ActualTotal= new Double [10];
         Double ActualTotalstotal=(double) 0;
         int[] ActualbroncoID= new int[10];
         Double[] ActualDiscount=new Double[10];
        

         //input values
         Date d1= Date.valueOf("2000-01-21");
         Date d2= Date.valueOf("2008-01-24");
         int mid=1;
         RevClass revt=new RevClass();
         revt=RevReport.getRevenue(mid,d1,d2);
         for(int i=0;i<revt.getfname().size() ;i++)
         {   
            ActualorderID[i]=revt.getoid().get(i);
            ActualOdate[i]=revt.getodate().get(i);
            ActualFoodName[i]=revt.getfname().get(i);
            ActualQuantity[i]=revt.getquantity().get(i);
            ActualTotal[i]=revt.gettotal().get(i);
            ActualbroncoID[i]=revt.getbid().get(i);
            ActualDiscount[i]=revt.getmdiscount().get(i);
         }

         ActualTotalstotal=revt.gettotalstotal();
         assertArrayEquals(EcpectedFoodName, ActualFoodName);
         assertArrayEquals(ExpectedOdate, ActualOdate);
         assertArrayEquals(ExpectedQuantity, ActualQuantity);
         assertArrayEquals(ExpectedTotal, ActualTotal);
         assertArrayEquals(ExpectedorderID,ActualorderID);
         assertArrayEquals(ExpectedbroncoID, ActualbroncoID);
         assertArrayEquals(ExpectedDiscount, ActualDiscount);
         assertEquals(ExpectedTotalstotal, ActualTotalstotal);
    }
     /*Test on getting revenue when the given dates are "2000-01-21"
        and "2008-01-24" and menuitemid=1
    */  
    @Test
    public void testOnRevReportDDM2()
    {
        String[] EcpectedFoodName={"cheese","cheese","cheese",null,null,null,null,null,null,null};
        int[] ExpectedQuantity={2,3,3,0,0,0,0,0,0,0};
        Double[] ExpectedTotal={5.8,6.96,8.7,null,null,null,null,null,null,null};
        Double ExpectedTotalstotal=21.46;    
        int[] ExpectedorderID={8,6,7,0,0,0,0,0,0,0};
        int[] ExpectedbroncoID={13,12,13,0,0,0,0,0,0,0};
        Date[] ExpectedOdate={Date.valueOf("2006-02-23"),Date.valueOf("2007-02-23"),Date.valueOf("2008-02-23"),null,null,null,null,null,null,null};
        Double[] ExpectedDiscount={0.0,0.2,0.0,null,null,null,null,null,null,null};      
        //Actual
        int[] ActualorderID= new int[10];
        Date[] ActualOdate= new Date [10];
        String[] ActualFoodName= new String [10];
        int[] ActualQuantity= new int [10];
        Double[] ActualTotal= new Double [10];
        Double ActualTotalstotal=(double) 0;
        int[] ActualbroncoID= new int[10];
        Double[] ActualDiscount=new Double[10];
         //input values
         Date d1= Date.valueOf("2004-01-21");
         Date d2= Date.valueOf("2010-01-24");
         int mid=2;
         RevClass revt=new RevClass();
         revt=RevReport.getRevenue(mid,d1,d2);
         for(int i=0;i<revt.getfname().size() ;i++)
         {   
            ActualorderID[i]=revt.getoid().get(i);
            ActualOdate[i]=revt.getodate().get(i);
            ActualFoodName[i]=revt.getfname().get(i);
            ActualQuantity[i]=revt.getquantity().get(i);
            ActualTotal[i]=revt.gettotal().get(i);
            ActualbroncoID[i]=revt.getbid().get(i);
            ActualDiscount[i]=revt.getmdiscount().get(i);
         }
     
        ActualTotalstotal=revt.gettotalstotal();
        assertArrayEquals(EcpectedFoodName, ActualFoodName);
        assertArrayEquals(ExpectedOdate, ActualOdate);
        assertArrayEquals(ExpectedQuantity, ActualQuantity);
        assertArrayEquals(ExpectedTotal, ActualTotal);
        assertArrayEquals(ExpectedorderID,ActualorderID);
        assertArrayEquals(ExpectedbroncoID, ActualbroncoID);
        assertArrayEquals(ExpectedDiscount, ActualDiscount);
        assertEquals(ExpectedTotalstotal, ActualTotalstotal);
    }
   
   
   
   
   
   
   
   

    
}
