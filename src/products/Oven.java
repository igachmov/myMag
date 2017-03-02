package products;

import main.Products;

public abstract class Oven extends Products{
	
	enum OvenModel{GORENJE,BEKO,HANSA,WHIRLPOOL};
	
	protected OvenModel models;

	public Oven(String name, double price, int number,OvenModel models) {
		super(name, price, number, Categories.KITCHEN);
		this.models = models;
	}
}
