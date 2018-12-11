package com.example.kiranapaulina.moneymaw1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kiranapaulina.moneymaw1.R;
import com.example.kiranapaulina.moneymaw1.adapter.listener.DataCallBack;
import com.example.kiranapaulina.moneymaw1.adapter.viewholder.JournalBodyViewHolder;
import com.example.kiranapaulina.moneymaw1.adapter.viewholder.JournalDateHeaderViewHolder;
import com.example.kiranapaulina.moneymaw1.adapter.viewholder.JournalHeaderViewHolder;
import com.example.kiranapaulina.moneymaw1.helper.Constant;
import com.example.kiranapaulina.moneymaw1.model.DateModel;
import com.example.kiranapaulina.moneymaw1.model.GeneralModel;
import com.example.kiranapaulina.moneymaw1.model.JournalModel;
import com.example.kiranapaulina.moneymaw1.model.ListItem;
import com.example.kiranapaulina.moneymaw1.model.SaldoModel;

import java.util.ArrayList;

public class JournalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    SaldoModel amount;
    ArrayList<ListItem> data = new ArrayList<>();
    DataCallBack listener;

    public JournalAdapter(Context context, SaldoModel amount, ArrayList<ListItem> data) {
        this.context = context;
        this.amount = amount;
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return Constant.HEADER;
        } else {
            return data.get(position-1).getType();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof JournalHeaderViewHolder){
            ((JournalHeaderViewHolder) viewHolder).setUpToUI(amount);
        }else if (viewHolder instanceof JournalDateHeaderViewHolder){
            DateModel date = (DateModel) data.get(i-1);
            ((JournalDateHeaderViewHolder) viewHolder).setUpToUI(date.getDate());
        }else if (viewHolder instanceof JournalBodyViewHolder){
            GeneralModel generalModel = (GeneralModel) data.get(i-1);
            ((JournalBodyViewHolder) viewHolder).setUpToUI(generalModel.getJournalModel());
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        if (i == Constant.HEADER){
            view = LayoutInflater.from(context).inflate(R.layout.custom_journal_header, viewGroup, false);
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(params);
            return new JournalHeaderViewHolder(view);
        }else if (i == ListItem.TYPE_DATE){
            view = LayoutInflater.from(context).inflate(R.layout.custom_date_journal_header, viewGroup, false);
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(params);
            return new JournalDateHeaderViewHolder(view);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.custom_content_journal, viewGroup, false);
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(params);
            return new JournalBodyViewHolder(view, listener);
        }
    }

    @Override
    public int getItemCount() {
        return 1+data.size();
    }

    public void onDataClicked(DataCallBack listener){
        this.listener = listener;
    }
}
