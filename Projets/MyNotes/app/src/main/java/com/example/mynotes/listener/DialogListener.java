package com.example.mynotes.listener;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mynotes.R;
import com.example.mynotes.database.DatabaseManager;

public class DialogListener implements DialogInterface.OnClickListener {

    private Context context;
    private View view;
    private SimpleCursorAdapter adapter;
    private TextView countNotes;

    public DialogListener(Context context, View view, SimpleCursorAdapter adapter, TextView countNotes) {
        this.context = context;
        this.view = view;
        this.adapter = adapter;
        this.countNotes = countNotes;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i){
            case DialogInterface.BUTTON_POSITIVE :
                DatabaseManager dbManager = new DatabaseManager(context);

                TextView title = this.view.findViewById(R.id.title_tview);
                String title_text = title.getText().toString();

                if(dbManager.deleteNoteByTitle(title_text)){

                    Cursor cursor = dbManager.getAllNotes();

                    if(cursor != null){
                        this.countNotes.setText(String.valueOf(cursor.getCount()));
                        this.adapter.changeCursor(cursor); //permet d'appliquer les modifications en cas d'update d'une note
                        this.adapter.notifyDataSetChanged();
                        Toast.makeText(this.context, "Delete succed", Toast.LENGTH_SHORT).show();

                    }
                }
                break;
            case DialogInterface.BUTTON_NEGATIVE :

        }
    }
}
