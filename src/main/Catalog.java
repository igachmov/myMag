package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import main.Products.Categories;
import main.Products.Product;
import main.Products.Saleable;

public class Catalog {
	private HashMap<Categories,HashMap<Product,HashMap<Saleable, TreeSet<Products>>>> catalog;
	
	private static Catalog instance;
	
	private Catalog(){	
	  catalog = new HashMap<>();
	  catalog.put(Categories.IT, new HashMap<Product,HashMap<Saleable, TreeSet<Products>>>());
	  catalog.put(Categories.KITCHEN,new HashMap<Product,HashMap<Saleable, TreeSet<Products>>>());
	  catalog.put(Categories.MOBILES, new HashMap<Product,HashMap<Saleable, TreeSet<Products>>>());	
	}
	
	
	public static Catalog getInstance(){
		if(instance == null){
			instance = new Catalog();			
		}		
		return instance;
		
	}
	
	
	public void searchInCatalog(String name){
		ArrayList<Products> product = new ArrayList<>();
			for(Entry<Categories,HashMap<Product,HashMap<Saleable, TreeSet<Products>>>> e: catalog.entrySet()){
			
			for(Entry<Product,HashMap<Saleable, TreeSet<Products>>> e1: e.getValue().entrySet()){
				
				for(Entry<Saleable, TreeSet<Products>> e2: e1.getValue().entrySet()){
					
					for(Products wo : e2.getValue() ){
						if(wo.getName().contains(name)){
							product.add(wo);
						}
					}
				}
			}
			 
			System.out.println(product);
			
			
		}
		
		
		
	}
	
	
	
	public void removeFromCatalog(Products prod){
		catalog.get(prod.getCategory()).get(prod.getProduct()).get(prod.getSaleable()).remove(prod);
		
	}
	
	
	public void addCatalog(Products pro ){
		Categories cat = pro.getCategory();
		Saleable saleable = pro.getSaleable();
		Product prod = pro.getProduct();
		if(!catalog.containsKey(cat)){
			catalog.put(cat, new HashMap<Product,HashMap<Saleable, TreeSet<Products>>>());			
		}
		if(!catalog.get(cat).containsKey(prod)){
			catalog.get(cat).put(prod, new HashMap<Saleable, TreeSet<Products>>());
		}
		if(!catalog.get(cat).get(prod).containsKey(saleable)){
			catalog.get(cat).get(prod).put(saleable, new TreeSet<Products>());
		}
		catalog.get(cat).get(prod).get(saleable).add(pro);		
	}
	
	public void printCatalog(){
		for(Entry<Categories,HashMap<Product,HashMap<Saleable, TreeSet<Products>>>> e: catalog.entrySet()){
			System.out.println("------------"+e.getKey()+"------------");
			for(Entry<Product,HashMap<Saleable, TreeSet<Products>>> e1: e.getValue().entrySet()){
				System.out.println("     *****"+e1.getKey()+"*****");
				for(Entry<Saleable, TreeSet<Products>> e2: e1.getValue().entrySet()){
					System.out.println("         ========"+e2.getKey()+"========");
					for(Products wo : e2.getValue() ){
						System.out.println("                ########"+wo+"########");
					}
				}
			}
		}
	}
	
	
	public  void  updateProductAmount(Products p){
		for(Entry<Categories,HashMap<Product,HashMap<Saleable, TreeSet<Products>>>> e: catalog.entrySet()){
			for(Entry<Product,HashMap<Saleable, TreeSet<Products>>> e1: e.getValue().entrySet()){
				for(Entry<Saleable, TreeSet<Products>> e2: e1.getValue().entrySet()){
					for(Products wo : e2.getValue() ){
						if(wo.getName().equals(p.getName())){
							if(!(wo.getAmount() - p.getAmount()<0)){
								wo.setAmount(wo.getAmount() - p.getAmount());
							}
							//TODO chek for error;
						}
					}
				}
			}
		}
		
	}
}
	
	
	

