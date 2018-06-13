package com.hdx.lavoz;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentInternational extends Fragment{

    View view;
    private RecyclerView recyclerView;
    private ArrayList<NewsModel> newsModels;

    public FragmentInternational() {
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_international, container, false);
        recyclerView = view.findViewById(R.id.fragment_international_rv);
        NewsAdapter newsAdapter = new NewsAdapter(getContext(), newsModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(newsAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        newsModels = new ArrayList<>();

        int limit = 5;

        for (int i = 0; i < limit; i++){
            newsModels.add(new NewsModel("User International " +i,
                    "Title place holder " + i,
                    "DD/MM/YY" + i,
                    "" + i,
                    "blablablabalbalbalablablablablablablabalblablablablabalbalba" +i,
                    R.drawable.bokuportada));
        }
    }
}
