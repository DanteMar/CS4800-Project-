
public class Customer {
	private String first_name;
	private String last_name;
	private int dob;
	private int phone;
	private String street;
	private String address_number;
	private int zip_code;
	private String city;
	private String state;
	private double discount = 0;
	
	Customer()
	{
		
	}
	public void newCustomer(String first_name, String last_name, int dob, int phone, String street, String address_number, int zip_code, String city, String state)
	{
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.phone = phone;
		this.street = street;
		this.address_number = address_number;
		this.zip_code = zip_code;
		this.city = city;
		this.state = state;
	}
	public void updateCustomer(String first_name, String last_name, int dob, int phone, String street, String address_number, int zip_code, String city, String state)
	{
		
	}
}
