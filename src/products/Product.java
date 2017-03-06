package products;

import java.time.LocalDate;

public abstract class Product implements Comparable<Product>{
	
	public interface IBrand{};

	public enum Category{IT,KITCHEN,MOBILES};
	public enum ProductType{COMPUTER,LAPTOP,FRIDGE,OVEN,SMARTPHONE,TELEVISION};
	
	//collection for rates HashMap<User,int stars>
	
	
	private static int idGen =1;
	
	private final int ID;
	private final LocalDate dateAdded;

	private String name;
	
	private double price;
	private int amount;
	
	private Category category;
	private ProductType productType;
	private IBrand brand;
	
	
	public Product(String name, double price, int amount,Category category,ProductType product, IBrand brand) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.category = category;
		this.productType = product;
		this.brand = brand;
		
		dateAdded = LocalDate.now();
		
		idGen++;
		ID=idGen;		
	}

	
	public abstract Product clone();

	
	public Category getCategory() {
		return this.category;
	}
	public ProductType getProductType() {
		return this.productType;
	}
	public IBrand getBrand(){
		return this.brand;
	}
	public String getName() {
		return this.name;
	}
	public int getAmount() {
		return this.amount;
	}
	public LocalDate getDate() {
		return dateAdded;
	}
	public double getPrice() {
		return this.price;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	@Override
	public int compareTo(Product o) {
		if(this == o)
			return 0;
		return this.ID - o.ID;
	}

	@Override
	public String toString() {
		if(this.amount == 0){
			return "Out of stock";
		}
		return this.name+"---" +this.price+"----"+this.amount;
	}


	
	
	
	
	
	
	
}
