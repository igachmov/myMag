package products;

public class Laptop extends Product {

	public enum LaptopModel implements IBrand {
		LENOVO, HP, DELL, ASUS
	};

	protected int ram;
	protected int hardDisk;
	protected String processor;
	protected String operationSystem;
	protected int year;

	public Laptop(String name, double price, int amount, LaptopModel brand,
			int ram, int hardDisk, String processor, String operationSystem,
			int year) {
		
		super(name, price, amount, Categories.IT, ProductType.LAPTOP, brand);

		this.ram = ram;	
		this.hardDisk = hardDisk;
		this.processor = processor;
		this.operationSystem = operationSystem;
		this.year = year;
	}

	@Override
	public Product clone() {
		//TODO - If not proper abstract way of implementing adding to cart is found -> add concrete implementation;
		return null;
	}

}
