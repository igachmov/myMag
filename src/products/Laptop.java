package products;

public class Laptop extends Product implements Comparable<Laptop> {

	public enum LaptopModel implements Saleable {
		LENOVO, HP, DELL, ASUS
	};

	protected LaptopModel laptops;
	protected int ram;
	protected int hardDisk;
	protected String processor;
	protected String operationSystem;
	protected int year;

	public Laptop(String name, double price, int amount, LaptopModel laptops,
			int ram, int hardDisk, String processor, String operationSystem,
			int year) {
		super(name, price, amount, Categories.IT, ProductType.LAPTOP);
		this.laptops = laptops;
		this.ram = ram;	
		this.hardDisk = hardDisk;
		this.processor = processor;
		this.operationSystem = operationSystem;
		this.year = year;
	}

	@Override
	public int compareTo(Laptop arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Saleable getSaleable() {
		return this.laptops;
	}

	@Override
	public Product clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
