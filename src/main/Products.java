package main;

import main.Products.Product;


public abstract class Products {
	
	public interface Saleable{};

	public enum Categories{IT,KITCHEN,MOBILES};
	public enum Product{COMPUTER,LAPTOP,FRIDGE,OVEN,SMARTPHONE,TELEVISION};
	
	//collection for rates HashMap<User,int stars>
	
	protected String name;
	protected double price;
	protected int number;
	protected Categories categories;
	protected Product product;
	
	public Products(String name, double price, int number,Categories categories,Product product) {
		this.name = name;
		this.price = price;
		this.number = number;
		this.categories = categories;
		this.product = product;
	}

	public Categories getCategory() {
		return this.categories;
	}
	public Product getProduct() {
		return this.product;
	}
	public abstract Saleable getSaleable();

	@Override
	public String toString() {
		return this.name+"---" +this.price+"----"+this.number;
	}
	
	
	
	
	
}
