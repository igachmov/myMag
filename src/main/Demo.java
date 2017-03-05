package main;

import products.Computers;
import products.Computers.ComputerModel;

public class Demo {

	public static void main(String[] args) {
		
		Computers lenovo = new Computers("G520", 1200, 5,ComputerModel.LENOVO, 4, 500, "Intel", "Windows 10", 2010);
		Computers asus = new Computers("123", 800, 10, ComputerModel.ASUS, 2, 1000, "Intel Atom", "Windwos 8.1", 2011);
		
		Catalog emag = new Catalog();
		
		emag.addCatalog(lenovo);
		emag.addCatalog(asus);
		emag.printCatalog();
		
	}
	
}
