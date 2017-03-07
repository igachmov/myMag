package main;

import java.util.LinkedList;

import products.Computer;
import products.Computer.ComputerModel;
import products.Laptop;
import products.Laptop.LaptopModel;
import products.Product;
import products.Product.Category;

public class Demo {

	public static void main(String[] args) {
		
		Product lenovo = new Computer("G520", 1200, 5,ComputerModel.LENOVO, 4, 500, "Intel", "Windows 10", 2010);
		Product asus = new Computer("123", 800, 10, ComputerModel.ASUS, 2, 1000, "Intel Atom", "Windwos 8.1", 2011);
		Product laplenovo = new Laptop("Y20", 800, 15, LaptopModel.LENOVO, 5, 500, "ADM", "Windows 10", 2012);
		
		Client gosho = new Client("Gosho", "Goshov", "Pernik", "089658566", "vinkela");
		
		Catalog.getInstance().addToCatalog(laplenovo);
		Catalog.getInstance().addToCatalog(asus);
		Catalog.getInstance().addToCatalog(lenovo);
		
		Catalog.getInstance().printCatalog();
		
		System.out.println();
		
	
		gosho.addToCart(asus);
		gosho.addToCart(asus);
		gosho.addToCart(asus);
		gosho.addToCart(asus);
		gosho.addToCart(asus);
		gosho.addToCart(asus);

		gosho.addToCart(asus);
		gosho.addToCart(asus);
		gosho.addToCart(asus);
		gosho.addToCart(asus);
		gosho.addToCart(asus);
		gosho.addToCart(asus);
		gosho.addToCart(lenovo);
		gosho.chechOut();
		
	}
	
}
