package main;

public abstract class Products {

	protected enum Categories{IT,KITCHEN,MOBILES};
	
	
	protected String name;
	protected String model;
	protected double price;
	protected int number;
	protected Categories categories;
	public Products(String name, String model, double price, int number,Categories categories) {
		this.name = name;
		this.model = model;
		this.price = price;
		this.number = number;
		this.categories = categories;
	}
	
	
	
}
