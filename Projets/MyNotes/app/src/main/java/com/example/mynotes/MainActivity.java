package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MyNotes> arrayNotes;
    private ListView notesList;
    private TextView title;
    private TextView countNotes;
    private EditText search;
    private Button addnote_btn;
    private Button searh_btn;

    private final static int[] VUES = { R.id.title_tview , R.id.content_tview };
    private final static String[] CHAMPS = { MyNotes.COLUMN_TITLE , MyNotes.COLUMN_NOTE_CONTENT };
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * init variable
         * */

        this.arrayNotes = new ArrayList<>();
        this.notesList = findViewById(R.id.notesList);


        this.title = findViewById(R.id.title);
        this.countNotes = findViewById(R.id.countNotes);
        this.search = findViewById(R.id.search);
        this.addnote_btn = findViewById(R.id.addnote);
        this.searh_btn = findViewById(R.id.addnote);


        /**
         * add Listener
         * */
        this.addnote_btn.setOnClickListener(new MyOnclickListener(this));
        this.notesList.setOnItemClickListener(new MyListViewClickListener(this,this.notesList));


        /**
         * ListView Configuration
         * */
        this.adapter = new SimpleCursorAdapter(this, R.layout.row_layout, null, MainActivity.CHAMPS, MainActivity.VUES, 0);
        this.adapter.setViewBinder(new NoteViewBinder());
        this.notesList.setAdapter(this.adapter);

        /**
         * display Notes in ListView
         * */
        this.displayAllNotes();
    }


    @Override
    protected void onResume() {
        super.onResume();

        this.displayAllNotes();
    }

    public void displayAllNotes(){

        DatabaseManager dbManager = new DatabaseManager(this);
        Cursor cursor = dbManager.getAllNotes();

        if(cursor != null){

            this.countNotes.setText(String.valueOf(cursor.getCount()));
            this.adapter.swapCursor(cursor);

        }else {

            this.countNotes.setText("No data found");
            Toast.makeText(this,"No Notes Found " , Toast.LENGTH_LONG).show();

        }
    }
}