package products;

public  class Computer extends Product implements Comparable<Computer> {

	public enum ComputerModel implements Saleable {
		LENOVO, HP, DELL, ASUS
	};

	protected ComputerModel computers;
	protected int ram;
	protected int hardDisk;
	protected String processor;
	protected String operationSystem;
	protected int year;

	public Computer(String name, double price, int amount,
			ComputerModel computers, int ram, int hardDisk, String processor,
			String operationSystem, int year) {
		super(name, price, amount, Categories.IT,Product.ProductType.COMPUTER);
		this.computers = computers;
		this.ram = ram;	
		this.hardDisk = hardDisk;
		this.processor = processor;
		this.operationSystem = operationSystem;
		this.year = year;
	}
	
	@Override
	public ComputerModel getSaleable() {
		return this.computers;
	}

	@Override
	public int compareTo(Computer arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product clone() {
		return new Computer(this.name,this.hardDisk,1,this.computers, this.ram, this.hardDisk, this.processor, this.operationSystem, this.year);
	}


}
