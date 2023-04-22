package com.example.mynotes;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MyOnclickListener implements View.OnClickListener {

    private Context context;
    public MyOnclickListener(Context context){
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this.context,NoteActivity.class);
        this.context.startActivity(i);

    }
}
