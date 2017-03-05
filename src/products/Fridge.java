package products;

import main.Products;
public class Fridge extends Products implements Comparable<Fridge>{
	
	enum FridgeModel implements Saleable {WHIRLPOOL,PHILIPS,BEKO,INDESIT};

	protected FridgeModel fridges;
	
	public Fridge(String name, double price, int number,FridgeModel fridges) {
		super(name, price, number, Categories.KITCHEN);
		this.fridges = fridges;
	}

	@Override
	public int compareTo(Fridge arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Saleable getSaleable() {
		// TODO Auto-generated method stub
		return null;
	}
}
