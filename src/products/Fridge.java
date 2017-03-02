package products;

import main.Products;
public class Fridge extends Products{

	public Fridge(String name, String model, double price, int number) {
		super(name, model, price, number, Categories.KITCHEN);
	}
}
