package com.example.newsapp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.newsapp.Listener.CallEnglishWord;
import com.example.newsapp.Listener.OnFetchDataListener;
import com.example.newsapp.Model.EnglishWord;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {

    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/entries/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getEnglishWord(OnFetchDataListener listener , String word){
        CallEnglishWord callApiNews = retrofit.create(CallEnglishWord.class);
        Call<List<EnglishWord>> call = callApiNews.callWord(word);


        try{
            call.enqueue(new Callback<List<EnglishWord>>() {
                @Override
                public void onResponse(Call<List<EnglishWord>> call, Response<List<EnglishWord>> response) {
                    listener.onFecthData(response.body().get(0));
                }

                @Override
                public void onFailure(Call<List<EnglishWord>> call, Throwable t) {
                    Toast.makeText(context, "failed error", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
