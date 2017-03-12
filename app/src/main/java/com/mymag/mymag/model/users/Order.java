package com.mymag.mymag.model.users;


import com.google.gson.Gson;
import com.mymag.mymag.model.catalogs.Catalog;

public class Order {

	private static Order instance;
	
	private String name;
	private String surname;
	private String address;
	private String telNumber;
	private User.Cart orderCart;
	
	
	
	private Order(User u) {
		this.name = u.getName();
		this.address = u.getAddress();
		this.telNumber = u.getTelNumber();
		this.orderCart = u.getCart();
		
	}
	
	public static Order getInstance(User u) {
		if (instance == null) {
			instance = new Order(u);
		}
		return instance;

	}
	
	public static void generateOrder(User c){
		Order order = new Order(c);		
		 for (User.Cart.CartProduct carProduct : order.orderCart.getProductsInCart()) {
					 Catalog.getInstance().updateProductAmount(carProduct.getProduct(),carProduct.getAmount());
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(order);
		System.out.println(json);
	}
	
	
	

}
