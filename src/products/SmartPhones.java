package products;

import main.Products;
import main.Products.Saleable;

public abstract class SmartPhones extends Products implements Saleable{
	
	
	enum PhoneModel {HTC,APPLE,SAMSUNG,LENOVO};

	protected PhoneModel phones;
	
	public SmartPhones(String name, double price, int number,PhoneModel phones) {
		super(name, price, number, Categories.MOBILES);
		this.phones = phones;
	}
}
