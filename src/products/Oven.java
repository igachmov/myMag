package products;

import main.Products;
import main.Products.Product;
import main.Products.Saleable;

public class Oven extends Products implements Comparable<Oven>{
	
	enum OvenModel implements Saleable{GORENJE,BEKO,HANSA,WHIRLPOOL};
	
	protected OvenModel models;

	public Oven(String name, double price, int amount,OvenModel models) {
		super(name, price, amount, Categories.KITCHEN,Product.OVEN);
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
}
