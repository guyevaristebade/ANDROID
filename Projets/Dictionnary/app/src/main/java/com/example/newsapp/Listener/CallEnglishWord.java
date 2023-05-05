package com.example.newsapp.Listener;

import com.example.newsapp.Model.EnglishWord;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CallEnglishWord{

    @GET("en/{word}")
    Call<List<EnglishWord>> callWord(@Path("word") String word);
}
