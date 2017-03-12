package com.mymag.mymag.model.products;

public class Television extends Product {

	enum TVModels implements IBrand {
		PANASONIC, LG, SAMSUNG, STARLIGHT
	}

	public Television(String name, double price, int amount, TVModels brand) {
		super(name, price, amount, Category.IT, ProductType.TELEVISION, brand);
	}

}
