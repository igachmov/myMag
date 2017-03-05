package products;

import main.Products;
import main.Products.Product;
import main.Products.Saleable;

public abstract class Television extends Products implements Saleable{
	
	enum TVModels implements Saleable{PANASONIC,LG,SAMSUNG,STARLIGHT};
	
	protected TVModels televisions;

	public Television(String name, double price, int amount,TVModels televisions) {
		super(name, price, amount, Categories.IT,Product.TELEVISION);
		this.televisions = televisions;
	}
}
