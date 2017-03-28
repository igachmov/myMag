package com.mymag.mymag.model.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mymag.mymag.R;
import com.mymag.mymag.model.catalogs.Filter;
import com.mymag.mymag.model.products.Product;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    //TODO - add Product tags to Views, to avoid possible missmatch between itemId and collection index
    //TODO - documentation
    //TODO - review possible stability problems

    private static String PRODUCT_LIST_KEY;
    private RecyclerView recyclerView;
    private ProductRecyclerAdapter recyclerAdapter;
    private static ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        PRODUCT_LIST_KEY = getString(R.string.PRODUCT_LIST_KEY);

        Toolbar tb = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        products = handleIntent(getIntent());
        if (products == null)
            finish();

        recyclerView = (RecyclerView) findViewById(R.id.productlist_recyclerview);
        recyclerAdapter = new ProductRecyclerAdapter(this, products);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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

    @Nullable
    private ArrayList<Product> handleIntent(Intent i) {
        if (i == null)
            return null;
        if (Intent.ACTION_SEARCH.equals(i.getAction())) {
            String query = i.getStringExtra(SearchManager.QUERY);
            if (query == null) return null;

            products = Filter.filterByName(products,query);
            Toast.makeText(this," " +products.size() + " filtered",Toast.LENGTH_LONG).show();

            return products;
        }
        else if (i.hasExtra("PRODUCT_LIST")) {
            products = new ArrayList<>((ArrayList<Product>) i.getSerializableExtra("PRODUCT_LIST"));
            return products;
        }
        return null;
    }
}

class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ProductRecyclerViewHolder> {

    Context c;
    ArrayList<Product> data;
    private LayoutInflater inflater;

    ProductRecyclerAdapter(Context context, ArrayList<Product> data) {
        inflater = LayoutInflater.from(context);
        c = context;
        this.data = data;
    }

    @Override
    public ProductRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.view_product_row, parent, false);

        ProductRecyclerViewHolder viewHolder = new ProductRecyclerViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductRecyclerViewHolder holder, int position) {
        Product p = data.get(position);
        holder.title.setText(p.getName());
        holder.photo.setImageDrawable(ContextCompat.getDrawable(c, R.drawable.photo_not_found));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ProductRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView photo;
        TextView title;

        public ProductRecyclerViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            photo = (ImageView) itemView.findViewById(R.id.productlist_photo);
            title = (TextView) itemView.findViewById(R.id.productlist_title);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(c, ProductActivity.class);
            i.putExtra(c.getString(R.string.PRODUCT_KEY), data.get(getLayoutPosition()));
            c.startActivity(i);
        }
    }
}


