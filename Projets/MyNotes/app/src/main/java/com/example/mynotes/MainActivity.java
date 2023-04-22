package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseManager dbManager ;
    private ArrayList<MyNotes> arrayNotes;
    private ListView notesList;
    private ArrayAdapter adapter;
    private TextView title;
    private TextView countNotes;
    private EditText search;
    private Button addnote_btn;
    private Button searh_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dbManager = new DatabaseManager(this);

        this.arrayNotes = new ArrayList<>();
        this.notesList = findViewById(R.id.notesList);


        this.title = findViewById(R.id.title);
        this.countNotes = findViewById(R.id.countNotes);
        this.search = findViewById(R.id.search);
        this.addnote_btn = findViewById(R.id.addnote);
        this.searh_btn = findViewById(R.id.addnote);


        this.addnote_btn.setOnClickListener(new MyOnclickListener(this));
        //this.notesList.setOnItemClickListener();
        displayAllNotes();
    }


    public void displayAllNotes(){
        Cursor cursor = this.dbManager.getAllNotes();

        if(cursor.getCount() != 0){
            this.countNotes.setText(String.valueOf(cursor.getCount()));
            while(cursor.moveToNext()){
                String title = cursor.getString(1);
                String content = cursor.getString(2);

                MyNotes note = new MyNotes(title,content);
                arrayNotes.add(note);
            }
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayNotes);
            notesList.setAdapter(adapter);
        }else {
            this.countNotes.setText("0 data found");
            Toast.makeText(this,"No Notes Found " , Toast.LENGTH_LONG).show();
        }
    }
}