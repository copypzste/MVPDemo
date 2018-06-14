package com.example.windows10.mvpdemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.windows10.mvpdemo.Model.Data;
import com.example.windows10.mvpdemo.Home.IHomePresenter;
import com.example.windows10.mvpdemo.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {

    private List<Data> datas;
    private IHomePresenter homePresenter;
    private Context mContext;

    public DataAdapter(Context context, List<Data> data,IHomePresenter homePresenter) {
        this.homePresenter = homePresenter;
        mContext = context;
        this.datas = data;
    }

    public void setDatas(List<Data> data) {
        this.datas = data;
        notifyDataSetChanged();
    }
    public Data getData(int position){
        return datas.get(position);
    }
    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {
        final Data item = datas.get(position);
        holder.data = item;
        holder.title.setText(item.getTitleData());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePresenter.onDataItemClicked(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(datas == null) {
            return 0;
        }else {
            return  datas.size();
        }
    }

    static class DataHolder extends RecyclerView.ViewHolder {
        public Data data;
        public TextView title;

        DataHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
        }
    }
}
