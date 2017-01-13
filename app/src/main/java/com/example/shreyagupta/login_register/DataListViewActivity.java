package com.example.shreyagupta.login_register;

import android.content.Context;
import android.content.SharedPreferences;
import  android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.tv.TvInputService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class DataListViewActivity extends AppCompatActivity {

    private Session session;
    ListView listView;
    SQLiteDatabase db;
    int i;
    DatabaseHelper helper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;
    // String id_history = getIntent().getStringExtra(DatabaseHelper.COLUMN_patient_id);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list_view);
        listView = (ListView) findViewById(R.id.List_view);
        helper = new DatabaseHelper(getApplicationContext());
        db = helper.getReadableDatabase();
        cursor = helper.getContact(db);
        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.patientcontacts_row_wise, null);
        if (cursor.moveToFirst()) {
            do {

                String name, age, contact_no, id;
                id = cursor.getString(0);
                name = cursor.getString(1);
                age = cursor.getString(2);
                contact_no = cursor.getString(3);

                DataProvider dataProvider = new DataProvider(name, age, contact_no, id);
                listDataAdapter.add(dataProvider);

            } while (cursor.moveToNext());
        }
        cursor.close();
        listView.setAdapter(listDataAdapter);
        AdapterView.OnItemClickListener myListViewClicked = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                DataProvider item = (DataProvider)adapterView.getItemAtPosition(i);
                String id = item.getId().toString();
                Intent intent = new Intent(DataListViewActivity.this, Patient_HistoryDataListViewActivity.class);
                intent.putExtra("PATIENT_ID", id);
                startActivity(intent);
                Toast.makeText(getBaseContext(),id,Toast.LENGTH_LONG).show();
                //String id_contacts = ((TextView) view.findViewById(R.id.user_id)).getText().toString();
                //cursor=helper.getData(db);
                //String item = adapterView.getItemAtPosition(i).toString();
                Log.i("Clicked Item: ", Integer.toString(i));
            }
        };
        listView.setOnItemClickListener(myListViewClicked);

    }

        /*AdapterView.OnItemClickListener myListViewClicked = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // Object item = adapterView.getItemAtPosition(i);
                //String id = item.toString();
                DataProvider item = (DataProvider)adapterView.getItemAtPosition(i);
                String id = item.getId().toString();
                Intent intent = new Intent(DataListViewActivity.this, Patient_HistoryDataListViewActivity.class);
                intent.putExtra("PATIENT_ID", id);
                startActivity(intent);
                Toast.makeText(getBaseContext(),id,Toast.LENGTH_LONG).show();
                //cursor=helper.getData(db);
                //String item = adapterView.getItemAtPosition(i).toString();
                Log.i("Clicked Item: ", Integer.toString(i));
            }
        };
        listView.setOnItemClickListener(myListViewClicked);

    }*/
}
    //SharedPreferences pref ;
    //SharedPreferences.Editor editor ;
    //Context ctx ;





    //Adapter adp;
    // ArrayList <Contact> stringArrayList;

    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list_view);
        listView = (ListView) findViewById(R.id.List_view);
        helper = new DatabaseHelper(getApplicationContext());
        db = helper.getReadableDatabase();
        cursor = helper.getContact(db);
        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.patientcontacts_row_wise, null);
        if (cursor.moveToFirst()) {
            do {

                String name, age, contact_no, id;
                id = cursor.getString(0);
                name = cursor.getString(1);
                age = cursor.getString(2);
                contact_no = cursor.getString(3);

                DataProvider dataProvider = new DataProvider(name, age, contact_no, id);
                listDataAdapter.add(dataProvider);

            } while (cursor.moveToNext());
        }
        cursor.close();
        listView.setClickable(true);
        listView.setAdapter(listDataAdapter);

        //SharedPreferences pref = getSharedPreferences(name, 0){ };



        AdapterView.OnItemClickListener myListViewClicked = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //String id_contacts = ((TextView) view.findViewById(R.id.user_id)).getText().toString();


               // cursor = helper.get(db);
                //Toast.makeText(getBaseContext(), id_contacts, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DataListViewActivity.this, Patient_HistoryDataListViewActivity.class);
               // intent.putExtra(id_contacts, Session);
                startActivity(intent);
                //String item = adapterView.getItemAtPosition(i).toString();
                //Log.i("Clicked Item: ", Integer.toString(i));
            }
        };
        listView.setOnItemClickListener(myListViewClicked);

    }


    /*public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        Object item = listView.getItemAtPosition(i);
        String patient_id = item.toString();
        //cursor = helper.getData(db);
        Toast.makeText(getBaseContext(),patient_id,Toast.LENGTH_LONG).show();
        /*Intent intent = new Intent(DataListViewActivity.this,ListDataAdapter.class);
        startActivity(intent);
        String item=adapter.getItemAtPosition(position).toString();
        Toast.makeText(this,"Clicked Item: "+item, Toast.LENGTH_SHORT);*/

/*public DataListViewActivity (Context ctx){ // creating a constructor with argument type Context
        this.ctx = ctx ;
        pref = ctx.getSharedPreferences("Patient_id",Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    //Method declared for storing data

    public void setID (boolean ID_set) {
        editor.putBoolean("MyID",ID_set); // Here I am supposed to pass one "key_name" and the boolean arg. What will be the key name ?
        editor.commit(); // To push the changes
    }
    //Method to return the stored data
    public boolean getID (){
        return pref.getBoolean("MyID",false);
    }

}*/



