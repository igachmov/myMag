package products;

import main.Products;
public abstract class Fridge extends Products{
	
	enum FridgeModel{WHIRLPOOL,PHILIPS,BEKO,INDESIT};

	protected FridgeModel fridges;
	
	public Fridge(String name, double price, int number,FridgeModel fridges) {
		super(name, price, number, Categories.KITCHEN);
		this.fridges = fridges;
	}
}
