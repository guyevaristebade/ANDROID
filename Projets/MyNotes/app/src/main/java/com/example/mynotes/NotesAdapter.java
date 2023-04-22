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

    public NotesAdapter(Context context , ArrayList<MyNotes> myNotesList){
        super(context, 0 , myNotesList);
    }


    /**
     *
     *
    @NonNull
    @Override
    public View getView(int position , @NonNull View convertView , @NonNull ViewGroup parent){
        return initView(position,convertView,parent);
    }


    /*public  View initView(int position , View convertView, ViewGroup parent){

    }*/

}
