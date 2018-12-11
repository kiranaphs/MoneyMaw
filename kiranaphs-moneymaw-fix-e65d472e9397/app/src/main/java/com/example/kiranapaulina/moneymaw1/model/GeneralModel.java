package com.example.kiranapaulina.moneymaw1.model;

public class GeneralModel extends ListItem {

    JournalModel journalModel;

    public JournalModel getJournalModel() {
        return journalModel;
    }

    public void setJournalModel(JournalModel journalModel) {
        this.journalModel = journalModel;
    }

    @Override
    public int getType() {
        return TYPE_GENERAL;
    }
}
