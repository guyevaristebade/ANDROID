package com.example.mynotes;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyListViewClickListener implements AdapterView.OnItemClickListener {

    private Context context;
    private ListView lv;

    public MyListViewClickListener(Context context, ListView lv) {
        this.context = context;
        this.lv = lv;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int itemPosition = i;
        TextView title = view.findViewById(R.id.title_tview);
        TextView content = view.findViewById(R.id.content_tview);
        String title_text = title.getText().toString();
        String content_text = content.getText().toString();

        DatabaseManager db = new DatabaseManager(context);

        Intent intent = new Intent(context,EditActivity.class);
        intent.putExtra("title_note_edit",title_text);
        intent.putExtra("content_note_edit",content_text);
        intent.putExtra("id",db.getIdOfNoteByTitle(title_text));
        context.startActivity(intent);
    }
}
