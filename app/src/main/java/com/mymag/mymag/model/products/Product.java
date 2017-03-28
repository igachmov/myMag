package com.mymag.mymag.model.products;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;


/**
 * Base class for all concrete Product types. Provides basic characteristics and corresponding getters & constructor.
 */

public abstract class Product implements Comparable<Product>, Serializable {

    //TODO Product types should be discussed and finalized.
    public enum Category {
        IT, KITCHEN, MOBILES
    }

    public enum ProductType {
        COMPUTER, LAPTOP, FRIDGE, OVEN, SMARTPHONE, TELEVISION
    }

    public interface IBrand {
    }


    private static int idGen = 1;
    private final int id;
    private final Date dateAdded;
    private String name;
    private String description;
    private double price;
    private int amountInStock;
    private Category category;
    private ProductType productType;
    private IBrand brand;
    private int imageID;

    public Product(String name, String description, double price, int amount, Category category, ProductType product, IBrand brand,int imageID) {

        //TODO validation!

        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amount;
        this.category = category;
        this.productType = product;
        this.brand = brand;
        this.imageID = imageID;

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
    public String getDescription() { return description; }
    public int getAmount() {
        return this.amountInStock;
    }
    public void setAmount(int amount) {
        this.amountInStock = amount;
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
    public int getImageID(){
        return  this.imageID;
    }


    /**
     * Gets the specific Product technical characteristics in an abstract fashion.
     * @return HashMap of object's characteristics in a <name, value> format.
     */
    public abstract HashMap<String, String> getSpecs();


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
        return 37 * id;
    }

    @Override
    public String toString() {
        if (this.amountInStock == 0) {
            return "Out of stock";
        }
        return this.name + "---" + this.price + "----" + this.amountInStock;
    }



}
