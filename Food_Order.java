public class Food_Order {
	private Food food;
	private int quantity;
	
	public Food_Order(Food f,int q) {
		food=f;
		quantity=q;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Date f) {
		food=f;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int q) {
		quantity=q;
	}
}