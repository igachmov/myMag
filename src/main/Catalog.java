package main;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import main.Products.Categories;
import main.Products.Saleable;

public class Catalog {
	//https://github.com/igachmov/myMag.git
	private HashMap<Categories,HashMap<Saleable, TreeSet<Products>>> catalog;
	
	public Catalog(){	
	  catalog = new HashMap<>();
	  catalog.put(Categories.IT, new HashMap<Saleable, TreeSet<Products>>());
	  catalog.put(Categories.KITCHEN, new HashMap<Saleable, TreeSet<Products>>());
	  catalog.put(Categories.MOBILES, new HashMap<Saleable, TreeSet<Products>>());	
	}
	
	public void addCatalog(Products pro ){
		Categories cat = pro.getCategory();
		Saleable saleable = pro.getSaleable();
		if(!catalog.containsKey(cat)){
			catalog.put(cat, new HashMap<Saleable, TreeSet<Products>>());			
		}
		if(!catalog.get(cat).containsKey(saleable)){
			catalog.get(cat).put(saleable, new TreeSet<Products>());
		}
		catalog.get(cat).get(saleable).add(pro);		
	}
	
	public void printCatalog(){
		for(Entry<Categories,HashMap<Saleable, TreeSet<Products>>> e: catalog.entrySet()){
			System.out.println("------------"+e.getKey()+"------------");
			for(Entry<Saleable, TreeSet<Products>> e1: e.getValue().entrySet()){
				System.out.println("     ------------"+e1.getKey()+"------------");
				for(Products wo : e1.getValue() ){
					System.out.println("        ------------"+wo+"------------");
				}
			}
		}
	}
}
	
	
	

