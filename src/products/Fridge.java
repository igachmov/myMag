package products;

public class Fridge extends Product {

	enum FridgeModel implements IBrand {
		WHIRLPOOL, PHILIPS, BEKO, INDESIT
	};

	protected FridgeModel fridges;

	public Fridge(String name, double price, int amount, FridgeModel brand) {
		super(name, price, amount, Category.KITCHEN, ProductType.FRIDGE, brand);
		this.fridges = fridges;
	}

}
