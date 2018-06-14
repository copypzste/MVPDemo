package com.example.windows10.mvpdemo.Login;

import com.example.windows10.mvpdemo.Login.ILoginPresenter;
import com.example.windows10.mvpdemo.Model.User;
import com.example.windows10.mvpdemo.Login.ILoginView;

public class LoginPresenter implements ILoginPresenter {
    private ILoginView loginView;
    public LoginPresenter(ILoginView loginView){
        this.loginView = loginView;
    }
    @Override
    public void onLogin(String username, String password) {
        User user = new User(username,password);
        int isLogin= user.isValidData();
        if(isLogin == 0){
            loginView.onLoginResult("Text is Empty..");
        }
        else if(isLogin == 1){
            loginView.onLoginResult("Login Success!!");
            loginView.openHomeActivity();
        }
        else
            loginView.onLoginResult("Login Error.");
    }
}
