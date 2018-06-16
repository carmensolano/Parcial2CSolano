package com.example.carme.parcial2csolano.Pojo;

public class User {

    private String _id;
    private String user;
    private String password;
    private String created_date;
    private String avatar;
    private int _v;



    public User(String user, String password, String created_date, String avatar, int _v){
        this.user = user;
        this.password = password;
        this.created_date = created_date;
        this.avatar = avatar;
        this._v = _v;
    }

    public User (){}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int get_v() {
        return _v;
    }

    public void set_v(int _v) {
        this._v = _v;
    }
}
