package com.example.mynotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "mynotes.db";
    public static final int DATABASE_VERSION = 1;
    private MyNotes mynotes ;
    public DatabaseManager(Context context) {
        super(context, DatabaseManager.DATABASE_NAME, null, DatabaseManager.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + MyNotes.TABLE_NAME + "(" +
                BaseColumns._ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                MyNotes.COLUMN_TITLE + " text NOT NULL, " +
                MyNotes.COLUMN_NOTE_CONTENT + " text NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old, int young) {
        db.execSQL("DROP TABLE IF EXISTS " + MyNotes.TABLE_NAME);
        onCreate(db);
    }

    public boolean addNote(MyNotes mynotes){
        return  true;
    }

    public boolean deleteNote(MyNotes mynotes){
        return  true;
    }

    public boolean UpdateNote(MyNotes mynotes){
        return  true;
    }

    public MyNotes getMyNotes(){
        return mynotes;
    }
}
