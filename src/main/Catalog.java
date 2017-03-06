package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeSet;

import products.Product;
import products.Product.Categories;
import products.Product.ProductType;
import products.Product.IBrand;

public class Catalog {
	
	private HashMap<Categories, HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>> catalog;

	private static Catalog instance;

	private Catalog() {
		catalog = new HashMap<>();
		catalog.put(Categories.IT, new HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>());
		catalog.put(Categories.KITCHEN, new HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>());
		catalog.put(Categories.MOBILES, new HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>());
	}

	public static Catalog getInstance() {
		if (instance == null) {
			instance = new Catalog();
		}
		return instance;

	}

	public void searchInCatalog(String name) {
		ArrayList<Product> matchingItems = new ArrayList<>();
		
		for (Entry<Categories, HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>> e : catalog.entrySet()) {

			for (Entry<ProductType, HashMap<IBrand, TreeSet<Product>>> e1 : e.getValue().entrySet()) {

				for (Entry<IBrand, TreeSet<Product>> e2 : e1.getValue().entrySet()) {

					for (Product wo : e2.getValue()) {
						if (wo.getName().contains(name)) {
							matchingItems.add(wo);
						}
					}
				}
			}

		for (Iterator itr = catalog.entrySet().iterator(); itr.hasNext();) {
			
			Product product = (Product) itr.next();
			
		}
		
			System.out.println(matchingItems);

		}

	}

	public void removeFromCatalog(Product prod) {
		catalog.get(prod.getCategory()).get(prod.getProductType()).get(prod.getBrand()).remove(prod);

	}

	public void addCatalog(Product pro) {
		Categories cat = pro.getCategory();
		IBrand saleable = pro.getBrand();
		ProductType prod = pro.getProductType();
		if (!catalog.containsKey(cat)) {
			catalog.put(cat, new HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>());
		}
		if (!catalog.get(cat).containsKey(prod)) {
			catalog.get(cat).put(prod, new HashMap<IBrand, TreeSet<Product>>());
		}
		if (!catalog.get(cat).get(prod).containsKey(saleable)) {
			catalog.get(cat).get(prod).put(saleable, new TreeSet<Product>());
		}
		catalog.get(cat).get(prod).get(saleable).add(pro);
	}

	public void printCatalog() {
		for (Entry<Categories, HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>> e : catalog.entrySet()) {
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
		for (Entry<Categories, HashMap<ProductType, HashMap<IBrand, TreeSet<Product>>>> e : catalog.entrySet()) {
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
