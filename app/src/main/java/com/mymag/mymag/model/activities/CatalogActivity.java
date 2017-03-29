package com.mymag.mymag.model.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mymag.mymag.R;
import com.mymag.mymag.model.products.Computer;
import com.mymag.mymag.model.products.Product;

import java.util.ArrayList;
import java.util.List;

public class CatalogActivity extends AppCompatActivity {

    private List<Product> products;
    private RecyclerView recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        products = new ArrayList<>();
        Bundle bundle = this.getIntent().getExtras();
        if(bundle!=null) {
            products = (List<Product>) bundle.getSerializable("List");
        }


        recycleAdapter =(RecyclerView) findViewById(R.id.catalog_recycle_view);
        CategoryAdapter adapter = new CategoryAdapter(this,products);
        recycleAdapter.setAdapter(adapter);
        recycleAdapter.setLayoutManager(new LinearLayoutManager(this));


    }
}
