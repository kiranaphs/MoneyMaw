package com.example.kiranapaulina.moneymaw1.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiranapaulina.moneymaw1.helper.Constant;
import com.example.kiranapaulina.moneymaw1.helper.Helper;
import com.example.kiranapaulina.moneymaw1.model.JournalModel;

public class DetailJouralActivity extends AppCompatActivity {

    TextView tvCategory;
    TextView tvDesc;
    TextView tvDate;
    ImageView ivImage;
    JournalModel journalModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.kiranapaulina.moneymaw1.R.layout.activity_detail_journal);

        tvCategory = findViewById(com.example.kiranapaulina.moneymaw1.R.id.detail_journal_textview);
        tvDesc = findViewById(com.example.kiranapaulina.moneymaw1.R.id.detail_journal_desc);
        tvDate = findViewById(com.example.kiranapaulina.moneymaw1.R.id.detail_journal_date);
        ivImage = findViewById(com.example.kiranapaulina.moneymaw1.R.id.detail_journal_image);

        journalModel = getIntent().getParcelableExtra(Constant.KEY_DATA);

        setUpUI();
    }

    private void setUpUI(){
        String category;
        if (journalModel.isIncome()){
            category = "Excome";
            ivImage.setImageResource(com.example.kiranapaulina.moneymaw1.R.drawable.ic_logoexcome);
        }else {
            category = "Income";
            ivImage.setImageResource(com.example.kiranapaulina.moneymaw1.R.drawable.ic_logoincome);
        }
        tvCategory.setText(category);
        tvDesc.setText("Deskripsi: " + journalModel.getDesc());
        tvDate.setText("Tanggal: " +Helper.getDateMonth(journalModel.getDate()));
    }
}
