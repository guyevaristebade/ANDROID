package com.example.newsapp.Listener;

import com.example.newsapp.Model.EnglishWord;

import java.util.List;

public interface OnFetchDataListener{

    void onFecthData(EnglishWord englishWord);
    void onError();
}