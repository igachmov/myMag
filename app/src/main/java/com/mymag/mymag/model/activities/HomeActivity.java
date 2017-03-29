package com.mymag.mymag.model.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import com.mymag.mymag.model.products.Product;
import com.mymag.mymag.model.products.SmartPhone;
import com.mymag.mymag.model.products.Television;

import java.util.ArrayList;
import java.util.Random;

public class HomeActivity extends AppCompatActivity {
    Random rand = new Random();

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


        Toolbar tb = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.mipmap.ic_launcher_round);
        ab.setDisplayShowTitleEnabled(false);

        /**
         * Added buttons leading to the rest of the activities to facilitate easier navigation while implementing new features.
         * Not meant to be permanent - add and remove as needed.
         *      ~Simo
         */
        Button cart = (Button) findViewById(R.id.cart_redirect);
        Button category = (Button) findViewById(R.id.category_redirect);
        Button checkOut = (Button) findViewById(R.id.check_out_redirect);
        Button logIn = (Button) findViewById(R.id.log_in_redirect);
        Button register = (Button) findViewById(R.id.register_redirect);
        Button product = (Button) findViewById(R.id.product_redirect);
        Button productList = (Button) findViewById(R.id.product_list_redirect);
        Button user = (Button) findViewById(R.id.user_redirect);


        Button.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();

                int id = v.getId();
                Class destination = HomeActivity.class;

                switch (id) {
                    case R.id.cart_redirect:
                        destination = CartActivity.class;
                        break;
                    case R.id.category_redirect:
                        destination = CategoryActivity.class;
                        break;
                    case R.id.check_out_redirect:
                        destination = CheckOutActivity.class;
                        break;
                    case R.id.log_in_redirect:
                        destination = LoginActivity.class;
                        break;
                    case R.id.register_redirect:
                        destination = RegisterActivity.class;
                        break;
                    case R.id.product_redirect:
                        i.putExtra("Product", new Computer("TEST_NAME", "THIS IS A TEST DESCRIPTION", rand.nextInt(10_000), 33, Computer.ComputerModel.ASUS,R.drawable.laptop_lenovo, 126, 1000, "Fyzen 7", "OS-Y", 1998));
                        destination = ProductActivity.class;
                        break;
                    case R.id.product_list_redirect:
                        i.putExtra(getString(R.string.PRODUCT_LIST_KEY),generateProductList(100));
                        destination = ProductListActivity.class;
                        break;
                    case R.id.user_redirect:
                        destination = UserActivity.class;
                        break;
                }

                i.setClass(HomeActivity.this, destination);
                startActivity(i);
            }
        };

        cart.setOnClickListener(clickListener);
        category.setOnClickListener(clickListener);
        checkOut.setOnClickListener(clickListener);
        logIn.setOnClickListener(clickListener);
        product.setOnClickListener(clickListener);
        productList.setOnClickListener(clickListener);
        register.setOnClickListener(clickListener);
        user.setOnClickListener(clickListener);
    }

    private ArrayList<Product> generateProductList(int size) {
        ArrayList<Product> products = new ArrayList<>();
        if (size <= 0) size = 25;
        for (int i = 0; i < size; i++)
            products.add(new Laptop("TestName " + i, "TestDescription " + i, rand.nextInt(10_000), rand.nextInt(100) + 1, Laptop.LaptopModel.ASUS, (rand.nextInt(6) + 1) * 4, 1000 + i, "TestCPU " + i, "OSY", 1995,R.drawable.laptop_lenovo));
        return products;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionbutton_to_cart:
                startActivity(new Intent(this, CartActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
