package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeSet;

import products.Product;
import products.Product.Category;
import products.Product.IBrand;
import products.Product.ProductType;

public class Catalog {

	private static Catalog instance;

	private HashMap<Category, HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>> catalog;

	private Catalog() {
		catalog = new HashMap<>();
		catalog.put(Category.IT, new HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>());
		catalog.put(Category.KITCHEN, new HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>());
		catalog.put(Category.MOBILES, new HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>());
	}

	/**
	 * @return Singleton instance of Catalog
	 */
	public static Catalog getInstance() {
		if (instance == null) {
			instance = new Catalog();
		}
		return instance;

	}

	/**
	 * Iterates over the whole catalog collection and prints all items for which
	 * the name starts with String from param. If not matches are found prints
	 * appropriate message to console.
	 * 
	 * @param name
	 *            - Product name to search for.
	 */
	public void searchInCatalog(String name) {
		if (name == null || name.isEmpty())
			return;

		ArrayList<Product> matchingItems = new ArrayList<>();

		for (Entry<Category, HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>> e : catalog.entrySet())
			for (Entry<ProductType, HashMap<IBrand, TreeSet<Product>>> e1 : e.getValue().entrySet())
				for (Entry<IBrand, TreeSet<Product>> e2 : e1.getValue().entrySet())
					for (Product wo : e2.getValue())
						if (wo.getName().startsWith(name))
							matchingItems.add(wo);

		if (matchingItems.isEmpty()) {
			System.out.println("Sorry. No items match search term.");
			return;
		}

		// no lambdas in J1.7 :(
		matchingItems.sort(new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});

		System.out.println(matchingItems);

	}

	/**
	 * Wraps java.util.TreeSet.remove(Object o) for specific use with the
	 * catalog collection.
	 * 
	 * @param prod
	 *            - Product instance, which to find and remove from catalog
	 * @return true if product was present in catalog
	 */
	public boolean removeFromCatalog(Product prod) {
		// TODO DANGEROUS .get(key) returns null if this map contains no mapping
		// for the key => might throw NullPointerExeption!
		return catalog.get(prod.getCategory()).get(prod.getProductType()).get(prod.getBrand()).remove(prod);
	}

	/**
	 * 
	 * @param pro - Product instance which to add to catalog.
	 * @return <b>true</b> if the catalog did NOT contain pro.
	 *         <b>false</b> if element was already present or is null
	 */
	public boolean addToCatalog(Product pro) {

		if (pro == null) 
			return false;

		Category cat = pro.getCategory();
		IBrand brand = pro.getBrand();
		ProductType prodType = pro.getProductType();

		if (!catalog.containsKey(cat)) {
			catalog.put(cat, new HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>());
		}
		if (!catalog.get(cat).containsKey(prodType)) {
			catalog.get(cat).put(prodType, new HashMap<IBrand, TreeSet<Product>>());
		}
		if (!catalog.get(cat).get(prodType).containsKey(brand)) {
			catalog.get(cat).get(prodType).put(brand, new TreeSet<Product>());
		}

		return catalog.get(cat).get(prodType).get(brand).add(pro);
	}

	public void printCatalog() {
		for (Entry<Category, HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>> e : catalog.entrySet()) {
			System.out.println("------------" + e.getKey() + "------------");
			for (Entry<ProductType, HashMap<IBrand, TreeSet<Product>>> e1 : e.getValue().entrySet()) {
				System.out.println("     *****" + e1.getKey() + "*****");
				for (Entry<IBrand, TreeSet<Product>> e2 : e1.getValue().entrySet()) {
					System.out.println("         ========" + e2.getKey() + "========");
					for (Product wo : e2.getValue()) {
						System.out.println("                ########" + wo + "########");
					}
				}
			}
		}
	}

	public void updateProductAmount(Product p) {
		if (p == null)
			return;
		Category cat = p.getCategory();
		ProductType prodType = p.getProductType();
		IBrand brand = p.getBrand();

		for (Entry<Category, HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>> e : catalog.entrySet()) {
			for (Entry<ProductType, HashMap<IBrand, TreeSet<Product>>> e1 : e.getValue().entrySet()) {
				for (Entry<IBrand, TreeSet<Product>> e2 : e1.getValue().entrySet()) {
					for (Product wo : e2.getValue()) {
						if (wo.getName().equals(p.getName())) {
							if (!(wo.getAmount() - p.getAmount() < 0)) {
								wo.setAmount(wo.getAmount() - p.getAmount());
							}
							// TODO check if wo.amount less than amount being
							// ordered (p.amount)
						}
					}
				}
			}
		}
	}
}
