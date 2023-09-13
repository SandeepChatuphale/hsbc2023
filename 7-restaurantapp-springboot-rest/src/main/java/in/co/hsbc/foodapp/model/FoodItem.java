package in.co.hsbc.foodapp.model;

public class FoodItem {

	private int id;
	private String item;
	private double price;
	
	public FoodItem(int id, String item, double price) {
		super();
		this.id = id;
		this.item = item;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "FoodItem [id=" + id + ", item=" + item + ", price=" + price + "]";
	}
	
	
	
	
	
}
