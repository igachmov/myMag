package com.mymag.mymag.model.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mymag.mymag.R;
import com.mymag.mymag.model.products.Product;
import com.mymag.mymag.model.users.User;

import java.util.ArrayList;
import java.util.Map;

public class ProductActivity extends AppCompatActivity {

    private static String PRODUCT_KEY;
    //Activity's toolbar
    private Toolbar tb;
    //Tab container for swipable pages
    private TabLayout tabLayout;
    //ViewPager managing swipable pages
    private ViewPager viewPager;
    private ProductPagerAdapter pagerAdapter;
    //Product which to visualize
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        PRODUCT_KEY = getString(R.string.PRODUCT_KEY);

        //Get product which to visualize
        Intent i = getIntent();
        product = (Product) i.getSerializableExtra(PRODUCT_KEY);
        if (product == null) finish();

        pagerAdapter = new ProductPagerAdapter(getSupportFragmentManager(), product);

        //Set-up Toolbar & ViewPager
        tb = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(tb);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayUseLogoEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.product_view_pager);
        viewPager.setAdapter(pagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.product_tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(ContextCompat.getColor(this,R.color.backgroundLight),ContextCompat.getColor(this,R.color.colorAccent));



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.buy_button);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.user.addToCart(product);
                Toast.makeText(ProductActivity.this, product.getName() + " added to cart.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProductActivity.this, CartActivity.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Displays the product photo and product text description with buy button and price at the bottom.
     */
    public static class ProductDescriptionFragment extends Fragment {
        private Product product;

        public static Fragment newInstance(Product p) {
            Fragment f = new ProductDescriptionFragment();
            Bundle b = new Bundle();
            b.putSerializable(PRODUCT_KEY, p);
            f.setArguments(b);
            return f;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View v = inflater.inflate(R.layout.fragment_product_description, container, false);

            TextView description = (TextView) v.findViewById(R.id.product_description);
            ImageView imageView = (ImageView) v.findViewById(R.id.product_photo);
            TextView price = (TextView) v.findViewById(R.id.product_price);

            product = (Product) getArguments().getSerializable(PRODUCT_KEY);

            description.setText(product.getDescription());
            price.setText(String.valueOf(product.getPrice()));

            return v;
        }
    }

    /**
     * Displays a table of the product's detailed characteristics
     */
    public static class ProductSpecificationFragment extends Fragment {
        private Product product;

        private ListViewCompat listView;

        public static Fragment newInstance(Product p) {
            Fragment f = new ProductSpecificationFragment();

            Bundle b = new Bundle();
            b.putSerializable(PRODUCT_KEY, p);
            f.setArguments(b);

            return f;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_product_specification, container, false);

            product = (Product) getArguments().getSerializable(PRODUCT_KEY);
            listView = (ListViewCompat) v.findViewById(R.id.product_specs_list);

            ProductSpecsListAdapter listAdapter = new ProductSpecsListAdapter(getContext(), product);
            listView.setAdapter(listAdapter);

            return v;
        }
    }

}


class ProductSpecsListAdapter extends BaseAdapter {

    //Used ArrLst insted as HshMap (as Product.getSpecs() returns, to allow returning by position(index);
    private ArrayList<Map.Entry<String, String>> specifications;
    private Context c;

    ProductSpecsListAdapter(Context context, Product p) {
        specifications = new ArrayList<>();
        specifications.addAll(p.getSpecs().entrySet());
        c = context;
    }

    @Override
    public int getCount() { return this.specifications.size(); }

    @Override
    public Object getItem(int position) {
        return specifications.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.view_product_specification, parent, false);

        Map.Entry<String, String> spec = specifications.get(position);

        ((TextView) row.findViewById(R.id.spec_title)).setText(spec.getKey());
        ((TextView) row.findViewById(R.id.spec_cotent)).setText(spec.getValue());

        return row;
    }
}


class ProductPagerAdapter extends FragmentPagerAdapter {

    Product p;

    public ProductPagerAdapter(FragmentManager fm, Product p) {
        super(fm);
        this.p = p;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ProductActivity.ProductDescriptionFragment.newInstance(p);
            case 1:
                return ProductActivity.ProductSpecificationFragment.newInstance(p);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "description";
            case 1:
                return "specifications";
        }
        return null;
    }
}