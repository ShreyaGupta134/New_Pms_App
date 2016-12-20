package com.example.shreyagupta.login_register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Shreya Gupta on 14-12-2016.
 */

public class Display extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String my_user = getIntent().getStringExtra("Username");
        TextView tv = (TextView) findViewById(R.id.TVUsername);
        tv.setText(my_user);
    }

    public void B_proceed(View vw) {
        if (vw.getId() == R.id.p_proceed) {
            Intent i = new Intent(Display.this, Registration.class);
            startActivity(i);
        }
    }
}