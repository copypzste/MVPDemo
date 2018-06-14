package com.example.windows10.mvpdemo.Model;

import android.text.TextUtils;

public class User implements IUser {
    private String username,password;
    public User(String username,String password){
        this.username = username;
        this.password = password;
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        if(TextUtils.isEmpty(getUsername())||TextUtils.isEmpty(getPassword()))
            return 0;
        else
            return 1;
    }


}
