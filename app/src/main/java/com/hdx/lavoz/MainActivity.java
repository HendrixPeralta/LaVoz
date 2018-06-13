package com.hdx.lavoz;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, Serializable {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    Spinner spinner;

    private final static int RESULT_OK = 1;

    private static String USER_NAME = null;
    private static String POST_TITLE = null;
    private static String POST_DATE = null;
    private static String POST_CATEGORY;
    private static String POST_DESCRIPTION = null;
    private static int POST_IMAGE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton myFloatButton =
                findViewById(R.id.float_button);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new FragmentNews(), "Noticias");
        viewPagerAdapter.addFragment(new FragmentSports(), "Deportes");
        viewPagerAdapter.addFragment(new FragmentInternational(), "Economia");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

        myFloatButton.setOnClickListener(view ->{
            Intent goToDataCollector = new Intent(this, NewsDataCollector.class);
            startActivityForResult(goToDataCollector, RESULT_OK);
        });

    }



    @Override
    public void onClick(View v) {

    }

}
