package com.mymag.mymag.model.activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mymag.mymag.R;
import com.mymag.mymag.model.products.Product;

import java.util.List;

/**
 * Created by Ivan on 3/28/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyHolderView> {

    private List<Product> carProducts;
    private Context context;

    public CategoryAdapter(List<Product> carProducts, Context context) {
        this.carProducts = carProducts;
        this.context = context;
    }


    @Override
    public CategoryAdapter.MyHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View row = li.inflate(R.layout.product_adapter, parent,false);
        CategoryAdapter.MyHolderView vh = new CategoryAdapter.MyHolderView(row);
        return vh;
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.MyHolderView holder, int position) {
        Product product =carProducts.get(position);
        holder.name.setText(product.getName());
        holder.price.setText(product.getPrice()+"");
        holder.pic.setImageResource(product.getImageID());
        holder.descripion.setText(product.getDescription());

    }

    @Override
    public int getItemCount() {
        return carProducts.size();
    }

    public class MyHolderView extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView name;
        TextView price;
        TextView descripion;

        public MyHolderView(View row) {
            super(row);
            pic= (ImageView) row.findViewById(R.id.category_image);
            name = (TextView) row.findViewById(R.id.category_name);
            price = (TextView) row.findViewById(R.id.category_price);
            descripion = (TextView) row.findViewById(R.id.category_description);

        }
    }
}
