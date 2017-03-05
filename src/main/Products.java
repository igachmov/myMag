package main;


public abstract class Products {
	
	public interface Saleable{};

	protected enum Categories{IT,KITCHEN,MOBILES};
	
	//collection for rates HashMap<User,int stars>
	
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

	public Categories getCategory() {
		return this.categories;
	}

	public abstract Saleable getSaleable();

	@Override
	public String toString() {
		return this.name+"---" +this.price+"----"+this.number;
	}
	
	
	
	
	
}
