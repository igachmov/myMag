package com.mymag.mymag.model.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mymag.mymag.R;
import com.mymag.mymag.model.catalogs.Catalog;
import com.mymag.mymag.model.users.User;

import static com.mymag.mymag.R.id.totalvw;

public class CartActivity extends AppCompatActivity {
    private int amountNum = 1;

    private User loggedUser;
    Catalog catalog = Catalog.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        Button checkout = (Button) findViewById(R.id.checkout);
        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.minus);

       final EditText amount = (EditText) findViewById(R.id.amount);
       final TextView total = (TextView) findViewById(R.id.totalvw);

        amount.setFocusable(false);
        amount.setClickable(false);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toChecout = new Intent(CartActivity.this,CheckOutActivity.class);
                startActivity(toChecout);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               amountNum++;
                amount.setText(new Integer(amountNum).toString());

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(amountNum>0) {
                  amountNum--;
                  amount.setText(new Integer(amountNum).toString());
              }
            }
        });

    }
}
