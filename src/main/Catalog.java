package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeSet;

import products.Product;
import products.Product.Categories;
import products.Product.ProductType;
import products.Product.Saleable;

public class Catalog {
	private HashMap<Categories, HashMap<ProductType, HashMap<Saleable, TreeSet<Product>>>> catalog;

	private static Catalog instance;

	private Catalog() {
		catalog = new HashMap<>();
		catalog.put(Categories.IT, new HashMap<ProductType, HashMap<Saleable, TreeSet<Product>>>());
		catalog.put(Categories.KITCHEN, new HashMap<ProductType, HashMap<Saleable, TreeSet<Product>>>());
		catalog.put(Categories.MOBILES, new HashMap<ProductType, HashMap<Saleable, TreeSet<Product>>>());
	}

	public static Catalog getInstance() {
		if (instance == null) {
			instance = new Catalog();
		}
		return instance;

	}

	public void searchInCatalog(String name) {
		ArrayList<Product> product = new ArrayList<>();
		for (Entry<Categories, HashMap<ProductType, HashMap<Saleable, TreeSet<Product>>>> e : catalog.entrySet()) {

			for (Entry<ProductType, HashMap<Saleable, TreeSet<Product>>> e1 : e.getValue().entrySet()) {

				for (Entry<Saleable, TreeSet<Product>> e2 : e1.getValue().entrySet()) {

					for (Product wo : e2.getValue()) {
						if (wo.getName().contains(name)) {
							product.add(wo);
						}
					}
				}
			}

			System.out.println(product);

		}

	}

	public void removeFromCatalog(Product prod) {
		catalog.get(prod.getCategory()).get(prod.getProduct()).get(prod.getSaleable()).remove(prod);

	}

	public void addCatalog(Product pro) {
		Categories cat = pro.getCategory();
		Saleable saleable = pro.getSaleable();
		ProductType prod = pro.getProduct();
		if (!catalog.containsKey(cat)) {
			catalog.put(cat, new HashMap<ProductType, HashMap<Saleable, TreeSet<Product>>>());
		}
		if (!catalog.get(cat).containsKey(prod)) {
			catalog.get(cat).put(prod, new HashMap<Saleable, TreeSet<Product>>());
		}
		if (!catalog.get(cat).get(prod).containsKey(saleable)) {
			catalog.get(cat).get(prod).put(saleable, new TreeSet<Product>());
		}
		catalog.get(cat).get(prod).get(saleable).add(pro);
	}

	public void printCatalog() {
		for (Entry<Categories, HashMap<ProductType, HashMap<Saleable, TreeSet<Product>>>> e : catalog.entrySet()) {
			System.out.println("------------" + e.getKey() + "------------");
			for (Entry<ProductType, HashMap<Saleable, TreeSet<Product>>> e1 : e.getValue().entrySet()) {
				System.out.println("     *****" + e1.getKey() + "*****");
				for (Entry<Saleable, TreeSet<Product>> e2 : e1.getValue().entrySet()) {
					System.out.println("         ========" + e2.getKey() + "========");
					for (Product wo : e2.getValue()) {
						System.out.println("                ########" + wo + "########");
					}
				}
			}
		}
	}

	public void updateProductAmount(Product p) {
		for (Entry<Categories, HashMap<ProductType, HashMap<Saleable, TreeSet<Product>>>> e : catalog.entrySet()) {
			for (Entry<ProductType, HashMap<Saleable, TreeSet<Product>>> e1 : e.getValue().entrySet()) {
				for (Entry<Saleable, TreeSet<Product>> e2 : e1.getValue().entrySet()) {
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
