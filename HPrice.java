import java.util.Date;
public class HPrice 
{
    private double price;
    private Date date;
    public HPrice()
    {
        price=0;
        date=new Date();
    }
    public HPrice(int pr, Date sfd)
    {
        price=pr;
        date=sfd;
    }
    public void setPrice(double p)
    {
        price=p;
    }
    public void setDate(Date d)
    {
        date=d;
    }
    public double getPrice()
    {return price;}
    public Date getDate()
    {return date;}


}
