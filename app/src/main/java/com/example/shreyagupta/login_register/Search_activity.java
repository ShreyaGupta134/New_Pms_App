package com.example.shreyagupta.login_register;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Shreya Gupta on 29-12-2016.
 */

public class Search_activity extends AppCompatActivity {

    EditText search_name ;
    TextView dis_age;
    TextView dis_phone ;
    DatabaseHelper dis_db ;
    SQLiteDatabase dis_sql ;
    String search_p ;
    Cursor csr ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_patients);

        String name_of_patient = getIntent().getStringExtra("PatientName");

        //TextView tv = (TextView) findViewById(R.id.user_name);
        search_name = (EditText) findViewById(R.id.search_patients);
        search_name.setText(name_of_patient);
        dis_age = (TextView) findViewById (R.id.display_age);
        dis_phone =(TextView) findViewById (R.id.display_phone);
        dis_phone.setVisibility(View.GONE);
        dis_age.setVisibility(View.GONE);
    }

    public void searchOldPatient (View view) {
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
         }
    }
}
