package com.example.shreyagupta.login_register;

import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.tv.TvInputService;
import android.os.Bundle;
import android.service.textservice.SpellCheckerService;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.shreyagupta.login_register.R.id.History_click;
import static com.example.shreyagupta.login_register.R.id.button_click_search;

/**
 * Created by Shreya Gupta on 06-01-2017.
 */


    public class Patient_HistoryDataListViewActivity extends AppCompatActivity {

        //private Session session ;
        ListView listView;
        SQLiteDatabase db;
        int i;
        DatabaseHelper helper;
        Cursor cursor ;
        Button button ;
        String patient_id;

        //patientRecord_ListDataAdapter ptd ;
       // String newString;


        //Adapter adp;
        // ArrayList <Contact> stringArrayList;
        patientRecord_ListDataAdapter listDataAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.patientrecord_activity_data_list_view1);
            listView = (ListView) findViewById(R.id.List_view1);
            helper = new DatabaseHelper(getApplicationContext());
            db = helper.getReadableDatabase();
            cursor = helper.getPatientHistory(db);
            helper.getData(db);

            listDataAdapter = new patientRecord_ListDataAdapter(getApplicationContext(), R.layout.patientrecord_row_wise, null);
            listView.setAdapter(listDataAdapter);
            //session = new Session(this);

          //final String id_history =getIntent().getStringExtra(DatabaseHelper.COLUMN_patient_id);


            if (savedInstanceState == null) {
                Bundle extras = getIntent().getExtras();
                if(extras == null) {
                    patient_id= null;
                } else {
                    patient_id= extras.getString("PATIENT_ID");
                }
            } else {
                patient_id= (String) savedInstanceState.getSerializable("PATIENT_ID");
            }
            Log.i("Variable",patient_id);



            AdapterView.OnItemClickListener myListViewClicked = new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(Patient_HistoryDataListViewActivity.this,patientRecord_ListDataAdapter.class);
                    //intent.putExtra(DatabaseHelper.COLUMN_patient_history_id,String.valueOf(id_history));
                    startActivity(intent);
                    //String item = adapterView.getItemAtPosition(i).toString();
                    //String Query="select * from patient_history where"+DatabaseHelper.COLUMN_patient_history_id+"="+id_history;
                    Log.i("Clicked Item: " ,Integer.toString(i));
                }
            };
            listView.setOnItemClickListener(myListViewClicked);
            //String Query="select * from patient_history where"+DatabaseHelper.COLUMN_patient_history_id+"="+id_history;
            if (cursor.moveToFirst()) {

                do {
                    String prescription, date, note, diagnosis,id;

                    id = cursor.getString(0);
                    date = cursor.getString(1);
                    prescription = cursor.getString(2);
                    note = cursor.getString(3);
                    diagnosis = cursor.getString(4);
                    PatientRecord_Dataprovider dataProvider = new PatientRecord_Dataprovider(id,date, prescription, note, diagnosis);
                    listDataAdapter.add(dataProvider);

                } while (cursor.moveToNext());
            }



            button = (Button) findViewById (History_click);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Patient_HistoryDataListViewActivity.this, History.class);
                    startActivity(intent);
                }
            });
        }

    /*public void OnAddHistoryClick (View vw21) {
        if (vw21.getId() == History_click) {
            Intent intent = new Intent(Patient_HistoryDataListViewActivity.this, History.class);
            startActivity(intent);
        }
    }*/
}

/*    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        /*Intent intent = new Intent(DataListViewActivity.this,ListDataAdapter.class);
        startActivity(intent);
        String item=adapter.getItemAtPosition(position).toString();
        Toast.makeText(this,"Clicked Item: "+item, Toast.LENGTH_SHORT);
    }*/




  /*  public void searchOldPatient (View view) {
        search_p = search_name.getText().toString();
        dis_db = new DatabaseHelper(getApplicationContext());
        dis_sql = dis_db.getReadableDatabase();
        csr = dis_db.fetchdata(search_p,dis_sql);
        if (csr.moveToFirst()) {
            String phone_number = csr.getString(0);
            String age = csr.getString(1);
            dis_age.setText(age);
            dis_phone.setText(phone_number);
            dis_phone.setVisibility(View.VISIBLE);
            dis_age.setVisibility(View.VISIBLE);
        }*/

// Copying of List_Search class starts - as all the methods pfd ListView should be implemented in the very same class.



