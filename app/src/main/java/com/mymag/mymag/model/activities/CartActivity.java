package com.mymag.mymag.model.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mymag.mymag.R;
import com.mymag.mymag.model.users.User;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private int amountNum = 1;

    private User loggedUser = User.user;
    private RecyclerView recycleAdapter;
    private List<User.Cart.CartProduct> product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        product = new ArrayList<>();
        product.addAll(loggedUser.getCart().getProductsInCart());

        Button checkout = (Button) findViewById(R.id.checkout);

       final EditText amount = (EditText) findViewById(R.id.amount);
       final TextView total = (TextView) findViewById(R.id.totalvw);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toChecout = new Intent(CartActivity.this,CheckOutActivity.class);
                startActivity(toChecout);
            }
        });

        recycleAdapter =(RecyclerView) findViewById(R.id.recycle_view_cart);
        CarAdapter adapter = new CarAdapter(this,product);
        recycleAdapter.setAdapter(adapter);
        recycleAdapter.setLayoutManager(new LinearLayoutManager(this));



    }
}
