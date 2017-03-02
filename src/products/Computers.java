package products;

import main.Products;

public class Computers extends Products {

	public Computers(String name, String model, double price, int number) {
		super(name, model, price, number,Categories.IT);
	}

}
