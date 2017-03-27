package com.mymag.mymag.model.products;

import java.util.HashMap;

public class Oven extends Product {

	enum OvenModel implements IBrand {
		GORENJE, BEKO, HANSA, WHIRLPOOL
	}

	public Oven(String name, String description, double price, int amount, OvenModel brand) {
		super(name, description, price, amount, Category.KITCHEN, ProductType.OVEN, brand);
	}

	@Override
	public HashMap<String, String> getSpecs() {
		HashMap<String,String> specs = new HashMap<>();
		specs.put("TODO","ADD SPECIFIC CHARACTERISTICS FOR PRODUCTS!!!");
		return specs;
	}
}
