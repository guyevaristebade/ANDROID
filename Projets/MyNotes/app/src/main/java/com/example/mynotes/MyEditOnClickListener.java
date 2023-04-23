package com.example.mynotes;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MyEditOnClickListener implements View.OnClickListener {

        private Context context;
        private TextView title;
        private TextView content;
        private String id;

        public MyEditOnClickListener(Context context, TextView title, TextView content, String id ) {
                this.context = context;
                this.title = title;
                this.content = content;
                this.id = id;

        }

        @Override
        public void onClick(View view) {

                if(!title.equals("") && !content.equals("")){

                }else{

                }
        }
}
