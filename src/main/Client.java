package main;

import java.util.HashSet;

import products.Product;

public class Client {

	private static int idGen = 1_000_000_000;

	private final int ID;
	private String name;
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress() {
		return address;
	}

	public String getTelNumber() {
		return telNumber;
	}

	private String surname;
	private String address;
	private String telNumber;
	private String password;
	private Cart userCart;

	public Client(String name, String surname, String address, String telNumber, String password) {

		this.name = name;
		this.surname = surname;
		this.address = address;
		this.telNumber = telNumber;
		this.password = password;

		userCart = new Cart();

		idGen++;
		ID = idGen;

	}
	
	public void orderProduct(){
		Order.getInstance(this).order(this);
	}

	private class Cart {

		private HashSet<CartProduct> cart;

		private Cart() {
			this.cart = new HashSet<>();
		}

		/**
		 * Adds <i>product</i> to the cart. If it is already present -
		 * increments the amount by 1
		 * 
		 * @param product
		 *            - Product object to be added to the cart.
		 */
		public void addToCart(Product product) {
			if (product.getAmount() < 1) {
				System.out.println("Sorry, that product is currently out of stock.");
				return;
			}

			CartProduct cartProduct = this.get(product);

			if (cartProduct == null) {
				cartProduct = new CartProduct(product, 1);
			} else if (product.getAmount() < cartProduct.amount + 1) {
				System.out.println("Sorry, there isn't enough of that product in stock.");
				return;
			}

			cartProduct.amount++;
		}

		
		
		public void removeFromCart(CartProduct prod) {
			if (prod == null || !cart.contains(prod))
				return;
			cart.remove(prod);
		}

		public void setAmount(CartProduct prod, int amount) {
			if (prod == null || !this.cart.contains(prod))
				return;
			if (amount < 1) {
				System.out.println("Please input a positive number. Thank you!");
				amount = 1;
			}

			// Gets the Product object represented by the 'prod' CartProduct
			Product p = prod.product;
			if (amount > p.getAmount()) {
				System.out.println("Sorry, but there aren't " + amount + " units of " + p.getName() + " in stock. ");
				System.out.println("Amount in cart adjusted to: " + (amount = p.getAmount()));
				return;
			}

			prod.amount = amount;
		}

		public void search(String name) {
			Catalog.getInstance().searchInCatalog(name);
		}

		public void checkOut() {
			//TODO important! revamp!
			// for (CartProduct product : cart) {
			// Catalog.getInstance().updateProductAmount(product);
			// }
			cart = new HashSet<>();
			System.out.println("The cart is empty");
		}

		/**
		 * Retrieves from the cart collection a CartProduct based on a standard
		 * Product instance.
		 * 
		 * @param p
		 *            - Product instance to search for in cart
		 * @return <b><i>null</i></b> if Product p is NOT found. The CartProduct
		 *         corresponding to p otherwise.
		 */
		private CartProduct get(Product p) {
			if (this.cart.isEmpty())
				return null;
			for (CartProduct cartProduct : cart)
				if (cartProduct.equals(p))
					return cartProduct;

			return null;
		}

		/**
		 * @return double - the total cost of ALL products currently in cart.
		 */
		public double getTotalPrice(){
			double sum = 0;

			for (CartProduct cartProduct : cart) {
				double pricePerProduct = cartProduct.product.getPrice();
				int amount = cartProduct.amount;
				sum += pricePerProduct*amount;
			}
			return sum;
		}
		
		/**
		 * Provides an intermediary when adding items to User's cart and when
		 * unloading at check-out.
		 *
		 */
		public class CartProduct implements Comparable<CartProduct> {

			private int amount;
			private final Product product;

			private CartProduct(Product p, int amount) {
				this.amount = amount;
				this.product = p;
			}

			@Override
			public int hashCode() {
				return this.product.hashCode();
			}

			@Override
			public int compareTo(CartProduct o) {
				return this.product.compareTo(o.product);
			}

			@Override
			public boolean equals(Object obj) {
				return this.product.equals(obj);
			}

		}

	}

}
