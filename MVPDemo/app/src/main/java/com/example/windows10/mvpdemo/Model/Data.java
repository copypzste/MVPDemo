package com.example.windows10.mvpdemo.Model;

public class Data{
    private String title,detail;
    private int id;
    public Data(String title,String detail,int id){
        this.id = id;
        this.title = title;
        this.detail = detail;
    }
    public String getTitleData() {
        return title;
    }
    public String getDetailData() {
        return detail;
    }
    public int getIdData() {
        return id;
    }
}
