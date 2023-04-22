package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MyNotes> arrayNotes;
    private ListView notesList;
    private TextView title;
    private TextView countNotes;
    private EditText search;
    private Button addnote_btn;
    private Button searh_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.arrayNotes = new ArrayList<MyNotes>();

        this.notesList = findViewById(R.id.notesList);
        this.title = findViewById(R.id.title);
        this.countNotes = findViewById(R.id.countNotes);
        this.search = findViewById(R.id.search);
        this.addnote_btn = findViewById(R.id.addnote);
        this.searh_btn = findViewById(R.id.addnote);


        this.addnote_btn.setOnClickListener(new MyOnclickListener(this));

    }
}