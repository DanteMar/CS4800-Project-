import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

public class Order {
	private Date date;
	private Time time;
	private Customer customer;
	private ArrayList<Food_Order> listOfProducts;
	private double totalPrice;
	private String status;
	
	public Order (Date d, Customer c ) {
		date=d;
		customer=c;
		listOfProducts= new ArrayList<Food_Order>();
		
		
	}
	public void newOrder(Date date, Time time, Customer customer, String status)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			String query = "INSERT INTO `order` (`date`, `time`, `customer`, `status` )";
			
			// execute the query
			connection.createStatement().executeUpdate(query);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void updateOrder(int orderID, Date date, Time time, Customer customer, String status)
	{
		try
		{
			Connection connection = LoginDataAccess.verifyCredentials();
			// create the java statement
			
			//Generate appropriate query
			// all database values will change once database is setup
			connection.createStatement().executeUpdate("UPDATE `order` SET `date` = '" + date + "' WHERE `itemID` = " + orderID);	
			connection.createStatement().executeUpdate("UPDATE `order` SET `time` = '" + time + "' WHERE `itemID` = " + orderID);
			connection.createStatement().executeUpdate("UPDATE `order` SET `customer` = '" + customer + "' WHERE `itemID` = " + orderID);
			connection.createStatement().executeUpdate("UPDATE `order` SET `status` = '" + status + "' WHERE `itemID` = " + orderID);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	public static void deleteOrder(int orderIDInput)
	{
		try
		{
			// all database values will change once database is setup
			Connection connection = LoginDataAccess.verifyCredentials();
			String queryDeleteTransaction = "DELETE FROM order WHERE `orderID`.orderIDInput = "
					+ orderIDInput;
			PreparedStatement delete = connection.prepareStatement(queryDeleteTransaction);
			delete.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date d) {
		date=d;
	}
	public Date getTime() {
		return date;
	}
	public void setTime(Time t) {
		time=t;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer c) {
		customer=c;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double tp) {
		totalPrice=tp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String s) {
		status=s;
	}
	public void addFoodOrder(Food food, int quantity) {
		Food_Order foodOrder = new Food_Order(food,quantity);
		listOfProducts.add(foodOrder);
	}
	public void deleteFoodOrder(Food_Order foodOrder) {
		listOfProducts.remove(food_Order);
	}
}