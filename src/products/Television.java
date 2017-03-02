package products;

import main.Products;

public class Television extends Products{

	public Television(String name, String model, double price, int number) {
		super(name, model, price, number, Categories.IT);
	}
}
