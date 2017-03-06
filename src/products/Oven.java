package products;

public class Oven extends Product{
	
	enum OvenModel implements IBrand{GORENJE,BEKO,HANSA,WHIRLPOOL};
	

	public Oven(String name, double price, int amount,OvenModel brand) {
		super(name, price, amount, Categories.KITCHEN,ProductType.OVEN, brand);
	}

	
	@Override
	public Product clone() {
		//TODO - If not proper abstract way of implementing adding to cart is found -> add concrete implementation;
		return null;
	}
}
