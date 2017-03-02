package products;

import main.Products;

public abstract class Computers extends Products {

	protected enum ComputerModel{LENOVO,HP,DELL,ASUS};
	
	protected ComputerModel computers;
	
	public Computers(String name, double price, int number,ComputerModel computers) {
		super(name, price, number,Categories.IT);
		
		this.computers = computers;
	}

}
