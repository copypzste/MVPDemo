package com.example.windows10.mvpdemo.DataDetail;

import com.example.windows10.mvpdemo.Home.IHomePresenter;


public class DataDetailPresenter implements IDataDetailPresenter {
    private IDataDetailView dataDetailView;
    private IHomePresenter homePresenter;
    private String title,detail;
    public DataDetailPresenter(IDataDetailView dataDetailView,String title,String detail){
        this.title = title;
        this.detail = detail;
        this.dataDetailView = dataDetailView;
    }

    @Override
    public void getData() {
        dataDetailView.shownTitleData(title);
        dataDetailView.showTitle(title);
        dataDetailView.showDetail(detail);
    }
}
