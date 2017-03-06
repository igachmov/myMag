package products;

public class Fridge extends Product{
	
	enum FridgeModel implements IBrand {WHIRLPOOL,PHILIPS,BEKO,INDESIT};

	protected FridgeModel fridges;
	
	public Fridge(String name, double price, int amount,FridgeModel brand) {
		super(name, price, amount, Categories.KITCHEN,ProductType.FRIDGE, brand);
		this.fridges = fridges;
	}



	@Override
	public Product clone() {
		//TODO - If not proper abstract way of implementing adding to cart is found -> add concrete implementation;
		return null;
	}
}
