package com.example.kiranapaulina.moneymaw1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kiranapaulina.moneymaw1.adapter.listener.CountryCallBack;
import com.example.kiranapaulina.moneymaw1.adapter.viewholder.CountryViewHolder;
import com.example.kiranapaulina.moneymaw1.model.CountryModel;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<CountryModel> data = new ArrayList<>();
    CountryCallBack listener;

    public CountryAdapter(Context context, ArrayList<CountryModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(com.example.kiranapaulina.moneymaw1.R.layout.custom_converter, parent, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        return new CountryViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CountryViewHolder){
            ((CountryViewHolder) holder).setUpToUI(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void onSelectedCountry(CountryCallBack listener){
        this.listener = listener;
    }
}

