package com.mymag.mymag.model.users;

import com.mymag.mymag.model.catalogs.Catalog;
import com.mymag.mymag.model.products.Product;

import java.util.HashSet;
import java.util.UUID;

/**
 */

public class User {




    public enum Type {
        ADMIN, CLIENT
    }


    //    private final UUID userid;
    private static int userIDGen = 1;
    private  int userID;


     public static User user;

    public static void setUser(User user) {
        if (user!=null){
            User.user = user;
        }
    }

    private String name;
    private String password;
    private String telNumber;
    private String email;
    private int image;
    private String address;
    private final Type type;

    private static User admin;

    private Cart userCart;

    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.userID = id;
    }

    public String getEmail() {
        return email;
    }

    public Type getType() {
        return type;
    }

    //Конструктор за Юзера
    public User(String name, String password, String email, String telNumber, String address, Type type) {
        if (!name.isEmpty())
            this.name = name;
        if (!password.isEmpty())
            this.password = password;
        if (!name.isEmpty() && email.matches("[a-z0-9._+-]+@[a-z0-9.-]+.[a-z]{2,6}"))
            this.email = email;
        if (!telNumber.isEmpty()){
            this.telNumber=telNumber;
        }
        if (!address.isEmpty()){
            this.address=address;
        }


        this.type = type;
        if (type == Type.CLIENT) {
            userCart = new Cart();
        }
        //this.userID = ++userIDGen;

    }

    // Предефинирано просто за визуализация
    @Override
    public String toString() {
        return "Users [name=" + name + ", email=" + email + ", type=" + type + "]";
    }

    public void setName(String name) {
        if(!name.isEmpty())
        this.name = name;
    }

    public void setTelNumber(String telNumber) {
        if(!telNumber.isEmpty()&&telNumber.matches("08[0-9]{8}"))
        this.telNumber = telNumber;
    }

    public void setEmail(String email) {
        if(!email.isEmpty()&&email.matches("[a-z0-9-_]+@[a-z]+.[a-z]{2,4}"))
        this.email = email;
    }

    public void setAddress(String address) {
        if(!address.isEmpty())
        this.address = address;
    }

    public String getTelNumber() {return telNumber;}
    public String getAddress() {return this.address;}
    public String getName() { return this.name; }
    public Cart getCart() {
        return this.userCart;
    }
    public void addToCart(Product p){
        userCart.addToCart(p);
    }
    public void checkOut(){
        userCart.checkOut();
    }

    /**
     * Refers a search through the Catalog for any Products for which the name starts with:
     * @param name
     */
    public void search(String name) {
        if(name == null || name.isEmpty()){
            System.out.println("Please enter a product name!");
            return;
        }
        Catalog.getInstance().searchInCatalog(name);
    }


    class Cart {

        public HashSet<CartProduct> getProductsInCart() {
            return productsInCart;
        }

        private HashSet<CartProduct> productsInCart;

        private Cart() {
            this.productsInCart = new HashSet<>();
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
                cartProduct = new CartProduct(product, 0);
            } else if (product.getAmount() < cartProduct.amount + 1) {
                //TODO pop a question if you want to continue with the available amount
                System.out.println("Sorry, there isn't enough of that product in stock.");
                return;
            }

            productsInCart.add(cartProduct);

            cartProduct.amount++;

        }


        /**
         * Removes the specified element from this Cart if it is present.
         * Meant to be called from a 'Cart' acitivity on a specific CartProduct.
         * @param prod - Product instance to remove;
         */
        public boolean removeFromCart(CartProduct prod) {
            return prod != null && productsInCart.remove(prod);
        }


        public void setAmount(CartProduct prod, int amount) {
            if (prod == null || !this.productsInCart.contains(prod))
                return;
            if (amount < 1) {
                System.out.println("Please input a positive number. Thank you!");
                amount = 1;
            }

            // Gets the Product object represented by the 'prod' CartProduct
            Product p = prod.product;
            //Checks if there is enough of the Product p  in stock (Product.amount characteristic represents number of units in stock)
            if (amount > p.getAmount()) {
                System.out.println("Sorry, but there aren't " + amount + " units of " + p.getName() + " in stock. ");
                System.out.println("Amount in cart adjusted to: " + (amount = p.getAmount()));
                return;
            }

            prod.amount = amount;
        }



        /**
         * Finalize the Cart and make an Order from the items in the user's Cart.
         */
        public void checkOut() {
            Order.generateOrder(User.this);
            productsInCart = new HashSet<>();
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
            if (this.productsInCart.isEmpty())
                return null;
            for (CartProduct cartProduct : productsInCart)
                if (cartProduct.equals(p))
                    return cartProduct;

            return null;
        }


        /**
         * @return double - the total cost of ALL products currently in cart.
         */
        public double getTotalPrice(){
            double sum = 0;

            for (CartProduct cartProduct : productsInCart) {
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
                if (obj == this)
                    return true;
                if (obj instanceof Product)
                    return this.product.equals(obj);
                return obj instanceof CartProduct && this.product.equals(((CartProduct) obj).product);
            }

            public Product getProduct(){
                return this.product;
            }

            public int getAmount() {
                return this.amount;
            }
        }
    }
}
