package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Map.Entry;

import main.Products.Categories;
import main.Products.Product;
import main.Products.Saleable;

public class Client {

	private static int id;
	private String name;
	private String surname;
	private String address;
	private String telNumber;
	private String password;
	private HashSet<Products> cart;

	public Client(String name, String surname, String address,
			String telNumber, String password) {
		cart = new HashSet<>();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.telNumber = telNumber;
		this.password = password;
	}

	public void addToCart(Products prod) {
		cart.add(prod.clone());
	}
	public void removeFromCart(Products prod){
		cart.remove(prod);
	}
	public void changeAmount(Products prod, int incr){
		prod.amount += incr;		
	}
	
	public void search(String name){
		 Catalog.getInstance().searchInCatalog(name);
		 
	}
	
	public void chechOut(){
		for(Products product : cart ){				
			Catalog.getInstance().updateProductAmount(product);
		}		
		cart = new HashSet<>();
		System.out.println("The cart is empty");
	}
	
	

}
