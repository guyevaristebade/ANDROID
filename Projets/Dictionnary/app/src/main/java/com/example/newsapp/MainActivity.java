package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newsapp.Listener.OnFetchDataListener;
import com.example.newsapp.Model.EnglishWord;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestManager requestManager = new RequestManager(this);
        requestManager.getEnglishWord(listener,"general");
    }

    private OnFetchDataListener listener = new OnFetchDataListener() {

        @Override
        public void onFecthData(EnglishWord englishWords) {
            System.out.println(englishWords.getPhonetic());
        }

        @Override
        public void onError() {
            System.out.printf("Une erreur s'est produite");
        }
    };

    public void display(EnglishWord englishWord){

    }
}