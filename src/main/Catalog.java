package main;

import java.util.HashMap;
import java.util.TreeSet;

import worderope.WearingObjects;
import worderope.WearingObjects.Type;
import worderope.WearingObjects.Wearable;

import main.Products.Categories;
import main.Products.Saleable;

public class Catalog {
	//https://github.com/igachmov/myMag.git
	private HashMap<Categories,HashMap<Products,TreeSet<Saleable>>> catalog;
	
	public Catalog(){	
	  catalog = new HashMap<>();
	  catalog.put(Categories.IT, new HashMap<Products, TreeSet<Saleable>>());
	  catalog.put(Categories.KITCHEN, new HashMap<Products, TreeSet<Saleable>>());
	  catalog.put(Categories.MOBILES, new HashMap<Products, TreeSet<Saleable>>());	
	}
	
	
	
	
}
