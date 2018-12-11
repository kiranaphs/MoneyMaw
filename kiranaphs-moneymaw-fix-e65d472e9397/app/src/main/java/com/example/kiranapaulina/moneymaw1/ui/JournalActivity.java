package com.example.kiranapaulina.moneymaw1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiranapaulina.moneymaw1.R;
import com.example.kiranapaulina.moneymaw1.adapter.JournalAdapter;
import com.example.kiranapaulina.moneymaw1.adapter.listener.DataCallBack;
import com.example.kiranapaulina.moneymaw1.helper.Constant;
import com.example.kiranapaulina.moneymaw1.helper.Helper;
import com.example.kiranapaulina.moneymaw1.model.DateModel;
import com.example.kiranapaulina.moneymaw1.model.GeneralModel;
import com.example.kiranapaulina.moneymaw1.model.JournalModel;
import com.example.kiranapaulina.moneymaw1.model.ListItem;
import com.example.kiranapaulina.moneymaw1.model.SaldoModel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class JournalActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView listjournal;
    JournalAdapter adapter;
    ImageView ivCounverter;
    ArrayList<JournalModel> data = new ArrayList<>();
    boolean isIncome;
    double amount;
    SaldoModel saldoModel = new SaldoModel();
    ArrayList<ListItem> listItems = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        getSupportActionBar().hide();
        saldoModel.setSaldo(200000);
        ivCounverter = findViewById(R.id.journal_converter);
        floatingActionButton = findViewById(R.id.activity_journal_fab);
        listjournal = findViewById(R.id.listjournal);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView();
            }
        });
        setAdapter();
        onClickedCounverter();
    }

    private void onClickedCounverter(){
        ivCounverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JournalActivity.this, ConverterActivity.class));
            }
        });
    }

    private void setAdapter(){
        adapter = new JournalAdapter(this, saldoModel, listItems);

        adapter.onDataClicked(new DataCallBack() {
            @Override
            public void onClicked(JournalModel data) {
                Intent in = new Intent(JournalActivity.this, DetailJouralActivity.class);
                in.putExtra(Constant.KEY_DATA, data);
                startActivity(in);
            }
        });

        listjournal.setItemAnimator(new DefaultItemAnimator());
        listjournal.setLayoutManager(new LinearLayoutManager(this));
        listjournal.setAdapter(adapter);
    }

    public void dialogView(){
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_app_journal, null);
        alertDialog.setView(view);

        final EditText etAmout = view.findViewById(R.id.dialog_app_journal_text_jumlah_uang);
        final Spinner spinner = view.findViewById(R.id.dialog_app_journal_spinner);
        final EditText etDeskripsi = view.findViewById(R.id.dialog_app_journal_edittext_deskripsi);
        final TextView save = view.findViewById(R.id.dialog_app_journal_save);

        etAmout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if(count != 0) {
                        etAmout.removeTextChangedListener(this);
                        String cleanString = s.toString().replaceAll("[Rp,.]", "");
                        double parsed = Double.parseDouble(cleanString);
                        Locale localeID = new Locale("in", "ID");
                        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                        String formatted = formatRupiah.format((parsed));
                        etAmout.setText(formatted);
                        etAmout.setSelection(formatted.length());
                        etAmout.addTextChangedListener(this);
                        amount = Double.parseDouble(cleanString);
                    }
                }catch (Exception e){

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItemPosition() != 0){
                    if (spinner.getSelectedItemPosition() == 1){
                        isIncome = true;
                        if (amount > saldoModel.getSaldo()){
                            Toast.makeText(JournalActivity.this, "Saldo kurang", Toast.LENGTH_LONG).show();
                        }else {
                            saldoModel.setSaldo(saldoModel.getSaldo()-amount);
                            if (data.size()>1){
                                data.add(0, new JournalModel(data.get(data.size()-1).getId() + 1, amount,
                                        System.currentTimeMillis(), isIncome, etDeskripsi.getText().toString()));
                                saldoModel.setSaldo(saldoModel.getSaldo());
                            }else {
                                data.add(0, new JournalModel(1, amount,
                                        System.currentTimeMillis(), isIncome, etDeskripsi.getText().toString()));
                                saldoModel.setSaldo(saldoModel.getSaldo());
                            }
                            alertDialog.dismiss();
                            notifyAdapter();
                        }
                    }else {
                        isIncome = false;
                        saldoModel.setSaldo(saldoModel.getSaldo()+amount);
                        if (data.size()>1){
                            data.add(0, new JournalModel(data.get(data.size()-1).getId() + 1, amount,
                                    System.currentTimeMillis(), isIncome, etDeskripsi.getText().toString()));
                            saldoModel.setSaldo(saldoModel.getSaldo());
                        }else {
                            data.add(0, new JournalModel(1, amount,
                                    System.currentTimeMillis(), isIncome, etDeskripsi.getText().toString()));
                            saldoModel.setSaldo(saldoModel.getSaldo());
                        }
                        alertDialog.dismiss();
                        notifyAdapter();
                    }
                }else {
                    Toast.makeText(JournalActivity.this, "Harap pilih pemasukkan atau pengeluaran.", Toast.LENGTH_LONG).show();
                }
            }
        });

        alertDialog.show();
        alertDialog.setCancelable(true);
    }


    private HashMap<String, ArrayList<JournalModel>> groupDataIntoHashMap(ArrayList<JournalModel> data){
        HashMap<String, ArrayList<JournalModel>> groupedHashMap = new HashMap<>();
        ArrayList<JournalModel> journalList = new ArrayList<>();
        for (JournalModel journalModel: data){
            String hashMapKey = Helper.convertDateToString(new Date(journalModel.getDate()));
            if (groupedHashMap.containsKey(hashMapKey)){
                groupedHashMap.get(hashMapKey).add(journalModel);
            }else {
                journalList.add(journalModel);
                groupedHashMap.put(hashMapKey, journalList);
            }
        }
        return groupedHashMap;
    }

    private void notifyAdapter(){
        listItems.clear();
        HashMap<String, ArrayList<JournalModel>> groupedHasMap = groupDataIntoHashMap(data);
        for (String date: groupedHasMap.keySet()){
            DateModel dateItem = new DateModel();
            dateItem.setDate(date);
            listItems.add(dateItem);

            for (JournalModel journalModel: groupedHasMap.get(date)){
                GeneralModel generalModel = new GeneralModel();
                generalModel.setJournalModel(journalModel);
                listItems.add(generalModel);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
