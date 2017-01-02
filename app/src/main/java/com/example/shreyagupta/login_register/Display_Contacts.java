package com.example.shreyagupta.login_register;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

/**
 * Created by Shreya Gupta on 27-12-2016.
 */

public class Display_Contacts extends CursorAdapter {


    public Display_Contacts(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup vg) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,vg,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}
