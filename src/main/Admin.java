package main;

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
	
	public void addProduct(Products product ){		
		Catalog.getInstance().addCatalog(product);
		
	}
	public void removeProduct(Products product){
		Catalog.getInstance().removeFromCatalog(product);
	}
	
	//da priema poru4ki
	
	
}
