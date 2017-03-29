package com.mymag.mymag.model.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mymag.mymag.R;
import com.mymag.mymag.model.catalogs.Catalog;
import com.mymag.mymag.model.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CategoryActivity extends AppCompatActivity {

    private Button computerButton;
    private Button laptopsButton;
    private Button fridgeButton;
    private Button ovenButton;
    private Button smartphoneButton;
    private Button televisionButton;
    private String key;
    private  ArrayList<Product> product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        computerButton = (Button) findViewById(R.id.computer_button);
        laptopsButton = (Button) findViewById(R.id.laptop_button);
        fridgeButton = (Button) findViewById(R.id.fridge_button);
        ovenButton = (Button) findViewById(R.id.oven_button);
        smartphoneButton = (Button) findViewById(R.id.smartphone_button);
        televisionButton = (Button) findViewById(R.id.television_button);

        product = new ArrayList<>();


        computerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key="COMPUTER";
                product = Catalog.getInstance().product(key);
               Intent intent = new Intent(CategoryActivity.this,CatalogActivity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("List",product);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        laptopsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key="LAPTOP";
                product = Catalog.getInstance().product(key);
                Intent intent = new Intent(CategoryActivity.this,CatalogActivity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("List",product);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        fridgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key="FRIDGE";
                product = Catalog.getInstance().product(key);
                Intent intent = new Intent(CategoryActivity.this,CatalogActivity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("List",product);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        ovenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key="OVEN";
                product = Catalog.getInstance().product(key);
                Intent intent = new Intent(CategoryActivity.this,CatalogActivity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("List",product);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        smartphoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key="SMARTPHONE";
                product = Catalog.getInstance().product(key);
                Intent intent = new Intent(CategoryActivity.this,CatalogActivity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("List",product);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        televisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key="TELEVISION";
                product = Catalog.getInstance().product(key);
                Intent intent = new Intent(CategoryActivity.this,CatalogActivity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("List",product);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });


    }
}
