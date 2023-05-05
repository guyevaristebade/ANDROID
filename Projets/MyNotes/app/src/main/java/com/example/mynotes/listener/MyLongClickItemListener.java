package com.example.mynotes.listener;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

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

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete this note");
        builder.setMessage("Are you sure you want to delete this note? ?");
        builder.setPositiveButton("YES",new DialogListener(context,view,adapter,countNotes));
        builder.setNegativeButton("NO",new DialogListener(context,view,adapter,countNotes));
        builder.show();

        return true;
    }
}
