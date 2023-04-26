package com.example.mynotes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mynotes.listener.MyEditOnClickListener;
import com.example.mynotes.R;


public class EditActivity extends AppCompatActivity {

    private TextView title;
    private TextView content;
    private Button updatebtn;
    private int id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        this.title = findViewById(R.id.title_edit);
        this.content = findViewById(R.id.note_edit);
        this.updatebtn = findViewById(R.id.updatebtn);
        Intent i = getIntent();

        this.title.setText(i.getStringExtra("title_note_edit"));
        this.content.setText(i.getStringExtra("content_note_edit"));
        this.id = i.getIntExtra("id",-1);




        this.updatebtn.setOnClickListener(new MyEditOnClickListener( this, this.id , this.title , this.content ));
    }
}
