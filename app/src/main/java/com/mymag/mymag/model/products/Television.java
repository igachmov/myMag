package com.mymag.mymag.model.products;

import java.util.HashMap;

public class Television extends Product {

	public enum TVModels implements IBrand {
		PANASONIC, LG, SAMSUNG, STARLIGHT
	}

	public Television(String name, String description, double price, int amount, TVModels brand,int imageID) {
		super(name, description, price, amount, Category.IT, ProductType.TELEVISION, brand,imageID);
	}

	@Override
	public HashMap<String, String> getSpecs() {
		HashMap<String,String> specs = new HashMap<>();
		specs.put("TODO","ADD SPECIFIC CHARACTERISTICS FOR PRODUCTS!!!");
		return specs;
	}
}
