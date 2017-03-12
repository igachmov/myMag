package com.mymag.mymag.model.products;

public class Computer extends Product {

	public enum ComputerModel implements IBrand {
		LENOVO, HP, DELL, ASUS
	}

	private int ram;
	private int hardDisk;
	private String processor;
	private String operatingSystem;
	private int year;

	public Computer(String name, double price, int amount, ComputerModel brand, int ram, int hardDisk, String processor,
			String operationSystem, int year) {
		super(name, price, amount, Category.IT, Product.ProductType.COMPUTER, brand);

		this.ram = ram;
		this.hardDisk = hardDisk;
		this.processor = processor;
		this.operatingSystem = operationSystem;
		this.year = year;

	}

}
