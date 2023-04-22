package com.example.mynotes;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class onClickNoteListenner implements View.OnClickListener {

    EditText edit1;
    EditText edit2;
    Context context;
    public onClickNoteListenner(Context context , EditText edit1, EditText edit2) {
        this.edit1 = edit1;
        this.edit2 = edit2;
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        String title = this.edit1.getText().toString();
        String content = this.edit2.getText().toString();

        MyNotes note = new MyNotes(title,content);
        DatabaseManager dbManager = new DatabaseManager(context);


        if(!title.equals("") && !content.equals("") && dbManager.addNote(note)){

            Toast.makeText(context, "data added in database", Toast.LENGTH_LONG).show();

        }else{

            Toast.makeText(this.context, "Is empty ",Toast.LENGTH_LONG).show();

        }
    }
}
