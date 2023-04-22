package com.example.mynotes;

import android.view.View;

public class MyOnclickListener implements View.OnClickListener {

    private View view;

    public MyOnclickListener(View view){
        this.view = view;
    }

    @Override
    public void onClick(View view) {

    }

    public View getView(){
        return this.view;
    }
}
