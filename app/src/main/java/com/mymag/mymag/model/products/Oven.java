package com.mymag.mymag.model.products;

public class Oven extends Product {

	enum OvenModel implements IBrand {
		GORENJE, BEKO, HANSA, WHIRLPOOL
	}

	public Oven(String name, double price, int amount, OvenModel brand) {
		super(name, price, amount, Category.KITCHEN, ProductType.OVEN, brand);
	}

}
