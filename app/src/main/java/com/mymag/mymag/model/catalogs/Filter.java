package com.mymag.mymag.model.catalogs;

import android.support.annotation.NonNull;
import android.util.Log;

import com.mymag.mymag.model.products.Product;
import com.mymag.mymag.model.products.Product.Category;
import com.mymag.mymag.model.products.Product.IBrand;
import com.mymag.mymag.model.products.Product.ProductType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Provides sorting and filtering logic for the Catalog.
 * Class is abstract and all methods are <i>static</i> & meant to be used in a manner similar to java.lang.Math.
 * Most methods take a Collection of products and a criteria,
 * by which to process is and then return an ArrayList of the appropriate Products from the initial collection.
 */
public abstract class Filter {

    /**
     * Creates an ArrayList of the passed collection of Products, sorted in alphabetical order.
     * <b>!note that the method returns a new Collection!</b>
     *
     * @param products - Collection of products, which to sort.
     * @return ArrayList<Product> sorted alphabetically by name
     */
    public static ArrayList<Product> sortedByName(Collection<Product> products) {
        return sortByComparator(products, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    /**
     * Creates an ArrayList of the passed collection of Products, sorted in ascending order of price.
     * <b>!note that the method returns a <u>new</u> Collection!</b>
     *
     * @param products - Collection of products, which to sort.
     * @return ArrayList<Product> sorted in ascending order of price
     */
    public static ArrayList<Product> sortedByPriceUp(Collection<Product> products) {
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

    /**
     * Creates an ArrayList of the passed collection of Products, sorted in descending order of price.
     * <b>!note that the method returns a <u>new</u> Collection!</b>
     *
     * @param products - Collection of products, which to sort.
     * @return ArrayList<Product> sorted in descending order of price
     */
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

    /**
     * Creates an ArrayList of the passed collection of Products, sorted by when they were added to the store.
     * <b>!note that the method returns a <u>new</u> Collection!</b>
     *
     * @param products - Collection of products, which to sort.
     * @return ArrayList<Product> sorted date posted
     */
    public static ArrayList<Product> sortByDate(Collection<Product> products) {
        return sortByComparator(products, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                return o1.getDateAdded().compareTo(o2.getDateAdded());
            }
        });
    }


    private static ArrayList<Product> sortByComparator(Collection<Product> products, Comparator<Product> comp) {

        if (products == null || comp == null)
            throw new IllegalArgumentException();

        ArrayList<Product> sortedProducts = new ArrayList<>();
        sortedProducts.addAll(products);
        Collections.sort(sortedProducts, comp);
        return sortedProducts;

    }


    /**
     * Creates an ArrayList containing all Products from the passed collection, that fit the passed Category.
     * <b>!note that the method returns a <u>new</u> Collection!</b>
     *
     * @param products - Collection of Products, which to filter.
     * @param cat      - (e) Product.Category by which to filter.
     * @return new ArrayList<Product> containing all items that fit category passed.
     */
    public static ArrayList<Product> filterByCategory(Collection<Product> products, final Category cat) {
        ArrayList<Product> filteredProducts = new ArrayList<>();

        for (Iterator<Product> itr = products.iterator(); itr.hasNext(); ) {
            Product p = itr.next();
            if (p.getCategory() == cat && !filteredProducts.contains(p))
                filteredProducts.add(p);
        }

        return filteredProducts;

    }

    /**
     * Creates an ArrayList containing all Products from the passed collection, that fit the passed ProductType.
     * <b>!note that the method returns a <u>new</u> Collection!</b>
     *
     * @param products - Collection of Products, which to filter.
     * @param type     - (e) Product.ProductType by which to filter.
     * @return new ArrayList<Product> containing all items that fit category passed.
     */
    public static ArrayList<Product> filterByType(Collection<Product> products, final ProductType type) {
        ArrayList<Product> filteredProducts = new ArrayList<>();

        for (Iterator<Product> itr = products.iterator(); itr.hasNext(); ) {
            Product p = itr.next();
            if (p.getProductType() == type && !filteredProducts.contains(p))
                filteredProducts.add(p);
        }
        return filteredProducts;

    }

    /**
     * Creates an ArrayList containing all Products from the passed collection, that fit the passed IBrand.
     * <b>!note that the method returns a <u>new</u> Collection!</b>
     *
     * @param products - Collection of Products, which to filter.
     * @param brand    - (e) Product.IBrand by which to filter.
     * @return new ArrayList<Product> containing all items that fit category passed.
     */
    public static ArrayList<Product> filterByBrand(Collection<Product> products, final IBrand brand) {
        ArrayList<Product> filteredProducts = new ArrayList<>();

        for (Iterator<Product> itr = products.iterator(); itr.hasNext(); ) {
            Product p = itr.next();
            if (p.getBrand() == brand && !filteredProducts.contains(p))
                filteredProducts.add(p);
        }

        return filteredProducts;

    }


    /**
     * Creates an ArrayList containing all Products from the passed collection, where Product.name starts with the name String passed.
     * <b>!note that the method returns a <u>new</u> Collection!</b>
     *
     * @param products - Collection of Products, which to filter.
     * @param name     - Name String by which to filter.
     * @return new ArrayList<Product> containing all items that start with name String passed.
     */
    public static ArrayList<Product> filterByName(@NonNull Collection<Product> products, @NonNull String name) {
        if (products == null || name == null)
            return null;

        name = name.trim().toLowerCase();

        ArrayList<Product> filteredProducts = new ArrayList<>();

        for (Product p : products) {
            if (p == null)
                continue;
            if (p.getName().trim().toLowerCase().startsWith(name) || p.getName().trim().toLowerCase().contains(name))
                filteredProducts.add(p);
        }

        return filteredProducts;
    }

}
