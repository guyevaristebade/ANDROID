package com.example.mynotes;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewClickListener implements AdapterView.OnItemClickListener {

    private Context context;
    private DatabaseManager dbManager;
    private TextView countNotes;
    private ArrayList<String> arrayNotes;
    private ArrayAdapter adapter;
    private ListView notesList;

    public ListViewClickListener(Context context , DatabaseManager dbManager, TextView countNotes, ArrayList<String> arrayNotes, ArrayAdapter adapter, ListView notesList) {
        this.context = context;
        this.dbManager = dbManager;
        this.countNotes = countNotes;
        this.arrayNotes = arrayNotes;
        this.adapter = adapter;
        this.notesList = notesList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Cursor cursor = this.dbManager.getAllNotes();

        if(cursor.getCount() != 0){
            this.countNotes.setText(String.valueOf(cursor.getCount()));
            while(cursor.moveToNext()){
                arrayNotes.add(cursor.getString(1));
            }

            adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1,arrayNotes);
            notesList.setAdapter(adapter);

        }else {

            this.countNotes.setText("0 data found");
            Toast.makeText(context,"No Notes Found " , Toast.LENGTH_LONG).show();

        }
    }
}
