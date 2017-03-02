package products;

import main.Products;

public abstract class SmartPhones extends Products{
	
	
	enum PhoneModel {HTC,APPLE,SAMSUNG,LENOVO};

	protected PhoneModel phones;
	
	public SmartPhones(String name, double price, int number,PhoneModel phones) {
		super(name, price, number, Categories.MOBILES);
		this.phones = phones;
	}
}
