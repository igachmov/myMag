package products;

public  class Computer extends Product {

	public enum ComputerModel implements IBrand {
		LENOVO, HP, DELL, ASUS
	};

	protected int ram;
	protected int hardDisk;
	protected String processor;
	protected String operatingSystem;
	protected int year;

	public Computer(String name, double price, int amount,
			ComputerModel brand, int ram, int hardDisk, String processor,
			String operationSystem, int year) {
		super(name, price, amount, Category.IT,Product.ProductType.COMPUTER, brand);

		this.ram = ram;	
		this.hardDisk = hardDisk;
		this.processor = processor;
		this.operatingSystem = operationSystem;
		this.year = year;
		
	}
	


	@Override
	public Product clone() {
//		return new Computer(this.name, this.hardDisk, 1, this.computers, this.ram, this.hardDisk, this.processor, this.operationSystem, this.year);
		//TODO - If not proper abstract way of implementing adding to cart is found -> add concrete implementation;
		return null;
	}

	


}
