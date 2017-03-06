package main;

import products.Product;

public class Admin {

	private String name;
	private String password;
	private String telNumber;
	private String address;
	private String email;
	
	public Admin(String name, String password, String telNumber, String address) {
		this.name = name;
		this.password = password;
		this.telNumber = telNumber;
		this.address = address;
	}
	
	public void addProduct(Product product ){		
		Catalog.getInstance().addToCatalog(product);
		
	}
	public void removeProduct(Product product){
		Catalog.getInstance().removeFromCatalog(product);
	}
	
	
	
}
