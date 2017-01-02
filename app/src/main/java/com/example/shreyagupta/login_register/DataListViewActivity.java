package com.example.shreyagupta.login_register;

import  android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DataListViewActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase db;
    DatabaseHelper helper;
    Cursor cursor ;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list_view);
        listView=(ListView)findViewById(R.id.List_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.raw_wise);
        listView.setAdapter(listDataAdapter);
        db = helper.getReadableDatabase();
        helper=new DatabaseHelper(getApplicationContext());
        cursor = helper.getContact(db);

        if ( cursor.moveToFirst()) {
            do {

                String name,age,contact_no;
                name=cursor.getString(0);
                age=cursor.getString(1);
                contact_no=cursor.getString(2);

                DataProvider dataProvider =new DataProvider(name,age,contact_no);
                listDataAdapter.add(dataProvider);

            } while (cursor.moveToLast());
        }
    }
}
