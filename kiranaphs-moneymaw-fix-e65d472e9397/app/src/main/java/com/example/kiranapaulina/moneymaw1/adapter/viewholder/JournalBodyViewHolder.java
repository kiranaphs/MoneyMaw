package com.example.kiranapaulina.moneymaw1.adapter.viewholder;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kiranapaulina.moneymaw1.R;
import com.example.kiranapaulina.moneymaw1.adapter.listener.DataCallBack;
import com.example.kiranapaulina.moneymaw1.helper.Helper;
import com.example.kiranapaulina.moneymaw1.model.JournalModel;

public class JournalBodyViewHolder extends RecyclerView.ViewHolder {

    View view;
    TextView total;
    TextView date;
    ImageView image;
    RelativeLayout wrapperLayout;
    DataCallBack listener;

    public JournalBodyViewHolder (View view, DataCallBack listener)
    {
        super(view);
        this.view = view;
        this.listener = listener;
        total= view.findViewById(R.id.custom_content_journal_text_money);
        date= view.findViewById(R.id.custom_content_journal_date);
        image= view.findViewById(R.id.custom_content_journal_image_income);
        wrapperLayout = view.findViewById(R.id.custom_content_journal_relativelayout);
    }

    public void setUpToUI(final JournalModel data) {
        total.setText(Helper.convertToIDR(data.getMoney()));
        date.setText(Helper.getDateMonth(data.getDate()));
        if (data.isIncome()) {
            image.setImageResource(R.drawable.ic_logoincome);
        }else {
            image.setImageResource(R.drawable.ic_logoexcome);
        }

        wrapperLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClicked(data);
            }
        });
    }
}
