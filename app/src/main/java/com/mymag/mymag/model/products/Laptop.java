package com.mymag.mymag.model.products;

import java.util.HashMap;

public class Laptop extends Product {

	public enum LaptopModel implements IBrand {
		LENOVO, HP, DELL, ASUS
	}

	private int ram;
	private int hardDisk;
	private String processor;
	private String operatingSystem;
	private int year;

	public Laptop(String name, String description, double price, int amount, LaptopModel brand, int ram, int hardDisk, String processor,
			String operationSystem, int year,int imageID) {

		super(name, description, price, amount, Category.IT, ProductType.LAPTOP, brand,imageID);

		this.ram = ram;
		this.hardDisk = hardDisk;
		this.processor = processor;
		this.operatingSystem = operationSystem;
		this.year = year;
	}


	@Override
	public HashMap<String, String> getSpecs() {
		HashMap<String,String> specs = new HashMap<>();

		specs.put("RAM", String.valueOf(ram));
		specs.put("HDD", String.valueOf(hardDisk));
		specs.put("CPU", processor);
		specs.put("OS", operatingSystem);
		specs.put("year", String.valueOf(year));

		return specs;
	}

}
