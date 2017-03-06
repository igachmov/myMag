package products;

import products.Product.Saleable;

public abstract class Television extends Product implements Saleable{
	
	enum TVModels implements Saleable{PANASONIC,LG,SAMSUNG,STARLIGHT};
	
	protected TVModels televisions;

	public Television(String name, double price, int amount,TVModels televisions) {
		super(name, price, amount, Categories.IT,ProductType.TELEVISION);
		this.televisions = televisions;
	}
}
