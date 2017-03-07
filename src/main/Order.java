package main;

import com.google.gson.Gson;

public class Order {

	private static Order instance;
	
	private String name;
	private String surname;
	private String address;
	private String telNumber;
	
	
	
	public Order(Client c) {
		this.name = c.getName();
		this.surname = c.getSurname();
		this.address = c.getAddress();
		this.telNumber = c.getTelNumber();
	}
	
	public static Order getInstance(Client c) {
		if (instance == null) {
			instance = new Order(c);
		}
		return instance;

	}
	
	public void order(Client c){
		Gson gson = new Gson();
		String json = gson.toJson(Order.getInstance(c));
		System.out.println(json);
	}
	
	
	

}
