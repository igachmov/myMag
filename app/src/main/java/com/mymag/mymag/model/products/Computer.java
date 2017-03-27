package com.mymag.mymag.model.products;

import java.util.HashMap;

public class Computer extends Product {

    public enum ComputerModel implements IBrand {
        LENOVO, HP, DELL, ASUS
    }

    private int ram;
    private int hardDisk;
    private String processor;
    private String operatingSystem;
    private int year;
    public Computer(String name, String description, double price, int amount, ComputerModel brand, int ram, int hardDisk, String processor,
                    String operatingSystem, int year) {
        super(name, description, price, amount, Category.IT, Product.ProductType.COMPUTER, brand);

        this.ram = ram;
        this.hardDisk = hardDisk;
        this.processor = processor;
        this.operatingSystem = operatingSystem;
        this.year = year;

    }

    @Override
    public HashMap<String, String> getSpecs() {
        HashMap<String,String> specs = new HashMap<>();

        specs.put("RAM", String.valueOf(ram));
        specs.put("HDD", String.valueOf(hardDisk));
        specs.put("CPU", processor);
        specs.put("OS", operatingSystem);
        specs.put("year", String.valueOf(year));

        return specs;
    }


}
