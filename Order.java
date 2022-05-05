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