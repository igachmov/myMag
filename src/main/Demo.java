package main;

import products.Computer;
import products.Computer.ComputerModel;
import products.Laptop.LaptopModel;
import products.Laptop;

public class Demo {

	public static void main(String[] args) {
		
		Computer lenovo = new Computer("G520", 1200, 5,ComputerModel.LENOVO, 4, 500, "Intel", "Windows 10", 2010);
		Computer asus = new Computer("123", 800, 10, ComputerModel.ASUS, 2, 1000, "Intel Atom", "Windwos 8.1", 2011);
		Laptop laplenovo = new Laptop("Y20", 800, 15, LaptopModel.LENOVO, 5, 500, "ADM", "Windows 10", 2012);
		
		
		
		
	}
	
}
