package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import java.util.Observable;
import java.util.Observer;

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
    private DatabaseManager dbManager;
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
        this.dbManager = new DatabaseManager(this);

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

        this.notesList.setOnItemLongClickListener(new MyLongClickItemListener(this,this.adapter,this.countNotes));
    }



    @Override
    protected void onResume() {
        super.onResume();

        this.displayAllNotes();

    }

    public void displayAllNotes(){


        Cursor cursor = this.dbManager.getAllNotes();

        if(cursor != null){

            this.countNotes.setText(String.valueOf(cursor.getCount()));
            this.adapter.changeCursor(cursor); //permet d'appliquer les modifications en cas d'update d'une note

        }else {

            this.countNotes.setText("No data found");
            Toast.makeText(this,"No Notes Found " , Toast.LENGTH_LONG).show();

        }
    }


    public void openPopup(String title){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" Delete Box ");
        builder.setMessage(" Can you delete this Note ? ");
        builder.setCancelable(false);
        DatabaseManager db = new DatabaseManager(this);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}