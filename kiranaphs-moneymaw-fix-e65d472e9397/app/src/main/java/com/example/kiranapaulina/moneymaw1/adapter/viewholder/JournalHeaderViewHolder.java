package com.example.kiranapaulina.moneymaw1.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kiranapaulina.moneymaw1.R;
import com.example.kiranapaulina.moneymaw1.helper.Helper;
import com.example.kiranapaulina.moneymaw1.model.JournalModel;
import com.example.kiranapaulina.moneymaw1.model.SaldoModel;

public class JournalHeaderViewHolder extends RecyclerView.ViewHolder {

    View view;
    TextView total;

    public JournalHeaderViewHolder (View view)
    {
        super(view);
        this.view =  view;
        total= view.findViewById(R.id.custom_journal_header);
    }

    public void setUpToUI(SaldoModel amount) {
        total.setText(Helper.convertToIDR(amount.getSaldo()));
    }
}
