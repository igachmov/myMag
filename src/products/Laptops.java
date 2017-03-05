package products;

import main.Products;
import main.Products.Product;
import main.Products.Saleable;

public class Laptops extends Products implements Comparable<Laptops> {

	protected enum LaptopModel implements Saleable {
		LENOVO, HP, DELL, ASUS
	};

	protected LaptopModel laptops;
	protected int ram;
	protected int hardDisk;
	protected String processor;
	protected String operationSystem;
	protected int year;

	public Laptops(String name, double price, int number, LaptopModel laptops,
			int ram, int hardDisk, String processor, String operationSystem,
			int year) {
		super(name, price, number, Categories.IT, Product.LAPTOP);
		this.laptops = laptops;
	}

	@Override
	public int compareTo(Laptops arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Saleable getSaleable() {
		// TODO Auto-generated method stub
		return null;
	}

}
