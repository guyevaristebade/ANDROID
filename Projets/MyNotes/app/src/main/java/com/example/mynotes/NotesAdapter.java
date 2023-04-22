package com.example.mynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class NotesAdapter extends ArrayAdapter<MyNotes> {

    private ArrayList<MyNotes> myNotesList;

    public NotesAdapter(Context context, ArrayList<MyNotes> myNotesList) {
        super(context, 0, myNotesList);
        this.myNotesList = myNotesList;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, parent, false);
        }

        MyNotes currentNote = myNotesList.get(position);

        //TextView titleTextView = listItemView.findViewById(R.id.titleTextView);
        //TextView contentTextView = listItemView.findViewById(R.id.contentTextView);

        //titleTextView.setText(currentNote.getTitle());
        //contentTextView.setText(currentNote.getContent());

        return listItemView;
    }
}

