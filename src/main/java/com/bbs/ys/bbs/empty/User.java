package com.bbs.ys.bbs.empty;

//用户表-sql-user

public class User {
    private  int id;
    private  String nickname;
    private  String tel;
    private  String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", nickname=" + nickname + ", tel=" + tel + ", password=" + password + "]";
    }

}

