package com.example.mynotes;

public class MyNotes {

    private int id;
    private String title;
    private String content;
    private String date;

    public final static String TABLE_NAME = "mynotes";
    public final static String COLUMN_TITLE = "title";
    public final static String COLUMN_NOTE_CONTENT = "notecontent";


    public MyNotes(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters et Setters pour chaque champ
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        return this.title;
    }
}

