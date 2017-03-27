package com.mymag.mymag.model.products;

import java.util.HashMap;

public class SmartPhone extends Product {

	enum PhoneModel implements IBrand {
		HTC, APPLE, SAMSUNG, LENOVO
	}

	public SmartPhone(String name, String description, double price, int amount, PhoneModel brand) {
		super(name, description, price, amount, Category.MOBILES, ProductType.SMARTPHONE, brand);
	}

	@Override
	public HashMap<String, String> getSpecs() {
		HashMap<String,String> specs = new HashMap<>();
		specs.put("TODO","ADD SPECIFIC CHARACTERISTICS FOR PRODUCTS!!!");
		return specs;
	}
}
