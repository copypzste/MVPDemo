package com.example.windows10.mvpdemo.Presenter;

import com.example.windows10.mvpdemo.Model.Data;

public interface IHomePresenter {
    void getAllData();
    void onDataItemClicked(Data data);
}
