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

/**
 * Created by Shreya Gupta on 02-01-2017.
 */




public class ListDataAdapter extends ArrayAdapter {


    List list= new ArrayList();


    public ListDataAdapter(Context context, int resource, List<String> strings) {
        super(context, resource);
    }



    static class Lhandler {

        TextView name,phone,age,id;
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
        View row = convertView;
        Lhandler lh;
        if (row == null) {
            LayoutInflater lf = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = lf.inflate(R.layout.patientcontacts_row_wise, parent, false);
            lh = new Lhandler();
            lh.name = (TextView) row.findViewById(R.id.user_name);
            lh.age = (TextView) row.findViewById(R.id.user_age);
            lh.phone = (TextView) row.findViewById(R.id.User_contactno);
            lh.id=(TextView)row.findViewById(R.id.user_id) ;
            row.setTag(lh);

        } else
        {
            lh = (Lhandler) row.getTag();
        }

            DataProvider dp = (DataProvider)this.getItem(position);
            lh.name.setText(dp.getName());
            lh.phone.setText(dp.getContact_no());
            lh.age.setText(dp.getAge());
            lh.id.setText(dp.getId());
        return row;
        }
    }


