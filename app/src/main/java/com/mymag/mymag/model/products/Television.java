package com.mymag.mymag.model.products;

import java.util.HashMap;

public class Television extends Product {

	enum TVModels implements IBrand {
		PANASONIC, LG, SAMSUNG, STARLIGHT
	}

	public Television(String name, String description, double price, int amount, TVModels brand) {
		super(name, description, price, amount, Category.IT, ProductType.TELEVISION, brand);
	}

	@Override
	public HashMap<String, String> getSpecs() {
		HashMap<String,String> specs = new HashMap<>();
		specs.put("TODO","ADD SPECIFIC CHARACTERISTICS FOR PRODUCTS!!!");
		return specs;
	}
}
