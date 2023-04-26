package com.example.mynotes;

import android.app.ActionBar;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

public class Popup extends PopupWindow {


    public Popup(Context context) {

        super(context);

        View contentView = LayoutInflater.from(context).inflate(R.layout.popup, null);

        setContentView(contentView);

        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        setFocusable(true);

    }
}
