package main;

import main.Client.Cart.CartProduct;

import com.google.gson.Gson;

public class Order {

	private static Order instance;
	
	private String name;
	private String surname;
	private String address;
	private String telNumber;
	private Client.Cart orderCart;
	
	
	
	private Order(Client c) {
		this.name = c.getName();
		this.surname = c.getSurname();
		this.address = c.getAddress();
		this.telNumber = c.getTelNumber();
		this.orderCart = c.getCart();
		
	}
	
	public static Order getInstance(Client c) {
		if (instance == null) {
			instance = new Order(c);
		}
		return instance;

	}
	
	public static void generateOrder(Client c){
		Order order = new Order(c);		
		 for (CartProduct carProduct : order.orderCart.getHashCart()) {
					 Catalog.getInstance().updateProductAmount(carProduct.getProduct(),carProduct.getAmount());
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(order);
		System.out.println(json);
	}
	
	
	

}
