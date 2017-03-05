package main;

public abstract class Products {
	
	public interface Saleable{};

	protected enum Categories{IT,KITCHEN,MOBILES};
	
	
	protected String name;
	protected double price;
	protected int number;
	protected Categories categories;
	public Products(String name, double price, int number,Categories categories) {
		this.name = name;
		this.price = price;
		this.number = number;
		this.categories = categories;
	}
	
	
	
}
