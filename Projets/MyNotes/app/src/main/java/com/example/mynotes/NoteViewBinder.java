package com.example.mynotes;

import android.database.Cursor;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class NoteViewBinder implements SimpleCursorAdapter.ViewBinder {

    /**
     * Cette classe permet de mettre en relation un tuple de la base de donnée avec une vue spécifique
     * */
    @Override
    public boolean setViewValue(View view, Cursor cursor, int columnIndex) {

        if (view.getId() == R.id.title_tview) {

            String title = cursor.getString(columnIndex);
            ((TextView) view).setText(title);

            return true;

        } else if (view.getId() == R.id.content_tview) {

            String content = cursor.getString(columnIndex);
            ((TextView) view).setText(content);

            return true;

        }

        return false;
    }
}

