package com.example.shreyagupta.login_register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnButtonClick (View v) {

            EditText et = (EditText) findViewById(R.id.TFUsername);
            String str = et.getText().toString();
            EditText pas = (EditText) findViewById(R.id.TFpassword);
            String pwd = pas.getText().toString();

            if(str.equals("shreya")&& pwd.equals("neetu123"))
            {

                Intent in = new Intent(MainActivity.this, Display.class) ;
                in.putExtra("Username",str);
                startActivity(in);

        }
            else {

                Toast.makeText(getBaseContext(),"You have entered wrong password",Toast.LENGTH_LONG).show();

            }
        }


        }






