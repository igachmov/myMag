package com.mymag.mymag.model.products;

public class SmartPhone extends Product {

	enum PhoneModel implements IBrand {
		HTC, APPLE, SAMSUNG, LENOVO
	}

	public SmartPhone(String name, double price, int amount, PhoneModel brand) {
		super(name, price, amount, Category.MOBILES, ProductType.SMARTPHONE, brand);
	}

}
