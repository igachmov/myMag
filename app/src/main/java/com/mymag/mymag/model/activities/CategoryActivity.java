package com.mymag.mymag.model.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mymag.mymag.R;
import com.mymag.mymag.model.products.Product;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private Button computerButton;
    private Button laptopsButton;
    private Button fridgeButton;
    private Button ovenButton;
    private Button smartphoneButton;
    private Button televisionButton;


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


        computerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Product> product = new ArrayList<Product>();

                Intent intent = new Intent(CategoryActivity.this,CatalogActivity.class);
                intent.putExtra(getString(R.string.PRODUCT_LIST_KEY),product);




                startActivity(intent);



            }
        });




    }
}
