package products;

import main.Products;

public  class Computers extends Products implements Comparable<Computers> {

	public enum ComputerModel implements Saleable {
		LENOVO, HP, DELL, ASUS
	};

	protected ComputerModel computers;
	protected int ram;
	protected int hardDisk;
	protected String processor;
	protected String operationSystem;
	protected int year;

	public Computers(String name, double price, int number,
			ComputerModel computers, int ram, int hardDisk, String processor,
			String operationSystem, int year) {
		super(name, price, number, Categories.IT,Product.COMPUTER);
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
	public int compareTo(Computers arg0) {
		// TODO Auto-generated method stub
		return 0;
	}


}
