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

public class FragmentSports extends Fragment{

    View view;
    private RecyclerView recyclerView;
    private ArrayList<NewsModel> newsModelsSport;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_sports, container, false);
        recyclerView = view.findViewById(R.id.fragment_sports_rv);
        NewsAdapter newsAdapter = new NewsAdapter(getContext(), newsModelsSport);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(newsAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        newsModelsSport = new ArrayList<>();

        int limit = 10;

        for (int i = 0; i < limit; i++){
            newsModelsSport.add(new NewsModel("User sport " +i,
                    "Title place sport " + i,
                    "DD/MM/YY" + i,
                    "" + i,
                    "blablablabalbalbalablablablablablablabalblablablablabalbalba" +i,
                    R.drawable.bokuportada));
        }
    }
}
