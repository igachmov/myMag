package products;

import main.Products;

public abstract class Laptops extends Products{
	
	protected enum LaptopModel{LENOVO,HP,DELL,ASUS};

	protected LaptopModel laptops;
	
	public Laptops(String name, double price, int number,LaptopModel laptops) {
		super(name, price, number, Categories.IT);
		this.laptops = laptops;
	}

}
