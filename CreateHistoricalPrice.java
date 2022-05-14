
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateHistoricalPrice {
	
	public void CreateHistoricalP(double val, Date d, int id)
	{
		SessionFactory factory = new Configuration().
				                 configure("hibernate.cfg.xml").
				                 addAnnotatedClass(HistoricalPrice.class).
				                 buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			HistoricalPrice tempHP = new HistoricalPrice(val, d, id);
			
			session.save(tempHP);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}		
		
		
	}

}