package products;

import main.Products;
import main.Products.Saleable;

public abstract class Computers extends Products implements Saleable{

	protected enum ComputerModel {
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
		super(name, price, number, Categories.IT);
		this.computers = computers;
		this.ram = ram;
		this.hardDisk = hardDisk;
		this.processor = processor;
		this.operationSystem = operationSystem;
		this.year = year;
	}

}
