package products;

import main.Products;
import main.Products.Saleable;

public  class SmartPhones extends Products implements Comparable<SmartPhones>{
	
	
	enum PhoneModel implements Saleable {HTC,APPLE,SAMSUNG,LENOVO};

	protected PhoneModel phones;
	
	public SmartPhones(String name, double price, int number,PhoneModel phones) {
		super(name, price, number, Categories.MOBILES);
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
