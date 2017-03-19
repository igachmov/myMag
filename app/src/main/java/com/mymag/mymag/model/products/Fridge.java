package com.mymag.mymag.model.products;

import java.util.HashMap;

public class Fridge extends Product {

	enum FridgeModel implements IBrand {
		WHIRLPOOL, PHILIPS, BEKO, INDESIT
	}


	public Fridge(String name, String description, double price, int amount, FridgeModel brand) {
		super(name, description, price, amount, Category.KITCHEN, ProductType.FRIDGE, brand);
	}


	@Override
	public HashMap<String, String> getSpecs() {
		HashMap<String,String> specs = new HashMap<>();
		specs.put("TODO","ADD SPECIFIC CHARACTERISTICS FOR PRODUCTS!!!");
		return specs;
	}

}
