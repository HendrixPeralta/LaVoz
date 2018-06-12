package com.hdx.lavoz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHOlder>{

    private Context mContext;
    private ArrayList<NewsModel> mNewsModels;

    public NewsAdapter(Context mContext, ArrayList<NewsModel> mNewsModels) {
        this.mContext = mContext;
        this.mNewsModels = mNewsModels;
    }

    @NonNull
    @Override
    public ViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.post_cardview, parent, false);
        return new ViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHOlder holder, int position) {

        holder.itemTitle.setText(mNewsModels.get(position).getmPostTitle());
        holder.itemDate.setText(mNewsModels.get(position).getmPostDate());
        holder.itemImage.setImageResource(mNewsModels.get(position).getmPostImage());
        holder.itemUserName.setText(mNewsModels.get(position).getmUserName());
        holder.itemDescription.setText(mNewsModels.get(position).getmPostdescription());
    }

    @Override
    public int getItemCount() {
        return mNewsModels.size();
    }

    public class ViewHOlder extends  RecyclerView.ViewHolder{

        private TextView itemTitle, itemDate, itemCategory, itemUserName, itemDescription;
        private ImageView itemImage;

        public ViewHOlder(View itemView) {
            super(itemView);

            itemTitle = itemView.findViewById(R.id.post_title);
            itemDate = itemView.findViewById(R.id.post_date);
            itemCategory = itemView.findViewById(R.id.post_category);
            itemUserName = itemView.findViewById(R.id.post_user_name);
            itemDescription = itemView.findViewById(R.id.post_description);
            itemImage = itemView.findViewById(R.id.post_image);
        }
    }
}
