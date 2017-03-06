package products;

public class Fridge extends Product implements Comparable<Fridge>{
	
	enum FridgeModel implements Saleable {WHIRLPOOL,PHILIPS,BEKO,INDESIT};

	protected FridgeModel fridges;
	
	public Fridge(String name, double price, int amount,FridgeModel fridges) {
		super(name, price, amount, Categories.KITCHEN,ProductType.FRIDGE);
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

	@Override
	public Product clone() {
		// TODO Auto-generated method stub
		return null;
	}
}
