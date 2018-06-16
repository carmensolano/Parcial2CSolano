package com.example.carme.parcial2csolano.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carme.parcial2csolano.Pojo.News;
import com.example.carme.parcial2csolano.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    List<News> newsList;
    Context context;
    String[] auxDate, auxDateSort;
    String aux;

    public NewsAdapter(List<News> newsList){
        this.newsList = newsList;
    }


    @Override
    public NewsViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.news_cardview, null, false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        holder.TitleNew.setText(newsList.get(position).getTitle());
        holder.DescNew.setText(newsList.get(position).getDescription());
        holder.GameNew.setText(newsList.get(position).getBody());
        holder.DateNew.setText(newsList.get(position).getCreated_date());

        if(newsList.get(position).getCoverImage() != "Noticia sin imagen"){
            Picasso.with(context).load(newsList.get(position).getCoverImage()).into(holder.ImageNew);
        }

    }

    private String getDateConverted(int position){
        auxDate = newsList.get(position).getCreated_date().split("T");
        auxDateSort = auxDate[0].split("-");
        aux = auxDateSort[0];
        auxDateSort[0] =auxDateSort[2];
        auxDateSort[2] =aux;
        aux = auxDateSort[0]+"-"+auxDateSort[1]+"-"+auxDateSort[2];
        return aux;

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        //TODO inicializar los controles del news_card

        TextView TitleNew, DescNew, GameNew, DateNew;
        ImageView ImageNew, FavoriteNew;

        public NewsViewHolder(View itemView) {
            super(itemView);
            auxDate = new String[2];
            auxDateSort = new String[3];
            TitleNew = itemView.findViewById(R.id.newsTitle);
           // DescNew = itemView.findViewById(R.id.newsBody);
            ImageNew = itemView.findViewById(R.id.newsImage);
            FavoriteNew = itemView.findViewById(R.id.favIcon);
            GameNew = itemView.findViewById(R.id.newsBody);
            //DateNew = itemView.findViewById(R.id.);
        }
    }
}

