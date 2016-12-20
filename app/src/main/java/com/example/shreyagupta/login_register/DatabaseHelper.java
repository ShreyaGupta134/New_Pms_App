package com.example.shreyagupta.login_register;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shreya Gupta on 19-12-2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private  static  final  int DATABASE_VERSION = 1;
    private  static  final  String DATABASE_NAME="contacts.db";
    private  static  final  String TABLE_NAME="contacts";
    private  static  final  String COLUMN_patient_id="id";
    private  static  final  String COLUMN_age="age";
    private  static  final  String COLUMN_contact_no="contact_no";
    private  static  final  String COLUMN_name="name";
    //private  static  final  String COLUMN_gender="gender";
    SQLiteDatabase db;

    private static final String TABLE_CREATE="create table contacts (id integer primary key not null , "
            + "name text not null , age text not null , contact_no text not null);";

    public DatabaseHelper(Context context){
    super(context , DATABASE_NAME , null , DATABASE_VERSION);
}
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public  void insertcontacts(Contact c){
         db=this.getWritableDatabase();
          ContentValues value=new ContentValues();
                //String query = select * from contacts ;
                value.put(COLUMN_age,c.getage());
                value.put(COLUMN_contact_no,c.getContact_no());
                value.put(COLUMN_name,c.getname());
                db.insert(TABLE_NAME , null , value);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        String query="DROP TABLE if exist "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
}
