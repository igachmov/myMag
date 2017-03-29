package com.mymag.mymag.model.catalogs;


import android.widget.Toast;

import com.mymag.mymag.R;
import com.mymag.mymag.model.products.Laptop;
import com.mymag.mymag.model.products.Product;
import com.mymag.mymag.model.products.Product.Category;
import com.mymag.mymag.model.products.Product.IBrand;
import com.mymag.mymag.model.products.Product.ProductType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

import java.util.List;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

public class Catalog {

        public String key;
    private static Catalog instance;

    private HashMap<Category, HashMap<ProductType, HashMap<IBrand, HashSet<Product>>>> catalog;

    private Catalog() {
        catalog = new HashMap<>();
        catalog.put(Category.IT, new HashMap<ProductType, HashMap<IBrand, HashSet<Product>>>());
        catalog.put(Category.KITCHEN, new HashMap<ProductType, HashMap<IBrand, HashSet<Product>>>());
        catalog.put(Category.MOBILES, new HashMap<ProductType, HashMap<IBrand, HashSet<Product>>>());
        //TODO - temporary Product creation for testing purposes
    }

    /**
     * @return Singleton instance of Catalog
     */
    public static Catalog getInstance() {
        if (instance == null)
            instance = new Catalog();
        Random rand = new Random();
        for (int i = 0; i < 200; i++)
            instance.addToCatalog(new Laptop("TestName " + i, "TestDescription " + i, rand.nextInt(10_000), rand.nextInt(100) + 1, Laptop.LaptopModel.ASUS, (rand.nextInt(6) + 1) * 4, 1000 + i, "TestCPU " + i, "OSY", 1995, R.drawable.laptop_lenovo));
        return instance;
    }

    public static ArrayList<Product> getNewestProducts() {
        ArrayList<Product> newProducts = Filter.sortByDate(getAllProducts());
        ArrayList<Product> newestProducts = new ArrayList<>();
        int i = 0;
        for (Iterator itr = newProducts.iterator(); i < 20 && itr.hasNext(); i++) {
            Product p = (Product) itr.next();
            if (p == null) {
                i--;
                continue;
            }
            newestProducts.add(p);
        }
        return newestProducts;
    }

    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> allProducts = new ArrayList<>();

        for (Entry<Category, HashMap<ProductType, HashMap<IBrand, HashSet<Product>>>> e : Catalog.getInstance().catalog.entrySet())
            for (Entry<ProductType, HashMap<IBrand, HashSet<Product>>> e1 : e.getValue().entrySet())
                for (Entry<IBrand, HashSet<Product>> e2 : e1.getValue().entrySet())
                    for (Product wo : e2.getValue())
                        allProducts.add(wo);

        return allProducts;
    }

    /**
     * Iterates over the whole catalog collection and prints all items for which
     * the name starts with String from param. If not matches are found prints
     * appropriate message to console.
     *
     * @param name - Product name to search for.
     */
    public ArrayList<Product> product(String name){
        ArrayList<Product> returnProduct = new ArrayList<>();
        for (Entry<Category, HashMap<ProductType, HashMap<IBrand, HashSet<Product>>>> e : catalog.entrySet()) {
            for (Entry<ProductType, HashMap<IBrand, HashSet<Product>>> e1 : e.getValue().entrySet()) {
                if (e1.getKey().toString().equals(name)) {
                    for (Entry<IBrand, HashSet<Product>> e2 : e1.getValue().entrySet()) {
                        for (Product wo : e2.getValue()) {
                            returnProduct.add(wo);
                        }
                    }
                }
            }
        }

        return returnProduct;


    }

    public void searchInCatalog(String name) {
        if (name == null || name.isEmpty())
            return;

        ArrayList<Product> matchingItems = new ArrayList<>();

        for (Entry<Category, HashMap<ProductType, HashMap<IBrand, HashSet<Product>>>> e : catalog.entrySet())
            for (Entry<ProductType, HashMap<IBrand, HashSet<Product>>> e1 : e.getValue().entrySet())
                for (Entry<IBrand, HashSet<Product>> e2 : e1.getValue().entrySet())
                    for (Product wo : e2.getValue())
                        if (wo.getName().startsWith(name))
                            matchingItems.add(wo);

        if (matchingItems.isEmpty()) {
            System.out.println("Sorry. No items match search term.");
            return;
        }

        // no lambdas in J1.7 AND no ArrayList.sort(Comparator) .... :(
        Collections.sort(matchingItems, new Comparator<Product>() {
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
     * @param prod - Product instance, which to find and remove from catalog
     * @return true if product was present in catalog
     */
    public boolean removeFromCatalog(Product prod) {
        // TODO DANGEROUS .get(key) returns null if this map contains no mapping
        // for the key => might throw NullPointerExeption! Probably should be expanded and null checks added after each .get(...).
        return catalog.get(prod.getCategory()).get(prod.getProductType()).get(prod.getBrand()).remove(prod);
    }

    /**
     * @param pro - Product instance which to add to catalog.
     * @return <b>true</b> if the catalog did NOT contain pro.
     * <b>false</b> if element was already present or is null
     */
    public boolean addToCatalog(Product pro) {

        if (pro == null)
            return false;

        Category cat = pro.getCategory();
        IBrand brand = pro.getBrand();
        ProductType prodType = pro.getProductType();

        if (!catalog.containsKey(cat)) {
            catalog.put(cat, new HashMap<ProductType, HashMap<IBrand, HashSet<Product>>>());
        }
        if (!catalog.get(cat).containsKey(prodType)) {
            catalog.get(cat).put(prodType, new HashMap<IBrand, HashSet<Product>>());
        }
        if (!catalog.get(cat).get(prodType).containsKey(brand)) {
            catalog.get(cat).get(prodType).put(brand, new HashSet<Product>());
        }

        return catalog.get(cat).get(prodType).get(brand).add(pro);
    }

    @Deprecated
    public void printCatalog() {
        for (Entry<Category, HashMap<ProductType, HashMap<IBrand, HashSet<Product>>>> e : catalog.entrySet()) {
            System.out.println("------------" + e.getKey() + "------------");
            for (Entry<ProductType, HashMap<IBrand, HashSet<Product>>> e1 : e.getValue().entrySet()) {
                System.out.println("     *****" + e1.getKey() + "*****");
                for (Entry<IBrand, HashSet<Product>> e2 : e1.getValue().entrySet()) {
                    System.out.println("         ========" + e2.getKey() + "========");
                    for (Product wo : e2.getValue()) {
                        System.out.println("                ########" + wo + "########");
                    }
                }
            }
        }
    }

    public boolean updateProductAmount(Product p, int amount) {
        if (p == null)
            return false;
        Category cat = p.getCategory();
        ProductType prodType = p.getProductType();
        IBrand brand = p.getBrand();

        try {
            HashSet<Product> brandSet = catalog.get(cat).get(prodType).get(brand);
            for (Product prod : brandSet) {
                if (p.equals(prod)) {
                    if (p.getAmount() < amount)
                        return false;
                    p.setAmount(p.getAmount() - amount);
                }
            }
        } catch (NullPointerException e) {
            return false;
        }
        return false;
    }
}