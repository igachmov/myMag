package com.mymag.mymag.model.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mymag.mymag.R;
import com.mymag.mymag.model.products.Product;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    private static String PRODUCT_LIST_KEY;
    private RecyclerView recyclerView;
    private ProductRecyclerAdapter recyclerAdapter;
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        PRODUCT_LIST_KEY = getString(R.string.PRODUCT_LIST_KEY);

        products = (ArrayList<Product>) getIntent().getSerializableExtra(PRODUCT_LIST_KEY);
        //TODO passes the null-check regardless :(
//        if (products == null){
//            Toast.makeText(this, "Hello there pal! I'm a NullPointr. Quite cool, eh?", Toast.LENGTH_SHORT).show();
//            finish();
//        }
//        if (products.isEmpty()) {
//            Toast.makeText(this, "Sorry, no items to display", Toast.LENGTH_SHORT).show();
//            finish();
//        }

        recyclerView = (RecyclerView) findViewById(R.id.productlist_recyclerview);
        recyclerAdapter = new ProductRecyclerAdapter(this,products);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}

class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerViewHolder> {

    private LayoutInflater inflater;
    Context c;

    ArrayList<Product> data;

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
        holder.photo.setImageDrawable(ContextCompat.getDrawable(c,R.drawable.photo_not_found));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

class ProductRecyclerViewHolder extends RecyclerView.ViewHolder {

    ImageView photo;
    TextView title;

    public ProductRecyclerViewHolder(View itemView) {
        super(itemView);

        photo = (ImageView) itemView.findViewById(R.id.productlist_photo);
        title = (TextView) itemView.findViewById(R.id.productlist_title);

    }
}
