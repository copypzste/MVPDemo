package com.example.windows10.mvpdemo.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.windows10.mvpdemo.Adapter.DataAdapter;
import com.example.windows10.mvpdemo.Model.Data;
import com.example.windows10.mvpdemo.Presenter.HomePresenter;
import com.example.windows10.mvpdemo.Presenter.IDataDetailPresenter;
import com.example.windows10.mvpdemo.Presenter.IHomePresenter;
import com.example.windows10.mvpdemo.R;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements IHomeView{
    private TextView tv_username;
    private DataAdapter dataAdapter;
    private RecyclerView recyclerView;
    private IHomePresenter homePresenter;
    private static final String KEY_USER_NAME = "USER_NAME";

    public static void start(Context context, String username) {
        Intent starter = new Intent(context, HomeActivity.class);
        starter.putExtra(KEY_USER_NAME,username);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dataAdapter);
        homePresenter.getAllData();
//        tv_username.setText("Welcome "+getIntent().getStringExtra(KEY_USER_NAME));
    }
    public void init(){
        tv_username = findViewById(R.id.tvUsername);
        recyclerView = findViewById(R.id.rvData);
        homePresenter = new HomePresenter(this,getIntent().getStringExtra(KEY_USER_NAME));
        dataAdapter = new DataAdapter(HomeActivity.this,null,homePresenter);

    }

    @Override
    public void showTitle(String title) {
        setTitle(title);
    }

    @Override
    public void showAlldata(List<Data> list_data) {
        dataAdapter.setDatas(list_data);
    }

    @Override
    public void showUsername(String username) {
        tv_username.setText(username);
    }

    @Override
    public void navigateToDataPage(Data data) {
       DataDetailActivity.start(HomeActivity.this,data.getTitleData(),data.getDetailData());
    }
}
