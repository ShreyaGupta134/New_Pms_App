package com.example.shreyagupta.login_register;

/**
 * Created by Shreya Gupta on 19-12-2016.
 */

        import android.app.DownloadManager;
        import  android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.os.Build;
        import android.provider.ContactsContract;
        import android.support.annotation.RequiresApi;
        import android.util.Log;

        import java.util.ArrayList;
        import java.util.List;

        import static android.R.attr.id;


public class DatabaseHelper extends SQLiteOpenHelper {

    public   static  final  int DATABASE_VERSION = 1;
    public   static  final  String DATABASE_NAME="contacts.db";
    public   static  final  String PATIENT_CONTACTS="contacts";
    public   static  final  String PATIENT_RECORDS="patient_history";
    public   static  final  String COLUMN_patient_id="id";
    public   static  final  String COLUMN_patient_history_id="patient_id";
    public   static  final  String COLUMN_age="age";
    public   static  final  String COLUMN_contact_no="contact_no";
    public   static  final  String COLUMN_name="name";
    public   static  final  String COLUMN_gender="gender";
    public   static  final  String COLUMN_pres="prescription";
    public   static  final  String COLUMN_diagnosis="diagnosis";
    public   static  final  String COLUMN_note="note";
    public   static  final  String COLUMN_date="date";


    SQLiteDatabase db;


    public static final String CONTACT_CREATE="create table contacts (id integer primary key not null , "
            + "name text not null , age text not null , date text not null , contact_no text not null);";

    public static final String HISTORY_CREATE="create table patient_history (patient_id integer , "
            + "prescription text not null , diagnosis text not null , note text not null , date text not null);";


    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onOpen(SQLiteDatabase database) {
        super.onOpen(database);
        if (!database.isReadOnly()) {
            database.setForeignKeyConstraintsEnabled(true);

        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONTACT_CREATE);
        db.execSQL(HISTORY_CREATE);

        this.db = db;
    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

   public void insertcontacts(Contact c){
        db=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(COLUMN_patient_id,c.getId());
        value.put(COLUMN_age,c.getage());
        value.put(COLUMN_contact_no,c.getContact_no());
        value.put(COLUMN_name,c.getname());
        value.put(COLUMN_date,c.getDate());//where is date?
        db.insert(PATIENT_CONTACTS,null,value);

    }

    public void insertPatientRecord(Contact_Records c){
        db=this.getWritableDatabase();
        ContentValues value1=new ContentValues();
        value1.put(COLUMN_patient_history_id,c.getId());
        value1.put(COLUMN_diagnosis,c.getDiagnosis());
        value1.put(COLUMN_pres,c.getPre_med());
        value1.put(COLUMN_note,c.getType());
        value1.put(COLUMN_date,c.getDate());
        db.insert(PATIENT_RECORDS,null,value1);
    }



   public Cursor getContact(SQLiteDatabase db){
        Cursor cursor;
        String[] projections={COLUMN_patient_id,COLUMN_name,COLUMN_age,COLUMN_contact_no,COLUMN_date};
        cursor=db.query(PATIENT_CONTACTS,projections,null,null,null,null,null);
        return cursor;

    }

    public Cursor getPatientHistory(SQLiteDatabase db){
        Cursor cursor;
        String[] projections1={COLUMN_patient_history_id,COLUMN_pres,COLUMN_diagnosis,COLUMN_date,COLUMN_note};
        cursor=db.query(PATIENT_RECORDS,projections1,null,null,null,null,null);
        return cursor;

    }
    /*public Cursor getData(SQLiteDatabase sqLiteDatabase) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("Select * from patient_history where" + COLUMN_patient_history_id + "=" +id , null);
        return res;
    }*/

    public Cursor getData(SQLiteDatabase sqLiteDatabase) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query= "Select * from patient_history where " + COLUMN_patient_history_id + "=" +id;
        Log.i("PATIENT_RECORDS_QUERY",query);
        Cursor res = db.rawQuery(query, null);
        return res;

    }

    /*public Cursor getData(SQLiteDatabase sqLiteDatabase) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query=("Select * from patient_history where " + COLUMN_patient_history_id + "="+id,null);
        Log.i("PATIENT_RECORDS_QUERY",query);
        Cursor res = db.rawQuery(query, null);
        return res;
    }*/

    /*public void getData(SQLiteDatabase sqLiteDatabase) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = db.rawQuery("Select * from patient_history where " + COLUMN_patient_history_id + "=" +id , null).toString();

        Log.i("Query",query );
        db.execSQL(query);

    }*/


    public Cursor fetchdata ( String  patient_name , SQLiteDatabase sqLiteDatabase ) {
        String [] projections = {COLUMN_contact_no,COLUMN_age};
        String selection = COLUMN_name+" LIKE ?"; // the where condition, where putting the name which fetch out the row
        String[] select_args = {patient_name};
        Cursor cursor = sqLiteDatabase.query(PATIENT_CONTACTS,projections,selection,select_args,null,null,null);
        return cursor ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        String query = "DROP TABLE if exist " + PATIENT_CONTACTS;
        String query1 = "DROP TABLE if exist " + PATIENT_RECORDS;
        db.execSQL(query);
        db.execSQL(query1);
        this.onCreate(db);

    }
}
