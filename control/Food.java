package control;
//JUST A PRACTICE FOOD OBJECT
public class Food {
	public String name;
	public double price;
	public Food(String n, double p) {
		name=n;
		price=p;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
