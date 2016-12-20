package com.example.shreyagupta.login_register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnButtonClick (View v) {

        if (v.getId() == R.id.Blogin) {
            EditText et = (EditText) findViewById(R.id.TFUsername);
            String str = et.getText().toString();
            Intent in = new Intent(MainActivity.this, Display.class) ;
            in.putExtra("Username",str);
            startActivity(in);
        }
        }
   }




