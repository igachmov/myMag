package products;

import main.Products;
import main.Products.Product;
import main.Products.Saleable;

public  class SmartPhones extends Products implements Comparable<SmartPhones>{
	
	
	enum PhoneModel implements Saleable {HTC,APPLE,SAMSUNG,LENOVO};

	protected PhoneModel phones;
	
	public SmartPhones(String name, double price, int amount,PhoneModel phones) {
		super(name, price, amount, Categories.MOBILES,Product.SMARTPHONE);
		this.phones = phones;
	}

	@Override
	public int compareTo(SmartPhones arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Saleable getSaleable() {
		// TODO Auto-generated method stub
		return null;
	}
}
