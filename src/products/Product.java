package products;

public abstract class Product {
	
	public interface Saleable{};

	public enum Categories{IT,KITCHEN,MOBILES};
	public enum ProductType{COMPUTER,LAPTOP,FRIDGE,OVEN,SMARTPHONE,TELEVISION};
	
	//collection for rates HashMap<User,int stars>
	
	
	private static int idGen =1;
	private final long ID;
	
	protected String name;
	protected double price;
	protected int amount;
	protected Categories categories;
	protected ProductType product;
	
	public Product(String name, double price, int amount,Categories category,ProductType product) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.categories = categories;
		this.product = product;
		idGen++;
		ID=idGen;		
	}

	

	public Categories getCategory() {
		return this.categories;
	}
	public ProductType getProduct() {
		return this.product;
	}
	public abstract Saleable getSaleable();

	@Override
	public String toString() {
		if(this.amount == 0){
			return "Out of stock";
		}
		return this.name+"---" +this.price+"----"+this.amount;
	}
	
	public abstract Product clone();

	public String getName() {
		return name;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	


	
	
	
	
	
	
}
