package com.example.windows10.mvpdemo.DataDetail;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.windows10.mvpdemo.R;

public class DataDetailActivity extends AppCompatActivity implements IDataDetailView {
    private SharedPreferences sharedPreferences;
    private IDataDetailPresenter dataDetailPresenter;
    private static final String KEY_TITLE_DATA = "TITLE_DATA";
    private static final String KEY_DETAIL_DATA = "DETAIL_DATA";
    private TextView tvTitle,tvDetail;
    public static void start(Context context,String title_data,String detail_data) {
        Intent starter = new Intent(context, DataDetailActivity.class);
        starter.putExtra(KEY_TITLE_DATA,title_data);
        starter.putExtra(KEY_DETAIL_DATA,detail_data);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        init();
        dataDetailPresenter.getData();

    }
    public void init(){
        tvTitle = findViewById(R.id.tvTitle);
        tvDetail = findViewById(R.id.tvDetail);
        dataDetailPresenter = new DataDetailPresenter(this
                ,getIntent().getStringExtra(KEY_TITLE_DATA)
                ,getIntent().getStringExtra(KEY_DETAIL_DATA));
    }

    @Override
    public void showTitle(String title) {
        setTitle(title);
    }

    @Override
    public void showDetail(String detail) {
        tvDetail.setText(detail);
    }

    @Override
    public void shownTitleData(String title_data) {
        tvTitle.setText(title_data);
    }
}
