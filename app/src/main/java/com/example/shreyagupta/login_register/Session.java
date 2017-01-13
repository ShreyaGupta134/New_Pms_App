package com.example.shreyagupta.login_register;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shreya Gupta on 13-01-2017.
 */

public class Session {

    SharedPreferences pref ;
    SharedPreferences.Editor editor ;
    Context ctx ;

    public Session (Context ctx){ // creating a constructor with argument type Context
        this.ctx = ctx ;
        pref = ctx.getSharedPreferences("Patient_id",Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    //Method declared for storing data

    public void setID (boolean ID_set) {
        editor.putBoolean("MyID",ID_set); // Here I am supposed to pass one "key_name" and the boolean arg. What will be the key name ?
        editor.commit(); // To push the changes
    }
    //Method to return the stored data
    public boolean getID (){
        return pref.getBoolean("MyID",false);
    }

}


