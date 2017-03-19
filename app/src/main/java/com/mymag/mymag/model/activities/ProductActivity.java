package com.mymag.mymag.model.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.mymag.mymag.R;
import com.mymag.mymag.model.products.Computer;
import com.mymag.mymag.model.products.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductActivity extends AppCompatActivity {

    private Toolbar tb;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private Product product;

    private ProductPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent i = getIntent();

        product = (Product) i.getSerializableExtra("Product");

        pagerAdapter = new ProductPagerAdapter(getSupportFragmentManager(),product);

        tb = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayUseLogoEnabled(true);


        viewPager = (ViewPager) findViewById(R.id.product_view_pager);
        viewPager.setAdapter(pagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.product_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public static class ProductDescriptionFragment extends Fragment {
        private Product product;

        public static Fragment newInstance(Product p) {
            Fragment f = new ProductDescriptionFragment();
            Bundle b = new Bundle();
            b.putSerializable("@strings:PRODUCT_KEY",p);
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

            product = (Product) getArguments().getSerializable("@strings:PRODUCT_KEY");

            price.setText(String.valueOf(product.getPrice()));
            description.setText(product.getDescription());

            return v;
        }
    }

    public static class ProductSpecificationFragment extends Fragment {
        public static Fragment newInstance() {
            return new ProductSpecificationFragment();
        }

        private Product product;

        public static Fragment newInstance(Product p) {
            Fragment f = new ProductSpecificationFragment();
            Bundle b = new Bundle();
            b.putSerializable("@strings:PRODUCT_KEY",p);
            f.setArguments(b);
            return f;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_product_specification,container,false);

            TableLayout tl = (TableLayout) v.findViewById(R.id.product_specs_table);
            product = (Product) getArguments().getSerializable("@strings:PRODUCT_KEY");

            HashMap<String, String> specs = product.getSpecs();

            for (Map.Entry<String,String> entry : specs.entrySet()) {
//                TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
//                TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
//
//                TableLayout tableLayout = new TableLayout(context);
//                tableLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));// assuming the parent view is a LinearLayout
//
//                TableRow tableRow = new TableRow(context);
//                tableRow.setLayoutParams(tableParams);// TableLayout is the parent view
//
//                TextView textView = new TextView(context);
//                textView.setLayoutParams(rowParams);// TableRow is the parent view
//
//                tableRow.addView(textView);

                TableRow tr = new TableRow(getActivity());

                TextView specName = new TextView(getActivity());
                specName.setText(entry.getKey());
                tr.addView(specName);

                TextView specValue = new TextView(getActivity());
                specValue.setText(entry.getValue());
                tr.addView(specValue);

                tl.addView(tr);
            }

            return v;
        }
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