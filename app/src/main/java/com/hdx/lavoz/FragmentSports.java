package com.hdx.lavoz;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FragmentSports extends Fragment{

    View view;
    private RecyclerView recyclerView;
    private ArrayList<NewsModel> newsModels;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;
    private ChildEventListener mChildEventListener;

    public FragmentSports() {
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = view.findViewById(R.id.fragment_news_rv);

        NewsAdapter newsAdapter = new NewsAdapter(getContext(), newsModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(newsAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("sports");

        newsModels = new ArrayList<>();

//        databaseReference.addChildEventListener(childEventListener);
//        int limit = 100;
//
//        for (int i = 0; i < limit; i++){
//            newsModels.add(new NewsModel("User " +i,
//                    "Title place holder " + i,
//                    "DD/MM/YY" + i,
//                    "" + i,
//                    "blablablabalbalbalablablablablablablabalblablablablabalbalba" +i,
//                    R.drawable.bokuportada));
//        }
    }
}
