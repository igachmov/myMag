package products;

public  class SmartPhone extends Product{
	
	
	enum PhoneModel implements IBrand {HTC,APPLE,SAMSUNG,LENOVO};

	
	public SmartPhone(String name, double price, int amount,PhoneModel brand) {
		super(name, price, amount, Categories.MOBILES,ProductType.SMARTPHONE, brand);
	}


	@Override
	public Product clone() {
		//TODO - If not proper abstract way of implementing adding to cart is found -> add concrete implementation;
		return null;
	}
}
