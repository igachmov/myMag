package com.mymag.mymag.model.products;

import java.util.Date;


/**
 * Base class for all concrete Product types. Provides basic characteristics and corresponding getters & constructor.
 */

public abstract class Product implements Comparable<Product>{

    //TODO Product types should be discussed and finalized.
    public enum Category {
        IT, KITCHEN, MOBILES
    }

    public enum ProductType {
        COMPUTER, LAPTOP, FRIDGE, OVEN, SMARTPHONE, TELEVISION
    }

    public interface IBrand{}


    private static int idGen = 1;

    private final int id;
    private final Date dateAdded;

    private String name;
    private double price;
    private int amountInStock;

    private Category category;
    private ProductType productType;
    private IBrand brand;


    public Product(String name, double price, int amount, Category category, ProductType product, IBrand brand) {

        //TODO validation!

        this.name = name;
        this.price = price;
        this.amountInStock = amount;
        this.category = category;
        this.productType = product;
        this.brand = brand;

        //Why, oh why is LocalDate not supported in Android yet ?! :(
        dateAdded = new Date();
        dateAdded.setTime(System.currentTimeMillis());

        idGen++;
        id = idGen;
    }

    public Category getCategory() {
        return this.category;
    }
    public ProductType getProductType() {
        return this.productType;
    }
    public IBrand getBrand() {
        return this.brand;
    }
    public String getName() {
        return this.name;
    }
    public int getAmount() {
        return this.amountInStock;
    }
    public Date getDateAdded() {
        return dateAdded;
    }
    public double getPrice() {
        return this.price;
    }
    public int getID() {
        return this.id;
    }

    public void setAmount(int amount) {
        this.amountInStock = amount;
    }

    @Override
    public int compareTo(Product o) {
        if (this == o)
            return 0;
        if (o == null)
            return -1;
        return this.id - o.id;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        return ((obj instanceof Product) && (this.id == ((Product) obj).id));
    }
    @Override
    public int hashCode() {
        return 37*id;
    }

    @Override
    public String toString() {
        if (this.amountInStock == 0) {
            return "Out of stock";
        }
        return this.name + "---" + this.price + "----" + this.amountInStock;
    }

}
