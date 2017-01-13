package com.example.shreyagupta.login_register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Shreya Gupta on 05-01-2017.
 */

public class History extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper (this) ; // Compilation error


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
    }

    public void OnClickSaveDetails(View view) {
        if (view.getId() == R.id.save_details) {
            EditText d_notes = (EditText) findViewById(R.id.notes);
            EditText d_history = (EditText) findViewById(R.id.Diagnosis_history);
             EditText d_id = (EditText) findViewById(R.id.patient_ID);
            EditText d_presciption = (EditText) findViewById(R.id.pre_med);
            EditText d_date = (EditText) findViewById(R.id.patient_date);


            String patient_notes = d_notes.getText().toString();
            String history_d = d_history.getText().toString();
             String id= d_id.getText().toString();
            String patient_date = d_date.getText().toString();
            String patient_pres= d_presciption.getText().toString();
            Contact_Records c = new Contact_Records();

             c.setId(id);
            c.setDiagnosis(patient_pres);
            c.setDate(patient_date);
            c.setPre_med(history_d);
            c.setType(patient_notes);

            helper.insertPatientRecord(c);
            Toast.makeText(getBaseContext(), "one row inserted", Toast.LENGTH_LONG).show();

        }
    }
}
