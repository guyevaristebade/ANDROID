package com.example.mynotes.listener;

import android.content.Context;
import android.database.Cursor;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.mynotes.database.DatabaseManager;

public class MyOnTextChangeListener implements TextWatcher {

    private Context context;
    private DatabaseManager dbManager;
    private SimpleCursorAdapter adapter;
    private EditText search_input;

    public MyOnTextChangeListener(Context context, DatabaseManager dbManager, SimpleCursorAdapter adapter,EditText search_input) {
        this.context = context;
        this.dbManager = dbManager;
        this.adapter = adapter;
        this.search_input = search_input;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        String text = this.search_input.getText().toString();
        Cursor cursor = this.dbManager.SearchNote(text);

        if(cursor != null){

            this.adapter.changeCursor(cursor);
            this.adapter.notifyDataSetChanged();

        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
