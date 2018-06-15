package com.hdx.lavoz;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, Serializable {


    public static final int RC_SIGN_IN = 1;

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    Spinner spinner;

//    private FirebaseDatabase mfirebaseDatabase;
//    private DatabaseReference mSportDatabaseReference;
//    private DatabaseReference mEconomytDatabaseReference;
//    private ChildEventListener mChildEventListener;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;


    private final static int DATA_PICKER = -1    ;

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

        firebaseAuth = FirebaseAuth.getInstance();
//        mfirebaseDatabase = FirebaseDatabase.getInstance();
//        mSportDatabaseReference = mfirebaseDatabase.getReference().child("Sport");
//        mEconomytDatabaseReference = mfirebaseDatabase.getReference().child("Economy");

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
            startActivityForResult(goToDataCollector, DATA_PICKER);
        });

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){

                }
                else {
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setIsSmartLockEnabled(false, false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.GoogleBuilder().build()
                                    ))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };


    }

    @Override
    public void onClick(View v) {
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.d("HELLO WORLD !!!!!!", "here1");
//        if (requestCode == DATA_PICKER){
//            Log.d("HELLO WORLD !!!!!!", "here2");
//            if(resultCode == RESULT_OK){
//                String result = data.getStringExtra(NewsDataCollector.TITLE);
//                Log.d("HELLO WORLD !!!!!!", result);
//            }
//
//        }
//    }


    @Override
    protected void onResume() {
        super.onResume();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        firebaseAuth.removeAuthStateListener(authStateListener);
    }
}
