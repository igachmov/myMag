package products;

public  class SmartPhone extends Product implements Comparable<SmartPhone>{
	
	
	enum PhoneModel implements Saleable {HTC,APPLE,SAMSUNG,LENOVO};

	protected PhoneModel phones;
	
	public SmartPhone(String name, double price, int amount,PhoneModel phones) {
		super(name, price, amount, Categories.MOBILES,ProductType.SMARTPHONE);
		this.phones = phones;
	}

	@Override
	public int compareTo(SmartPhone arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Saleable getSaleable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product clone() {
		// TODO Auto-generated method stub
		return null;
	}
}
