package com.mymag.mymag.model.activities;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by UserX on 14.3.2017 г..
 */

public class DBHelper  extends SQLiteOpenHelper{
    protected  SQLiteDatabase db;
    private final static String dbName ="UsersDataBase";

    public DBHelper(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users( _id integer primary key autoincrement,  name text ,password text, email text, " +
                "phone text , address text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  void open() throws SQLException {
        db = getWritableDatabase();
    }
    public void  close(){
        db.close();
    }

}
