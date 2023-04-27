package com.example.mynotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mynotes.database.DatabaseManager;
import com.example.mynotes.listener.MyListViewClickListener;
import com.example.mynotes.listener.MyLongClickItemListener;
import com.example.mynotes.MyNotes;
import com.example.mynotes.listener.MyOnTextChangeListener;
import com.example.mynotes.listener.MyOnclickListener;
import com.example.mynotes.NoteViewBinder;
import com.example.mynotes.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final static int[] VUES = { R.id.title_tview , R.id.content_tview };
    private final static String[] CHAMPS = { MyNotes.COLUMN_TITLE , MyNotes.COLUMN_NOTE_CONTENT };

    private ListView notesList;
    private TextView title;
    private TextView countNotes;
    private EditText search;
    private Button addnote_btn;
    private DatabaseManager dbManager;
    private RelativeLayout main;
    private SimpleCursorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Init variable
         * */
        this.notesList = findViewById(R.id.notesList);
        this.title = findViewById(R.id.title);
        this.countNotes = findViewById(R.id.countNotes);
        this.search = findViewById(R.id.search);
        this.addnote_btn = findViewById(R.id.addnote);
        this.dbManager = new DatabaseManager(this);
        this.main = findViewById(R.id.mainactivity);

        this.adapter = new SimpleCursorAdapter(this, R.layout.row_layout, null, MainActivity.CHAMPS, MainActivity.VUES, 0);
        this.adapter.setViewBinder(new NoteViewBinder());
        this.notesList.setAdapter(this.adapter);

        /**
         * Add Listener
         * */
        this.addnote_btn.setOnClickListener(new MyOnclickListener(this));
        this.notesList.setOnItemClickListener(new MyListViewClickListener(this,this.notesList));
        this.search.addTextChangedListener(new MyOnTextChangeListener(this,this.dbManager,this.adapter,this.search));
        this.notesList.setOnItemLongClickListener(new MyLongClickItemListener(this,this.adapter,this.countNotes));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        this.getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.apparence){

            this.startActivity(new Intent(this, SettingsActivity.class));
            return  true;

        }else if(id == R.id.clear_cache){

            this.dbManager.deleteAllNotes();
            Cursor cursor = dbManager.getAllNotes();

            if(cursor != null){

                this.countNotes.setText(String.valueOf(cursor.getCount()));
                this.adapter.changeCursor(cursor); //permet d'appliquer les modifications en cas d'update d'une note
                this.adapter.notifyDataSetChanged();

            }
        }

        return super.onOptionsItemSelected(item);

    }


    @Override
    protected void onResume() {

        super.onResume();

        this.displayAllNotes();

        SharedPreferences share = PreferenceManager.getDefaultSharedPreferences(this);
        TextView title_main = findViewById(R.id.title);

        if (share.getBoolean("dark_mode", false)) {

            this.main.setBackgroundColor(Color.BLACK);
            title_main.setTextColor(Color.WHITE);
            this.countNotes.setTextColor(Color.WHITE);
            this.search.setTextColor(Color.WHITE);

        }else{

            this.main.setBackgroundColor(Color.WHITE);
            title_main.setTextColor(Color.BLACK);
            this.countNotes.setTextColor(Color.BLACK);
            this.search.setTextColor(Color.BLACK);

        }
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


    public void OpenPopup(){
    }
}