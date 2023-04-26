package com.example.mynotes.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynotes.database.DatabaseManager;
import com.example.mynotes.MyNotes;
import com.example.mynotes.activities.MainActivity;

public class MyOnClickNoteListenner implements View.OnClickListener {

    EditText edit1;
    EditText edit2;
    Context context;


    public MyOnClickNoteListenner(Context context , EditText edit1, EditText edit2) {

        this.context = context;
        this.edit1 = edit1;
        this.edit2 = edit2;

    }

    @Override
    public void onClick(View view) {

        String title = this.edit1.getText().toString();
        String content = this.edit2.getText().toString();
        MyNotes note = new MyNotes(title,content);

        DatabaseManager dbManager = new DatabaseManager(context);

        if(!title.isEmpty() && !content.isEmpty() && dbManager.addNote(note)){

            Toast.makeText(context, "data added in database", Toast.LENGTH_LONG).show();
            Intent i = new Intent(context, MainActivity.class);
            context.startActivity(i);

        }else{

            Toast.makeText(this.context, "Is empty ",Toast.LENGTH_LONG).show();

        }
    }
}
