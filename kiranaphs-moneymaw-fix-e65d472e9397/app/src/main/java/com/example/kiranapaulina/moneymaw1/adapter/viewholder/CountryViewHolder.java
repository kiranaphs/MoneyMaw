package com.example.kiranapaulina.moneymaw1.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kiranapaulina.moneymaw1.adapter.listener.CountryCallBack;
import com.example.kiranapaulina.moneymaw1.model.CountryModel;

public class CountryViewHolder extends RecyclerView.ViewHolder {

    View view;
    TextView tvmoney;
    CountryCallBack listener;

    public CountryViewHolder(View view, CountryCallBack listener){
        super(view);
        this.view = view;
        this.listener = listener;
        tvmoney = view.findViewById(com.example.kiranapaulina.moneymaw1.R.id.custom_converter_text);
    }

    public void setUpToUI(final CountryModel data){
        tvmoney.setText(data.getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCountryCallBack(data);
            }
        });
    }
}
