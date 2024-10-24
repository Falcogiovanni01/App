package com.example.gym;

import java.util.Objects;

public class LoginUser {
    private String username ;
    private String password;

    public  LoginUser(String u , String p){
        username=u ;
        password=p ;
    }
    public void setUsername(String u){
        username=u ;
    }
    public String getUsername(){
        return username ;
    }
    public void setPassword(String u){
        password=u ;
    }
    public String getPassword(){
        return   password ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginUser loginUser = (LoginUser) o;
        return username.equals(loginUser.username) && password.equals(loginUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }


}
