package products;

import main.Products;
import main.Products.Saleable;

public abstract class Laptops extends Products implements Saleable{
	
	protected enum LaptopModel{LENOVO,HP,DELL,ASUS};

	protected LaptopModel laptops;
	
	public Laptops(String name, double price, int number,LaptopModel laptops) {
		super(name, price, number, Categories.IT);
		this.laptops = laptops;
	}

}
