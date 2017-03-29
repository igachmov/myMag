package com.mymag.mymag.model.activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    public void onBindViewHolder(final CarAdapter.MyHolderView holder, int position) {
            final User.Cart.CartProduct product =carProducts.get(position);
            holder.itemView.setTag(product);
            holder.name.setText(product.getProduct().getName());
            holder.price.setText(product.getProduct().getPrice()+"");
            holder.pic.setImageResource(product.getProduct().getImageID());


            final User.Cart.CartProduct cp = (User.Cart.CartProduct) holder.itemView.getTag();

            holder.plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    holder.amount.setText(""+cp.IncrementAmount());


                }
            });

        holder.minus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               double totalPrice = cp.getProduct().getPrice();
               double showPrice = totalPrice;
               int amount = cp.getAmount();
               if(amount>1) {
                   amount--;
                   holder.amount.setText(amount + "");
                   showPrice -=totalPrice;
               }
               holder.price.setText(String.valueOf(showPrice));

            }

         });



    }

    @Override
    public int getItemCount() {
        return carProducts.size();
    }

    public class MyHolderView extends RecyclerView.ViewHolder  {
        ImageView pic;
        TextView name;
        TextView price;
        Button plus;
        Button minus;
        TextView amount;

        public MyHolderView(View row) {
            super(row);
            pic= (ImageView) row.findViewById(R.id.adapter_image_product);
            name = (TextView) row.findViewById(R.id.adapter_name_product);
            price = (TextView) row.findViewById(R.id.adapter_price_product);
            plus  = (Button) row.findViewById(R.id.plus);
            minus = (Button) row.findViewById(R.id.minus);
            amount = (TextView) row.findViewById(R.id.amount);

        }



    }
}
