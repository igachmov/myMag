package com.mymag.mymag.model.products;

import java.util.HashMap;

public class SmartPhone extends Product {

	public enum PhoneModel implements IBrand {
		HTC, APPLE, SAMSUNG, LENOVO
	}

	public SmartPhone(String name, String description, double price, int amount, PhoneModel brand,int imageID) {
		super(name, description, price, amount, Category.MOBILES, ProductType.SMARTPHONE, brand,imageID);
	}

	@Override
	public HashMap<String, String> getSpecs() {
		HashMap<String,String> specs = new HashMap<>();
		specs.put("TODO","ADD SPECIFIC CHARACTERISTICS FOR PRODUCTS!!!");
		return specs;
	}
}
