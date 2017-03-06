package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.Predicate;

import products.Product;
import products.Product.*;


public abstract class Filter {

	public static ArrayList<Product> sortByName(Collection<Product> products) {
		return sortByComparator(products, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	public static ArrayList<Product> sortByPriceUp(Collection<Product> products) {
		return sortByComparator(products, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				double o1Price = o1.getPrice();
				double o2Price = o2.getPrice();

				if (o1Price > o2Price)
					return 1;
				if (o1Price < o2Price)
					return -1;
				return 0;
			}
		});
	}

	public static ArrayList<Product> sortByPriceDown(Collection<Product> products) {
		return sortByComparator(products, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				double o1Price = o1.getPrice();
				double o2Price = o2.getPrice();

				if (o1Price < o2Price)
					return 1;
				if (o1Price > o2Price)
					return -1;
				return 0;
			}
		});
	}

	public static ArrayList<Product> sortByDate(Collection<Product> products) {
		return sortByComparator(products, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				return o1.getDate().compareTo(o2.getDate());
			}
		});
	}

	private static ArrayList<Product> sortByComparator(Collection<Product> products, Comparator<Product> comp) {

		if (products == null || comp == null)
			throw new IllegalArgumentException();

		ArrayList<Product> sortedProducts = new ArrayList<>();
		sortedProducts.addAll(products);
		sortedProducts.sort(comp);
		return sortedProducts;

	}

	public static ArrayList<Product> filterByCategory(Collection<Product> products, final Category cat) {
		ArrayList<Product> filteredProducts = new ArrayList<>();
		filteredProducts.addAll(products);
		
		filteredProducts.removeIf(new Predicate<Product>() {

			@Override
			public boolean test(Product p) {
				return p.getCategory() != cat;
			}

		});
		
		return filteredProducts;

	}
	public static ArrayList<Product> filterByType(Collection<Product> products, final ProductType type) {
		ArrayList<Product> filteredProducts = new ArrayList<>();
		filteredProducts.addAll(products);
		
		filteredProducts.removeIf(new Predicate<Product>() {

			@Override
			public boolean test(Product p) {
				return p.getProductType() != type;
			}

		});
		
		return filteredProducts;

	}
	public static ArrayList<Product> filterByBrand(Collection<Product> products, final IBrand brand) {
		ArrayList<Product> filteredProducts = new ArrayList<>();
		filteredProducts.addAll(products);
		
		filteredProducts.removeIf(new Predicate<Product>() {

			@Override
			public boolean test(Product p) {
				return p.getBrand() != brand;
			}

		});
		
		return filteredProducts;

	}

}
