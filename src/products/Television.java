package products;

import main.Products;

public abstract class Television extends Products{
	
	enum TVModels{PANASONIC,LG,SAMSUNG,STARLIGHT};
	
	protected TVModels televisions;

	public Television(String name, double price, int number,TVModels televisions) {
		super(name, price, number, Categories.IT);
		this.televisions = televisions;
	}
}
