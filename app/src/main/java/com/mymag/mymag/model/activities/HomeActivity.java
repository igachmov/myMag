package com.mymag.mymag.model.activities;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.mymag.mymag.R;
import com.mymag.mymag.model.catalogs.Catalog;
import com.mymag.mymag.model.products.Computer;
import com.mymag.mymag.model.products.Fridge;
import com.mymag.mymag.model.products.Laptop;
import com.mymag.mymag.model.products.Oven;
import com.mymag.mymag.model.products.SmartPhone;
import com.mymag.mymag.model.products.Television;

public class HomeActivity extends AppCompatActivity {

    public static Activity home;
    private RecyclerView recyclerNewProducts;
    private RecyclerView recyclerOtherProducts;
    private Button categoriesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Catalog.getInstance();

        Computer comp = new Computer("Bla","Blablabla",133,10, Computer.ComputerModel.LENOVO,R.drawable.laptop_lenovo,5,500,"WOW","OS",2010);
        Computer comp1 = new Computer("1","4",222,10, Computer.ComputerModel.LENOVO,R.drawable.laptop_lenovo,5,500,"WOW","OS",2010);
        Computer comp2 = new Computer("2","3",13333,10, Computer.ComputerModel.LENOVO,R.drawable.laptop_lenovo,5,500,"WOW","OS",2010);
        Laptop laptop = new Laptop("asd","asd",12333,10, Laptop.LaptopModel.ASUS,6,1000,"Intel","Windows",2009,R.drawable.laptop_lenovo);
        Laptop laptop1 = new Laptop("asasdd","asd",244,10, Laptop.LaptopModel.ASUS,6,1000,"Intel","Windows",2009,R.drawable.laptop_lenovo);
        Laptop laptop2 = new Laptop("asdasd","asd",1213333,10, Laptop.LaptopModel.ASUS,6,1000,"Intel","Windows",2009,R.drawable.laptop_lenovo);
        Fridge fridge = new Fridge("asd","asd",1233,10, Fridge.FridgeModel.BEKO,R.drawable.laptop_lenovo);
        Fridge fridge1 = new Fridge("asss","asd",12933,10, Fridge.FridgeModel.BEKO,R.drawable.laptop_lenovo);
        Fridge fridge2 = new Fridge("asbbd","asd",1231233,10, Fridge.FridgeModel.BEKO,R.drawable.laptop_lenovo);
        Oven oven = new Oven("Oven","Very good",399,20, Oven.OvenModel.GORENJE,R.drawable.laptop_lenovo);
        Oven oven1 = new Oven("Oven1","Very asd good",399,20, Oven.OvenModel.GORENJE,R.drawable.laptop_lenovo);
        Oven oven2 = new Oven("Oven2","Very asd good",399,20, Oven.OvenModel.GORENJE,R.drawable.laptop_lenovo);
        SmartPhone smartPhone = new SmartPhone("Smart Phone","Good",220,50, SmartPhone.PhoneModel.APPLE,R.drawable.laptop_lenovo);
        SmartPhone smartPhone1 = new SmartPhone("Smart Phone1","Good",220,50, SmartPhone.PhoneModel.APPLE,R.drawable.laptop_lenovo);
        SmartPhone smartPhone2 = new SmartPhone("Smart Phone2","Good",220,50, SmartPhone.PhoneModel.APPLE,R.drawable.laptop_lenovo);
        Television television = new Television("Television","Full HD",1999.99,100, Television.TVModels.LG,R.drawable.laptop_lenovo);
        Television television1 = new Television("Television","Full HD",1999.99,100, Television.TVModels.LG,R.drawable.laptop_lenovo);
        Television television2 = new Television("Television","Full HD",1999.99,100, Television.TVModels.LG,R.drawable.laptop_lenovo);



        Catalog.getInstance().addToCatalog(comp);
        Catalog.getInstance().addToCatalog(comp1);
        Catalog.getInstance().addToCatalog(comp2);
        Catalog.getInstance().addToCatalog(laptop);
        Catalog.getInstance().addToCatalog(laptop1);
        Catalog.getInstance().addToCatalog(laptop2);
        Catalog.getInstance().addToCatalog(fridge);
        Catalog.getInstance().addToCatalog(fridge1);
        Catalog.getInstance().addToCatalog(fridge2);
        Catalog.getInstance().addToCatalog(oven);
        Catalog.getInstance().addToCatalog(oven1);
        Catalog.getInstance().addToCatalog(oven2);
        Catalog.getInstance().addToCatalog(smartPhone);
        Catalog.getInstance().addToCatalog(smartPhone1);
        Catalog.getInstance().addToCatalog(smartPhone2);
        Catalog.getInstance().addToCatalog(television);
        Catalog.getInstance().addToCatalog(television1);
        Catalog.getInstance().addToCatalog(television2);

        home = this;

        Toolbar tb = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.mipmap.ic_launcher_round);

        recyclerNewProducts = (RecyclerView) findViewById(R.id.home_recycler_new_products);
        recyclerOtherProducts = (RecyclerView) findViewById(R.id.home_recycler_random_products);

        recyclerNewProducts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerOtherProducts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ProductRecyclerAdapter recyclerAdapter = new ProductRecyclerAdapter(this, R.layout.view_product_tile, Catalog.getNewestProducts());
        recyclerNewProducts.setAdapter(recyclerAdapter);
        recyclerOtherProducts.setAdapter(recyclerAdapter);

        categoriesButton = (Button) findViewById(R.id.home_categories_button);
        categoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CategoryActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app_bar, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, ProductListActivity.class)));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionbutton_to_cart:
                startActivity(new Intent(this, CartActivity.class));
                break;
            case R.id.actionbutton_to_user:
                startActivity(new Intent(this, UserActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}