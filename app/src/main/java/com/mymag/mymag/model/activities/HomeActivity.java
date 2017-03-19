package com.mymag.mymag.model.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.mymag.mymag.R;
import com.mymag.mymag.model.products.Computer;
import com.mymag.mymag.model.products.Product;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

                int id = v.getId();
                Class destination = HomeActivity.class;

                switch (id){
                    case R.id.cart_redirect:
                        destination = CartActivity.class;
                        break;
                    case R.id.category_redirect:
                        destination = CartActivity.class;
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
                        destination = ProductActivity.class;
                        break;
                    case R.id.product_list_redirect:
                        destination = ProductListActivity.class;
                        break;
                    case R.id.user_redirect:
                        destination = UserActivity.class;
                        break;
                }
                Random rand = new Random();
                Intent i = new Intent();
                i.putExtra("Product", new Computer("NAME","THIS IS A TEST DESCRIPTION", rand.nextInt(10_000),33, Computer.ComputerModel.ASUS,126,1000,"Fyzen 7","OS-Y",1998));
                i.setClass(HomeActivity.this,destination);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
