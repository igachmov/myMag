package com.mymag.mymag.model.products;

import java.util.HashMap;

public class Fridge extends Product {

	public enum FridgeModel implements IBrand {
		WHIRLPOOL, PHILIPS, BEKO, INDESIT
	}


	public Fridge(String name, String description, double price, int amount, IBrand brand, int imageID) {
		super(name, description, price, amount, Category.KITCHEN, ProductType.FRIDGE, brand, imageID);
	}

	@Override
	public HashMap<String, String> getSpecs() {
		HashMap<String,String> specs = new HashMap<>();
		specs.put("TODO","ADD SPECIFIC CHARACTERISTICS FOR PRODUCTS!!!");
		return specs;
	}

}
