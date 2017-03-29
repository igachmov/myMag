package com.mymag.mymag.model.activities;

import android.app.Activity;
import android.app.SearchManager;
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

public class HomeActivity extends AppCompatActivity {

    public static Activity home;
    private RecyclerView recyclerNewProducts;
    private RecyclerView recyclerOtherProducts;
    private Button categoriesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home = this;

        Toolbar tb = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.mipmap.ic_launcher_round);
        ab.setDisplayShowTitleEnabled(false);

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
                startActivity(new Intent(HomeActivity.this, ProductListActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app_bar, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

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
