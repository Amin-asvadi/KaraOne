package com.example.karayek.ui.sahamListTabs;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.karayek.R;
import com.example.karayek.ui.sahamListTabs.fiveHundredStock.FiveHundredListStockHFragment;
import com.example.karayek.ui.sahamListTabs.oneMelionStock.OneMelioonStockFragment;
import com.google.android.material.tabs.TabLayout;

public class SahamListTabsActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FiveHundredListStockHFragment fiveHundredListStockHFragment;
    private OneMelioonStockFragment oneMelioonStockFragment;
    private ImageView btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saham_list_tabs);
    ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        init();




    }

    private void init() {
        fiveHundredListStockHFragment = new FiveHundredListStockHFragment();
        oneMelioonStockFragment = new OneMelioonStockFragment();
        tabLayout = findViewById(R.id.tab_layout_singel);
        viewPager = findViewById(R.id.tab_singel_view_pager);
        btn_back = findViewById(R.id.img_back_sell_list);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerSingelAdapter viewPagerSingelAdapter =
                new ViewPagerSingelAdapter(getSupportFragmentManager(), 0);


        viewPagerSingelAdapter.addFragments(oneMelioonStockFragment, " سهام ۱ میلیون تومانی");
        viewPagerSingelAdapter.addFragments(fiveHundredListStockHFragment, "سهام ۵۰۰ هزار تومانی");
        viewPager.setAdapter(viewPagerSingelAdapter);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_yek_not_click);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_five_stock_click).select();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    tab.setIcon(R.drawable.ic_yek_click);

                } else {

                    tab.setIcon(R.drawable.ic_five_stock_click);

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {

                    tab.setIcon(R.drawable.ic_yek_not_click);

                } else {

                    tab.setIcon(R.drawable.ic_five_stock);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}