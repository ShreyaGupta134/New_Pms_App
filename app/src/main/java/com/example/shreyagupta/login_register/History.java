package com.example.shreyagupta.login_register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Shreya Gupta on 29-12-2016.
 */

public class History extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
    }

    public  void OnClickSaveDetails (View view) {
        if (view.getId() == R.id.save_details) {
            EditText d_type = (EditText) findViewById(R.id.diagnosis_type) ;
            EditText d_history = (EditText) findViewById(R.id.Diagnosis_history);
            EditText d_pres = (EditText) findViewById(R.id.pre_medication);
            EditText d_pre_med = (EditText) findViewById(R.id.pre_med);


            String type_d = d_type.getText().toString();
            String history_d = d_history.getText().toString();
            String pres_d = d_pres.getText().toString();
            String pres_medi_d = d_pre_med.getText().toString();

            Toast.makeText(getBaseContext(),"one row inserted",Toast.LENGTH_LONG).show();

        }
    }
}
