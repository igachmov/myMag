package products;

public class Oven extends Product implements Comparable<Oven>{
	
	enum OvenModel implements Saleable{GORENJE,BEKO,HANSA,WHIRLPOOL};
	
	protected OvenModel models;

	public Oven(String name, double price, int amount,OvenModel models) {
		super(name, price, amount, Categories.KITCHEN,ProductType.OVEN);
		this.models = models;
	}

	@Override
	public int compareTo(Oven arg0) {
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
