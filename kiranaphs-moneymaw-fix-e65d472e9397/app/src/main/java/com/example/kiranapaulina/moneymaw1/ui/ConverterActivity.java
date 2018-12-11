package com.example.kiranapaulina.moneymaw1.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kiranapaulina.moneymaw1.adapter.CountryAdapter;
import com.example.kiranapaulina.moneymaw1.adapter.listener.CountryCallBack;
import com.example.kiranapaulina.moneymaw1.helper.Constant;
import com.example.kiranapaulina.moneymaw1.model.CountryModel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ConverterActivity extends AppCompatActivity {

    TextView tv1;
    EditText et1;
    TextView tv2;
    EditText et2;
    CountryAdapter adapter;
    ArrayList<CountryModel> data = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.kiranapaulina.moneymaw1.R.layout.activity_converter);
        tv1 = findViewById(com.example.kiranapaulina.moneymaw1.R.id.converter_tv1);
        et1 = findViewById(com.example.kiranapaulina.moneymaw1.R.id.converter_et1);
        tv2 = findViewById(com.example.kiranapaulina.moneymaw1.R.id.converter_tv2);
        et2 = findViewById(com.example.kiranapaulina.moneymaw1.R.id.converter_et2);
        ontv2Clicked();
        onEt1Change();
        onConvertSDG();
        onConvertBAHT();
        onConvertRG();

    }

    private void ontv2Clicked(){
        tv1.setText("IDR");
        tv2.setText("USD");
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCountry();
            }
        });
    }

    private void onEt1Change(){
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et1.hasFocus()){
                    if (tv2.getText().toString().equalsIgnoreCase("USD")){
                        if (count!=0){
                            et1.removeTextChangedListener(this);
                            String cleanString = s.toString().replaceAll("[Rp,.]", "");
                            double parsed = Double.parseDouble(cleanString);
                            Locale localeID = new Locale("in", "ID");
                            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                            String formatted = formatRupiah.format((parsed));
                            et1.setText(formatted);
                            et1.setSelection(formatted.length());
                            et1.addTextChangedListener(this);

                            double total = Double.parseDouble(cleanString) / Constant.IDRTOUSD;
                            String totalString = total+"";

                            et2.removeTextChangedListener(this);
                            String usdString = totalString.replaceAll("[$,.]", "");
                            Locale localeEN = new Locale("en", "US");
                            String formattedEN = NumberFormat.getCurrencyInstance(localeEN).format((Double.parseDouble(usdString)/10));
                            et2.setText(formattedEN);
                            et2.setSelection(formattedEN.length());
                            et2.addTextChangedListener(this);
                        }
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et2.hasFocus()){
                    if (tv2.getText().toString().equalsIgnoreCase("USD")){
                        if (count!=0){
                            et2.removeTextChangedListener(this);
                            String usdString = s.toString().replaceAll("[$,.]", "");
                            Locale localeEN = new Locale("en", "US");
                            String formattedEN = NumberFormat.getCurrencyInstance(localeEN).format((Double.parseDouble(usdString)));
                            et2.setText(formattedEN);
                            et2.setSelection(formattedEN.length());
                            et2.addTextChangedListener(this);

                            double total = Double.parseDouble(usdString) * Constant.IDRTOUSD;
                            String totalString = total+"";

                            et1.removeTextChangedListener(this);
                            String cleanString = totalString.replaceAll("[Rp,.]", "");
                            double parsed = Double.parseDouble(cleanString);
                            Locale localeID = new Locale("in", "ID");
                            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                            String formatted = formatRupiah.format((parsed)/10);
                            et1.setText(formatted);
                            et1.setSelection(formatted.length());
                            et1.addTextChangedListener(this);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void onConvertSDG(){
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et1.hasFocus()){
                    if (tv2.getText().toString().equalsIgnoreCase("SGD")){
                        if (count!=0){
                            et1.removeTextChangedListener(this);
                            String cleanString = s.toString().replaceAll("[Rp,.]", "");
                            double parsed = Double.parseDouble(cleanString);
                            Locale localeID = new Locale("in", "ID");
                            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                            String formatted = formatRupiah.format((parsed));
                            et1.setText(formatted);
                            et1.setSelection(formatted.length());
                            et1.addTextChangedListener(this);

                            double total = Double.parseDouble(cleanString) / Constant.IDRTOSGD;
                            String totalString = total+"";

                            et2.removeTextChangedListener(this);
                            String usdString = totalString.replaceAll("[$,.]", "");
                            Locale localeEN = new Locale("en", "SG");
                            String formattedEN = NumberFormat.getCurrencyInstance(localeEN).format((Double.parseDouble(usdString)/10));
                            et2.setText(formattedEN);
                            et2.setSelection(formattedEN.length());
                            et2.addTextChangedListener(this);
                        }
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et2.hasFocus()){
                    if (tv2.getText().toString().equalsIgnoreCase("SGD")){
                        if (count!=0){
                            et2.removeTextChangedListener(this);
                            String usdString = s.toString().replaceAll("[$,.]", "");
                            Locale localeEN = new Locale("en", "SG");
                            String formattedEN = NumberFormat.getCurrencyInstance(localeEN).format((Double.parseDouble(usdString)));
                            et2.setText(formattedEN);
                            et2.setSelection(formattedEN.length());
                            et2.addTextChangedListener(this);

                            double total = Double.parseDouble(usdString) * Constant.IDRTOSGD;
                            String totalString = total+"";

                            et1.removeTextChangedListener(this);
                            String cleanString = totalString.replaceAll("[Rp,.]", "");
                            double parsed = Double.parseDouble(cleanString);
                            Locale localeID = new Locale("in", "ID");
                            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                            String formatted = formatRupiah.format((parsed)/10);
                            et1.setText(formatted);
                            et1.setSelection(formatted.length());
                            et1.addTextChangedListener(this);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void onConvertRG(){
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et1.hasFocus()){
                    if (tv2.getText().toString().equalsIgnoreCase("MYR")){
                        if (count!=0){
                            et1.removeTextChangedListener(this);
                            String cleanString = s.toString().replaceAll("[Rp,.]", "");
                            double parsed = Double.parseDouble(cleanString);
                            Locale localeID = new Locale("in", "ID");
                            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                            String formatted = formatRupiah.format((parsed));
                            et1.setText(formatted);
                            et1.setSelection(formatted.length());
                            et1.addTextChangedListener(this);

                            double total = Double.parseDouble(cleanString) / Constant.IDRTORINGGIT;
                            String totalString = total+"";

                            et2.removeTextChangedListener(this);
                            String usdString = totalString.replaceAll("[MYR,.]", "");
                            Locale localeEN = new Locale("my", "MY");
                            String formattedEN = NumberFormat.getCurrencyInstance(localeEN).format((Double.parseDouble(usdString)/10));
                            et2.setText(formattedEN);
                            et2.setSelection(formattedEN.length());
                            et2.addTextChangedListener(this);
                        }
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et2.hasFocus()){
                    if (tv2.getText().toString().equalsIgnoreCase("MYR")){
                        if (count!=0){
                            et2.removeTextChangedListener(this);
                            String usdString = s.toString().replaceAll("[MYR,.]", "");
                            Locale localeEN = new Locale("my", "MY");
                            String formattedEN = NumberFormat.getCurrencyInstance(localeEN).format((Double.parseDouble(usdString)));
                            et2.setText(formattedEN);
                            et2.setSelection(formattedEN.length());
                            et2.addTextChangedListener(this);

                            double total = Double.parseDouble(usdString) * Constant.IDRTORINGGIT;
                            String totalString = total+"";

                            et1.removeTextChangedListener(this);
                            String cleanString = totalString.replaceAll("[Rp,.]", "");
                            double parsed = Double.parseDouble(cleanString);
                            Locale localeID = new Locale("in", "ID");
                            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                            String formatted = formatRupiah.format((parsed)/10);
                            et1.setText(formatted);
                            et1.setSelection(formatted.length());
                            et1.addTextChangedListener(this);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void onConvertBAHT(){
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et1.hasFocus()){
                    if (tv2.getText().toString().equalsIgnoreCase("THB")){
                        if (count!=0){
                            et1.removeTextChangedListener(this);
                            String cleanString = s.toString().replaceAll("[Rp,.]", "");
                            double parsed = Double.parseDouble(cleanString);
                            Locale localeID = new Locale("in", "ID");
                            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                            String formatted = formatRupiah.format((parsed));
                            et1.setText(formatted);
                            et1.setSelection(formatted.length());
                            et1.addTextChangedListener(this);

                            double total = Double.parseDouble(cleanString) / Constant.IDRTOBAHT;
                            String totalString = total+"";

                            et2.removeTextChangedListener(this);
                            String usdString = totalString.replaceAll("[THB,.]", "");
                            Locale localeEN = new Locale("th", "TH");
                            String formattedEN = NumberFormat.getCurrencyInstance(localeEN).format((Double.parseDouble(usdString)/10));
                            et2.setText(formattedEN);
                            et2.setSelection(formattedEN.length());
                            et2.addTextChangedListener(this);
                        }
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et2.hasFocus()){
                    if (tv2.getText().toString().equalsIgnoreCase("THB")){
                        if (count!=0){
                            et2.removeTextChangedListener(this);
                            String usdString = s.toString().replaceAll("[THB,.]", "");
                            Locale localeEN = new Locale("th", "TH");
                            String formattedEN = NumberFormat.getCurrencyInstance(localeEN).format((Double.parseDouble(usdString)));
                            et2.setText(formattedEN);
                            et2.setSelection(formattedEN.length());
                            et2.addTextChangedListener(this);

                            double total = Double.parseDouble(usdString) * Constant.IDRTOBAHT;
                            String totalString = total+"";

                            et1.removeTextChangedListener(this);
                            String cleanString = totalString.replaceAll("[Rp,.]", "");
                            double parsed = Double.parseDouble(cleanString);
                            Locale localeID = new Locale("in", "ID");
                            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                            String formatted = formatRupiah.format((parsed)/10);
                            et1.setText(formatted);
                            et1.setSelection(formatted.length());
                            et1.addTextChangedListener(this);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



    private void dialogCountry(){
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        View view = LayoutInflater.from(this).inflate(com.example.kiranapaulina.moneymaw1.R.layout.dialog_list_converter, null);
        alertDialog.setView(view);
        RecyclerView listCountry = view.findViewById(com.example.kiranapaulina.moneymaw1.R.id.dialog_list_converter_list);

        setUpData();
        adapter = new CountryAdapter(this, data);

        adapter.onSelectedCountry(new CountryCallBack() {
            @Override
            public void onCountryCallBack(CountryModel countryModel) {
                tv2.setText(countryModel.getName());
                alertDialog.dismiss();
            }
        });

        listCountry.setLayoutManager(new LinearLayoutManager(this));
        listCountry.setItemAnimator(new DefaultItemAnimator());
        listCountry.setAdapter(adapter);

        alertDialog.show();
        alertDialog.setCancelable(true);
    }

    private void setUpData(){
        data.clear();
        data.add(new CountryModel("USD", Constant.IDRTOUSD));
        data.add(new CountryModel("SGD", Constant.IDRTOSGD));
        data.add(new CountryModel("THB", Constant.IDRTOBAHT));
        data.add(new CountryModel("MYR", Constant.IDRTORINGGIT));

    }
}
