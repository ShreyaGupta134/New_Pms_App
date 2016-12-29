package com.example.shreyagupta.login_register;

import  android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shreya Gupta on 19-12-2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public   static  final  int DATABASE_VERSION = 1;
    public   static  final  String DATABASE_NAME="contacts.db";
    public   static  final  String TABLE_NAME="contacts";
    public   static  final  String COLUMN_patient_id="id";
    public   static  final  String COLUMN_age="age";
    public   static  final  String COLUMN_contact_no="contact_no";
    public   static  final  String COLUMN_name="name";
    public   static  final  String COLUMN_gender="gender";
    SQLiteDatabase db;

    public static final String TABLE_CREATE="create table contacts (id integer primary key not null , "
            + "name text not null , age text not null , contact_no text not null);";

    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public void insertcontacts(Contact c){
         db=this.getWritableDatabase();
          ContentValues value=new ContentValues();
                //String query = select * from contacts ;
                value.put(COLUMN_age,c.getage());
                value.put(COLUMN_contact_no,c.getContact_no());
                value.put(COLUMN_name,c.getname());
                db.insert(TABLE_NAME , null , value);
    }

    /*public void addInfo (String the_age, String the_name , String the_number) {
        ContentValues cv = new ContentValues ();
        cv.put(COLUMN_name,the_name);
        cv.put(COLUMN_contact_no,the_number);
        cv.put(COLUMN_age,the_age);
        db.insert (TABLE_NAME,null,cv);
        Log.e("DATABASE OPERATIONS","One row inserted..");
    } */

    public Cursor getContact(SQLiteDatabase db){
        Cursor cursor;
        String[] projections={COLUMN_name,COLUMN_age,COLUMN_contact_no};
        cursor=db.query(TABLE_NAME,projections,null,null,null,null,null);
        return cursor;

}

   /* public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
        return res;
    } */

    public Cursor fetchdata ( String  patient_name , SQLiteDatabase sqLiteDatabase ) {
        String [] projections = {COLUMN_contact_no,COLUMN_age};
        String selection = COLUMN_name+" LIKE ?"; // the where condition, where putting the name which fetch out the row
        String[] select_args = {patient_name};
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,projections,selection,select_args,null,null,null);
        return cursor ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        String query="DROP TABLE if exist "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }


}
