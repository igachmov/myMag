package products;

import main.Products;
import main.Products.Saleable;

public  class Laptops extends Products implements Comparable<Laptops>{
	
	protected enum LaptopModel implements Saleable{LENOVO,HP,DELL,ASUS};

	protected LaptopModel laptops;
	
	public Laptops(String name, double price, int number,LaptopModel laptops) {
		super(name, price, number, Categories.IT);
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
