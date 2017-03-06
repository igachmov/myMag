package main;

import java.util.HashSet;

import products.Product;

public class Client {

	private static int idGen =1_000_000_000;

	private final int ID;
	private String name;
	private String surname;
	private String address;
	private String telNumber;
	private String password;
	private HashSet<Product> cart;

	public Client(String name, String surname, String address, String telNumber, String password) {

		// TODO validate parameters.

		this.name = name;
		this.surname = surname;
		this.address = address;
		this.telNumber = telNumber;
		this.password = password;

		cart = new HashSet<>();

		idGen++;
		ID = idGen;

	}

	public void addToCart(Product prod) {
		cart.add(prod.clone());
	}

	public void removeFromCart(Product prod) {
		cart.remove(prod);
	}

	public void changeAmount(Product prod, int incr) {
//		prod.amount += incr;
	}

	public void search(String name) {
		Catalog.getInstance().searchInCatalog(name);

	}

	public void chechOut() {
		for (Product product : cart) {
			Catalog.getInstance().updateProductAmount(product);
		}
		cart = new HashSet<>();
		System.out.println("The cart is empty");
	}

}
