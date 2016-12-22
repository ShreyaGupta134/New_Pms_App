package com.example.shreyagupta.login_register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Shreya Gupta on 14-12-2016.
 */

public class Display extends Activity {

    ArrayAdapter <String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        ListView lv = (ListView) findViewById(R.id.ListViewPatient);
        ArrayList<String > arrayPatient = new ArrayList<>();
        arrayPatient.addAll(Arrays.asList(getResources().getStringArray(R.array.array_patient)));

        adapter = new ArrayAdapter<String>(Display.this,android.R.layout.simple_list_item_1,arrayPatient);
        lv.setAdapter(adapter);
        /*String my_user = getIntent().getStringExtra("Username");
        TextView tv = (TextView) findViewById(R.id.TFUsername);
        tv.setText(my_user);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = (MenuItem) findViewById(R.id.menuSearch);
        SearchView sv = (SearchView)item.getActionView();

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
        public void B_proceed(View vw) {
        if (vw.getId() == R.id.p_proceed) {
            Intent i = new Intent(Display.this, Registration.class);
            startActivity(i);
        }

        }
    }
