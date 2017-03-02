package products;

import main.Products;

public class Oven extends Products{

	public Oven(String name, String model, double price, int number) {
		super(name, model, price, number, Categories.KITCHEN);
	}
}
