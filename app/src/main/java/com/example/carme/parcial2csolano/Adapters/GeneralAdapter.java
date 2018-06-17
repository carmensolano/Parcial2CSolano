package com.example.carme.parcial2csolano.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carme.parcial2csolano.Pojo.News;
import com.example.carme.parcial2csolano.R;

import java.util.ArrayList;

public class GeneralAdapter extends RecyclerView.Adapter<GeneralAdapter.GeneralViewHolder> {

    ArrayList<News> generalsList;

    public GeneralAdapter(ArrayList<News> generalsList){
        this.generalsList = generalsList;
    }



    @Override
    public GeneralViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_cardview,null, false);

        return new GeneralAdapter.GeneralViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GeneralViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return generalsList.size();
    }


    public class GeneralViewHolder extends RecyclerView.ViewHolder {

        TextView GeneralTitle, DescGeneral;
        ImageView GeneralImage, FavoriteGeneral;

        public GeneralViewHolder(View itemView) {
            super(itemView);

            GeneralTitle = itemView.findViewById(R.id.newsTitle);
            DescGeneral = itemView.findViewById(R.id.newsBody);
            GeneralImage = itemView.findViewById(R.id.newsImage);
            FavoriteGeneral = itemView.findViewById(R.id.favIcon);
        }
    }
}
