package com.example.mynotes.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.mynotes.activities.NoteActivity;

public class MyOnclickListener implements View.OnClickListener {

    private Context context;
    public MyOnclickListener(Context context){
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this.context, NoteActivity.class);
        this.context.startActivity(i);

    }
}
