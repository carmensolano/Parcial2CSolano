package com.example.carme.parcial2csolano.Remote;

public class APIutils {
    public static final String BASE_URL = "http://gamenewsuca.herokuapp.com/";

    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
