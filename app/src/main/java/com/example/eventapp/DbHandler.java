package com.example.eventapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

// 6. steps (extends SQLiteOpenHelper and implement 2 method.

public class DbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "event";
    private static final String TABLE_NAME = "event";

//columns names
    private static final String ID ="id";
    private static  final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String STARTED = "started";
    private static final String FINISHED = "finished";


    public DbHandler(@Nullable Context context) {
        //MULINMA RUN VENA METHOD EKA
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// mema method eka table hadanna yodagnnawa.
// DATA RETRIVE STORE KARANAVANM MULINMA RUN VENNE MEMA METHOD EKAI.

        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +TITLE + " TEXT,"
                +DESCRIPTION + " TEXT,"
                +STARTED+ " TEXT,"
                +FINISHED+" TEXT" +
                ");";
  // RUN THE QUERY
        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
// mema method eka magin table eke upgrade sidda karanava.
 //VERSION  NUMBER EKA CHANGE UNAMA THAMA MEMA METHOD EKA VEDA KARANNE.

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+TABLE_NAME;
        //DROP EXIST TABLE
        db.execSQL(DROP_TABLE_QUERY);
        //CREATE TABLE AGAIN
        onCreate(db);


    }

  // 7. step -ADD EVENT
 // ADD EVENT ACTIVITY EKE eventModel,OBJECT EKA PASS KARALA THIYENAWA
    public void addEvent(EventModel eventModel)
  {
      SQLiteDatabase sqLiteDatabase = getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put(TITLE,eventModel.getTitle());
      contentValues.put(DESCRIPTION,eventModel.getDescription());
      contentValues.put(STARTED,eventModel.getStarted());
      contentValues.put(FINISHED,eventModel.getFinished());
 // SAVE THE DATA
      sqLiteDatabase.insert(TABLE_NAME,null,contentValues );
// CLOSED DATABASE
      sqLiteDatabase.close();

  }

// 10.steps COUNT THE EVENT(table row)
    public int eventCount(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        //run the query
        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
//dan mema DbHandler class ekee   object ekk main activity eke hada ganna onii.(eventCount METHOD EKA CALL KARA GENIMA SADAHA)
    }
//14. steps GET ALL EVENTS INTO A LIST
    public List<EventModel> getAllEvents()
    {
        //CREATE NEW ARRAY LIST
        List<EventModel> eventModelss = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        // RUN THE QUERY
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                //CREATE NEW EventModel OBJECT
                EventModel eventModel = new EventModel();
                //SET THE DATA
                eventModel.setId(cursor.getInt(0));
                eventModel.setTitle(cursor.getString(1));
                eventModel.setDescription(cursor.getString(2));
                eventModel.setStarted(cursor.getLong(3));
                eventModel.setFinished(cursor.getLong(4));
                //events =[obj,objs]
                eventModelss.add(eventModel);
            }while (cursor.moveToNext());
        }
        return eventModelss;
 // DAN MAIN SCREEM EKATA DATA LOAD KARA GENIMA SADAHA ARRAY ADAPTER EKK C REATE KARANNA VENAVA.
 //MEMA METHOD EKEN ENA DATA TIKA MAIN ACTIVITY EKATA MULINMA GAMU.
    }
}
