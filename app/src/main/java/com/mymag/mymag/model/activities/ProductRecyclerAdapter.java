package com.mymag.mymag.model.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mymag.mymag.R;
import com.mymag.mymag.model.products.Product;

import java.util.ArrayList;

/**
 * Created by simeon on 3/29/17.
 */


class ProductRecyclerAdapter extends RecyclerView.Adapter<com.mymag.mymag.model.activities.ProductRecyclerAdapter.ProductRecyclerViewHolder> {

    Context c;
    ArrayList<Product> data;
    private LayoutInflater inflater;
    private int layoutId;

    ProductRecyclerAdapter(Context context, int layoutId, ArrayList<Product> data) {
        inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
        c = context;
        this.data = data;
    }

    @Override
    public ProductRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(layoutId, parent, false);

        ProductRecyclerViewHolder viewHolder = new ProductRecyclerViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductRecyclerViewHolder holder, int position) {
        Product p = data.get(position);
        holder.itemView.setTag(p);
        holder.title.setText(p.getName());
        holder.photo.setImageDrawable(ContextCompat.getDrawable(c, R.drawable.photo_not_found));
        holder.price.setText("" + p.getPrice() + "$");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ProductRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView photo;
        TextView title;
        TextView price;

        public ProductRecyclerViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            photo = (ImageView) itemView.findViewById(R.id.productlist_photo);
            title = (TextView) itemView.findViewById(R.id.productlist_title);
            price = (TextView) itemView.findViewById(R.id.productlist_price);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(c, ProductActivity.class);
            i.putExtra(c.getString(R.string.PRODUCT_KEY), (Product) v.getTag());
            c.startActivity(i);
        }
    }
}
