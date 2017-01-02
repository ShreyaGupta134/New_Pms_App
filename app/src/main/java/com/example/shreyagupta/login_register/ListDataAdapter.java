package com.example.shreyagupta.login_register;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Shreya Gupta on 02-01-2017.
 */

public class ListDataAdapter extends ArrayAdapter {
    List list= new ArrayList();
    public ListDataAdapter(Context context, int resource) {
        super(context, resource);


    }

    static class Lhandler {

        TextView p_name , p_phone , p_age ;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View r = convertView;
        Lhandler lh ;
        if (r == null) {
            LayoutInflater lf = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            r = lf.inflate(R.layout.raw_wise,parent,false);
            lh = new Lhandler();
            lh.p_name = (TextView)r.findViewById(R.id.user_name);
            lh.p_age = (TextView)r.findViewById(R.id.user_age);
            lh.p_phone = (TextView)r.findViewById(R.id.User_contactno);
            r.setTag(lh);

        }
        else {
            lh = (Lhandler) r.getTag();
        }
        DataProvider dp = (DataProvider) this.getItem(position);
        lh.p_name.setText(dp.getName());
        lh.p_phone.setText(dp.getContact_no());
        lh.p_age.setText(dp.getAge());

        return super.getView(position, convertView, parent);
    }
}

