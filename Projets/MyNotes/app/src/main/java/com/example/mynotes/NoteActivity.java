package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NoteActivity extends AppCompatActivity {

    private Button save_btn;
    private EditText noteTitle;
    private EditText noteContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_activity);

        this.save_btn = findViewById(R.id.save);
        this.noteTitle = findViewById(R.id.title_note);
        this.noteContent = findViewById(R.id.note_content);


        /**
         * add Events
         * */

        save_btn.setOnClickListener(new onClickNoteListenner(this,this.noteTitle, this.noteContent));

    }
}