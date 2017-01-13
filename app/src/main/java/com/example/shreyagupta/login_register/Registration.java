package com.example.shreyagupta.login_register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Shreya Gupta on 15-12-2016.
 */

public class Registration extends Activity {

    DatabaseHelper Helper = new DatabaseHelper(this);
    RadioGroup rg ;
    RadioButton rb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        rg =(RadioGroup) findViewById(R.id.rgroup);
    }

    public  void rbclick (View vw){
        int radiobuttonclick = rg.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById (radiobuttonclick);
        Toast.makeText(getBaseContext(),rb.getText(),Toast.LENGTH_LONG).show();
    }
    public void OnRegisterClick (View v) {

        if (v.getId() == R.id.P_register) {

            EditText id = (EditText) findViewById(R.id.p_id);
            EditText name = (EditText) findViewById(R.id.p_name);
            EditText age = (EditText) findViewById(R.id.p_age);
            EditText phone = (EditText) findViewById(R.id.p_phone);
            EditText date = (EditText) findViewById(R.id.p_date);


            String id_str = id.getText().toString();
            String name_str= name.getText().toString();
            String age_str = age.getText().toString();
            String phone_str = phone.getText().toString();
            String date_str = date.getText().toString();
            Contact c = new Contact();

            c.setId(id_str);
            c.setage(age_str);
            c.setname(name_str);
            c.setDate(date_str);
            c.setContact_no(phone_str);

            Helper.insertcontacts(c);
            Toast.makeText(getBaseContext(),"Data inserted Successfully",Toast.LENGTH_LONG).show();
        }

    }
   /* public void OnHistoryClick (View vw2) {
        if (vw2.getId() == R.id.details_history) {
            Intent intent = new Intent(Registration.this,History.class);
            startActivity(intent);
        }
    }*/

    public void OnExitClick (View vw21) {
        if (vw21.getId() == R.id.exit_button) {
            Intent intent = new Intent(Registration.this,MainActivity.class);
            Toast.makeText(getBaseContext(),"You exited registration",Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
    }
}

