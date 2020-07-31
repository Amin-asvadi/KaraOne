package com.example.karayek.ui.sahamListTabs;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.karayek.R;
import com.example.karayek.ui.sahamListTabs.fiveHundredStock.FiveHundredListStockHFragment;
import com.example.karayek.ui.sahamListTabs.oneMelionStock.OneMelioonStockFragment;
import com.google.android.material.tabs.TabLayout;

public class SahamListTabsActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FiveHundredListStockHFragment fiveHundredListStockHFragment;
    private OneMelioonStockFragment oneMelioonStockFragment;

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
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerSingelAdapter viewPagerSingelAdapter =
                new ViewPagerSingelAdapter(getSupportFragmentManager(), 0);


        viewPagerSingelAdapter.addFragments(oneMelioonStockFragment, " سهام ۱ میلیونی");
        viewPagerSingelAdapter.addFragments(fiveHundredListStockHFragment, "سهام ۵۰۰ هزار تومانی");
        viewPager.setAdapter(viewPagerSingelAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_menu);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_menu).select();
    }
}