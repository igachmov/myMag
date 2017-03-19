package com.mymag.mymag.model.activities;

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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mymag.mymag.R;

import org.w3c.dom.Text;

public class ProductActivity extends AppCompatActivity {

    private Toolbar tb;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ProductPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        pagerAdapter = new ProductPagerAdapter(getSupportFragmentManager());

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

        public static Fragment newInstance() {
            return new ProductDescriptionFragment();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            TextView tv = new TextView(getActivity());
            tv.setText("HOPE THIS WORKS ~O_O~");
            return tv;
        }
    }

    public static class ProductSpecificationFragment extends Fragment {
        public static Fragment newInstance() {
            return new ProductSpecificationFragment();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            TextView tv = new TextView(getActivity());
            tv.setText("WOW! IT WORKED (O,O)");
            return tv;
        }
    }

}

class ProductPagerAdapter extends FragmentPagerAdapter {

    public ProductPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ProductActivity.ProductDescriptionFragment.newInstance();
            case 1:
                return ProductActivity.ProductSpecificationFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "description";
            case 1:
                return "specifications";
        }
        return null;
    }
}