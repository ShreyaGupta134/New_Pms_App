package com.example.shreyagupta.login_register;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.widget.AdapterView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Shreya Gupta on 14-12-2016.
 */

public class Display extends Activity {

    ListView lv;
    EditText ed ;
    ArrayAdapter<String> adapter ;
    SQLiteDatabase database;
    com.example.shreyagupta.login_register.DatabaseHelper dbh;
    Cursor csr ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String username=getIntent().getStringExtra("Username");

        TextView tv=(TextView)findViewById(R.id.TvUsername);

        tv.setText(username);


    }
        //String uname = getIntent().getStringExtra("Username");
    //public class DisplayContact extends Activity {
    /*    int starting_point = 0;
        private DatabaseHelper mydb ;

        TextView p_gender ;
        TextView p_age ;
        TextView p_name;
        TextView p_number ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        lv = (ListView) findViewById(R.id.ListViewPatient);
        ed = (EditText) findViewById(R.id.edtSearch);
        DatabaseHelper dbh = new DatabaseHelper(getApplicationContext());
        database = dbh.getReadableDatabase();
        //adapter = new ArrayAdapter<String> (this,R.layout.list_item,R.id.textView,data);
        //lv.setAdapter(adapter);


        p_name = (TextView) findViewById(R.id.p_name);
        p_age = (TextView) findViewById(R.id.p_age);
        p_number = (TextView) findViewById(R.id.p_phone);
        //p_gender = (TextView) findViewById(R.id.rgroup);

        mydb = new DatabaseHelper(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");

            if (Value > 0) {
                //means this is the view part not the add contact part.
                Cursor rs = mydb.getData(Value);
                int id_To_Update = Value;
                rs.moveToFirst();

                String pat_age = rs.getString(rs.getColumnIndex(DatabaseHelper.COLUMN_age));
                String pat_phone = rs.getString(rs.getColumnIndex(DatabaseHelper.COLUMN_contact_no));
                String p_name = rs.getString(rs.getColumnIndex(DatabaseHelper.COLUMN_name));
                String p_gender = rs.getString(rs.getColumnIndex(DatabaseHelper.COLUMN_gender));
                if (!rs.isClosed()) {
                    rs.close();
                }


                ed.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        Display.this.adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

        /*ArrayList<String > arrayPatient = new ArrayList<>();
        arrayPatient.addAll(Arrays.asList(getResources().getStringArray(R.array.array_patient)));

        adapter = new ArrayAdapter<String>(Display.this,android.R.layout.simple_list_item_1,arrayPatient);
        lv.setAdapter(adapter);*/
        /*String my_user = getIntent().getStringExtra("Username");
        TextView tv = (TextView) findViewById(R.id.TFUsername);
        tv.setText(my_user);*/
        //    }
      //  }
    //}

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = (MenuItem) findViewById(R.id.menuSearch);
        SearchView sv = (SearchView) item.getActionView();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");
            if (Value > 0) {
                getMenuInflater().inflate(R.menu.menu_search, menu);
            }
        }
        return true;
    }

        /*sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
    }*/

    public void view_data(View vw1){
        if (vw1.getId() == R.id.viewButton) {
            Intent in = new Intent(Display.this,DataListViewActivity.class);
            startActivity(in);}

    }


    /*public void OnListSearchClick (View vv) {
        p   if (vv.getId() == R.id.ListViewSearch) {
            Intent intent = new Intent(Display.this,List_Search.class);
            startActivity(intent);
}
        }*/

    public void search_click (View vw2){
        if (vw2.getId() == R.id.button_search) {
        Intent i = new Intent(Display.this, Search_activity.class);
        startActivity(i);
        }
        }
public void B_proceed(View vw) {
        if (vw.getId() == R.id.p_proceed) {
        Intent i = new Intent(Display.this, Registration.class);
        startActivity(i);
        }

        }
        }
