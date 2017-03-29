package com.mymag.mymag.model.activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mymag.mymag.R;
import com.mymag.mymag.model.products.Product;
import com.mymag.mymag.model.users.User;

import java.util.List;

/**
 * Created by Ivan on 3/28/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyHolderView> {

    private List<User.Cart.CartProduct> carProducts;
    private Context context;

    public CarAdapter(Context context, List<User.Cart.CartProduct> products) {
        this.carProducts = products;
        this.context = context;
    }


    @Override
    public CarAdapter.MyHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View row = li.inflate(R.layout.product_adapter, parent,false);
        MyHolderView vh = new MyHolderView(row);
        return vh;
    }

    @Override
    public void onBindViewHolder(CarAdapter.MyHolderView holder, int position) {
            User.Cart.CartProduct product =carProducts.get(position);
            holder.name.setText(product.getProduct().getName());
            holder.price.setText(product.getProduct().getPrice()+"");
            holder.pic.setImageResource(product.getProduct().getImageID());

    }

    @Override
    public int getItemCount() {
        return carProducts.size();
    }

    public class MyHolderView extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView name;
        TextView price;
        Button plus;
        Button minus;

        public MyHolderView(View row) {
            super(row);
            pic= (ImageView) row.findViewById(R.id.adapter_image_product);
            name = (TextView) row.findViewById(R.id.adapter_name_product);
            price = (TextView) row.findViewById(R.id.adapter_price_product);
            plus  = (Button) row.findViewById(R.id.plus);
            minus = (Button) row.findViewById(R.id.minus);

        }
    }
}
