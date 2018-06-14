package com.example.windows10.mvpdemo.Home;

import com.example.windows10.mvpdemo.Model.Data;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter implements IHomePresenter {
    private IHomeView homeView;
    private String username;

    public HomePresenter(IHomeView homeView,String username){
        this.homeView = homeView;
        this.username = username;
        this.homeView.showTitle("All Data");
        this.homeView.showUsername("Welcome "+username);

    }
    @Override
    public void getAllData() {
        List<Data> datas = new ArrayList<Data>();
        for(int i = 0;i<5;i++){
            datas.add(i,new Data("Data"+i,"Hello Data "+i,i));
        }
        homeView.showAlldata(datas);
    }

    @Override
    public void onDataItemClicked(Data data) {
        homeView.navigateToDataPage(data);
    }
}
