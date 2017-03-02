package products;

import main.Products;

public class SmartPhones extends Products{

	public SmartPhones(String name, String model, double price, int number) {
		super(name, model, price, number, Categories.MOBILES);
	}
}
