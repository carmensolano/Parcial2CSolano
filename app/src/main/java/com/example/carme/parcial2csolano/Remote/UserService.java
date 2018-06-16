package com.example.carme.parcial2csolano.Remote;

import android.media.session.MediaSession;

import com.example.carme.parcial2csolano.Pojo.News;
import com.example.carme.parcial2csolano.Pojo.TopPlayers;
import com.example.carme.parcial2csolano.Pojo.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @FormUrlEncoded
    @POST("login")
    Call<MediaSession.Token> loginRequest (@Field("user") String username, @Field("password") String password);

    @GET("news")
    Call<List<News>> getNewsRequest (@Header("Autorization") String token);

    @GET("players")
    Call<List<TopPlayers>> getPlayersRequest(@Header("Autorization") String token);
}
