package com.example.windows10.mvpdemo.Home;

import com.example.windows10.mvpdemo.Model.Data;

import java.util.List;

public interface IHomeView {
    void showTitle(String title);
    void showAlldata(List<Data> list_data);
    void showUsername(String username);
    void navigateToDataPage(Data data);
}
