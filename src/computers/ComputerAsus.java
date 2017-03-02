package computers;

import products.Computers;

public class ComputerAsus extends Computers {

	private int ram;
	private int hardDisk;
	private String porcessor;
	private String operationSystem;
	private int year;
	
	
	
	public ComputerAsus(String name, double price, int number) {
		super(name, price, number,ComputerModel.ASUS);
		
	}

}
