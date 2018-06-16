package com.example.carme.parcial2csolano.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carme.parcial2csolano.Adapters.NewsAdapter;
import com.example.carme.parcial2csolano.Pojo.News;
import com.example.carme.parcial2csolano.R;
import com.example.carme.parcial2csolano.Remote.UserService;

import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NewsFragment extends Fragment {
    private View view;
    private UserService userService;
    private String baseUrl;
    private Retrofit retrofit;
    private Call<List<News>> call;
    private List<News> auxiliarList = null;
    private List<News> listOfNews;
    private RecyclerView recyclerViewNews;

    private String title;
    private String body;
    private String game;
    private String coverImage;
    private String description;
    private String created_date;


    public NewsFragment(){}


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_news, container,false);

        loadNews(view);

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void loadNews(final View v){

        baseUrl = "http://gamenewsuca.herokuapp.com/";

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        userService = retrofit.create(UserService.class);

        call = userService.getNewsRequest("Bearer");

        call.enqueue(new Callback<List<News>>(){
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response){
                auxiliarList = response.body();
                listOfNews = new ArrayList<>();

                for(int i=0;i<auxiliarList.size();i++){

                    if(auxiliarList.get(i).getTitle() == null){ title = "Noticia sin titulo";}
                    else{ title = auxiliarList.get(i).getTitle(); }

                    if(auxiliarList.get(i).getBody() == null){ body = "Noticia sin cuerpo";}
                    else{ body = auxiliarList.get(i).getBody(); }

                    if(auxiliarList.get(i).getGame() == null){ game = "Noticia sin juego";}
                    else{ game = auxiliarList.get(i).getGame(); }

                    if(auxiliarList.get(i).getCoverImage() == null){ coverImage = "Noticia sin imagen";}
                    else{ coverImage = auxiliarList.get(i).getCoverImage(); }

                    if(auxiliarList.get(i).getDescription() == null){ description = "Noticia sin descripcion";}
                    else{ description = auxiliarList.get(i).getDescription(); }

                    if(auxiliarList.get(i).getCreated_date() == null){ created_date = "Noticia sin fecha de creacion";}
                    else{ created_date = auxiliarList.get(i).getCreated_date(); }

                    listOfNews.add(new News(auxiliarList.get(i).get_id()
                            ,title
                            ,body
                            ,game
                            ,coverImage
                            ,description
                            ,created_date
                            ,auxiliarList.get(i).get_v()));
                }

                recyclerViewNews = (RecyclerView) v.findViewById(R.id.recycler_news);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
                    @Override
                    public int getSpanSize(int position) {

                        if ( position%3 == 0) {
                            return 2;
                        } else {
                            return 1;
                        }
                    }
                });

                recyclerViewNews.setLayoutManager(gridLayoutManager);
                NewsAdapter adapter= new NewsAdapter(listOfNews);
                recyclerViewNews.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
            }
        });
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}

