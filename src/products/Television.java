package products;

public class Television extends Product{
	
	enum TVModels implements IBrand{PANASONIC,LG,SAMSUNG,STARLIGHT};
	

	public Television(String name, double price, int amount,TVModels brand) {
		super(name, price, amount, Categories.IT,ProductType.TELEVISION, brand);
	}


	@Override
	public Product clone() {
		//TODO - If not proper abstract way of implementing adding to cart is found -> add concrete implementation;
		return null;
	}
	
}
