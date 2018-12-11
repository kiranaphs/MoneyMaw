package com.example.kiranapaulina.moneymaw1.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kiranapaulina.moneymaw1.R;

public class JournalDateHeaderViewHolder extends RecyclerView.ViewHolder {

    TextView tvDate;
    View view;

    public JournalDateHeaderViewHolder(View view){
        super(view);
        tvDate = view.findViewById(R.id.custom_date_joutnal_header_date);
    }

    public void setUpToUI(String date){
        tvDate.setText(date+"");
    }
}
