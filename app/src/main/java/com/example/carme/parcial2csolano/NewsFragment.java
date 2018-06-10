package com.example.carme.parcial2csolano;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class NewsFragment extends Fragment {

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    RecyclerView recyclerViewNews;
    public NewsFragment() { }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_news, container, false);
        recyclerViewNews= (RecyclerView)view.findViewById(R.id.recycler_news);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }


    private class RecyclerAdapter extends RecyclerView.Adapter<GridHolder>{

        Bitmap[] bitmaps;

        public RecyclerAdapter(Bitmap[] bitmaps){
            this.bitmaps = bitmaps(bitmaps);
        }


        @Override
        public GridHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(NewsFragment.this).inflate(R.layout.news, parent, false);

            return new GridHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull GridHolder holder, int position) {
            holder.imageView.setImageBitmap(bitmaps[position]);
            holder.textView.setText("NewsTitle" + position);
            holder.textView1.setText("NewsBody"+ position);

        }

        @Override
        public int getItemCount() {
            return bitmaps.length;
        }
    }


    private class GridHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        TextView textView1;

        public GridHolder(View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.newsImage);
            textView= itemView.findViewById(R.id.newsTitle);
            textView1= itemView.findViewById(R.id.newsBody);
        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
