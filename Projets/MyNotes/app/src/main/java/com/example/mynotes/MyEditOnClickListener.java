package com.example.mynotes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MyEditOnClickListener implements View.OnClickListener {

        private Context context;
        private TextView title;
        private TextView content;
        private int id;

        private String date;


        public MyEditOnClickListener(Context context,  int id, TextView title, TextView  content ) {

                this.context = context;
                this.id = id;
                this.title = title;
                this.content = content;
        }

        @Override
        public void onClick(View view) {

                DatabaseManager dbManager = new DatabaseManager(context);
                String title_Text = this.title.getText().toString();
                String content_Text = this.content.getText().toString();

                if(!title.equals("") && !content.equals("") && dbManager.UpdateNoteById(this.id,title_Text,content_Text)){

                        Toast.makeText(context, "Data Updated "+ dbManager.UpdateNoteById(this.id,title_Text,content_Text), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(context,MainActivity.class);
                        context.startActivity(i);
                }else{

                        Toast.makeText(context, "Data not updated", Toast.LENGTH_SHORT).show();

                }
        }
}
