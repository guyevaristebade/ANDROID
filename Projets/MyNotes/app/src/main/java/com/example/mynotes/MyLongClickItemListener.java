package com.example.mynotes;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyLongClickItemListener implements AdapterView.OnItemLongClickListener {

   private Context context;
    private SimpleCursorAdapter  adapter;
    TextView countNotes;
    public MyLongClickItemListener(Context context , SimpleCursorAdapter adapter,TextView countNotes) {
        this.context = context;
        this.adapter = adapter;
        this.countNotes = countNotes;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        DatabaseManager dbManager = new DatabaseManager(context);

        TextView title = view.findViewById(R.id.title_tview);
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

        return true;
    }
}
