package com.mymag.mymag.model.products;

public class Laptop extends Product {

	public enum LaptopModel implements IBrand {
		LENOVO, HP, DELL, ASUS
	}

	private int ram;
	private int hardDisk;
	private String processor;
	private String operationSystem;
	private int year;

	public Laptop(String name, double price, int amount, LaptopModel brand, int ram, int hardDisk, String processor,
			String operationSystem, int year) {

		super(name, price, amount, Category.IT, ProductType.LAPTOP, brand);

		this.ram = ram;
		this.hardDisk = hardDisk;
		this.processor = processor;
		this.operationSystem = operationSystem;
		this.year = year;
	}

}
