package com.example.windows10.mvpdemo.Login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.windows10.mvpdemo.R;
import com.example.windows10.mvpdemo.Home.HomeActivity;

public class MainActivity extends AppCompatActivity implements ILoginView {
    private EditText editUsername,editPassword;
    private Button btnLogin;
    private ILoginPresenter loginPresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, HomeActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(editUsername.getText().toString(),editPassword.getText().toString());
            }
        });
    }
    public void init(){
        editUsername = findViewById(R.id.edit_username);
        editPassword = findViewById(R.id.edit_password);
        btnLogin = findViewById(R.id.btn_login);
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onLoginResult(String msg) {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
}

    @Override
    public void openHomeActivity() {
        HomeActivity.start(MainActivity.this,editUsername.getText().toString());
    }
}
