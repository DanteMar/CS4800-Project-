package business;
import objects.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class BusinessLayer {
	private static BusinessLayer instance;
	
	private BusinessLayer() {};
	public static BusinessLayer getInstance() {
		if(instance==null) {
			instance=new BusinessLayer();
		}
		return instance;
	}
	
	public ArrayList<MenuItem> getMenu() throws ClassNotFoundException, SQLException{
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		try {
			Connection connection = LoginDataAccess.verifyCredentials();
			double price=0;
			String name="";
			PreparedStatement stmt = connection.prepareStatement("SELECT foodname, price from menuitem");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) 
            {
                name = rs.getString("foodname");
                price = rs.getDouble("price");
               
                MenuItem item=new MenuItem(name,price);
                menu.add(item);
            }
		}
		catch(SQLException e){
			e.printStackTrace();
			throw e;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return menu;
	}
	public Customer getCustomer(int id) throws  ClassNotFoundException, SQLException{
		Customer c=new Customer();
		try {
			Connection connection = LoginDataAccess.verifyCredentials();
			PreparedStatement stmt = connection.prepareStatement("select * from customer where broncoid = ? ");
			stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) 
            {
            	System.out.println("id: "+rs.getInt("broncoid"));
                c=new Customer(rs.getInt("broncoid"),rs.getString("firstname"),rs.getString("lastname"),rs.getDate("dob"),rs.getInt("phonenum"));
            }
		}
		catch(SQLException e){
			e.printStackTrace();
			throw e;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		Customer temp = new Customer();
		if(c.getBroncoID()==temp.getBroncoID()) {
			return null;
		}
		return c;
	}
}
