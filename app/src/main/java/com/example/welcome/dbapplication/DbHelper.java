package com.example.welcome.dbapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DbName = "database1.db";
    public static final String Tablename = "Table1";
    public static final String Col1 = "id";
    public static final String Col2 = "Name";
    public static final String Col3 = "Phone";
    public static final String Col4 = "Email";
    public static final String Col5 = "Passsword";

    public static final String DBName = "database2.db";
    public static final String Tablename1 = "Table2";
    public static final String Col11 = "id";
    public static final String Col22 = "Name";
    public static final String Col33 = "Email";
    public static final String Col44 = "Age";

    public DbHelper(Context context) {

        super(context, DbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + Tablename + "(id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR,Phone VARCHAR,Email VARCHAR,Password VARCHAR);");

        db.execSQL("create table " + Tablename1 + "(id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR,Email VARCHAR,Age VARCHAR);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }

    public boolean insertData(String name, String email, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col2, name);
        contentValues.put(Col3, email);
        contentValues.put(Col4, username);
        contentValues.put(Col5, password);

        long result = db.insert(Tablename, null, contentValues);

        if (result == -1) {

            return false;

        }else {

            return true;
        }
    }
    public boolean addData(String Name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col22, Name);

        long result = db.insert(Tablename1, null, contentValues);

        if (result == -1) {
            return false;
        }else {
            return true;
        }
    }

    public Cursor getAllData(String s1, String s2) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {Col2};
        String selection = Col4 + " = ?" + " and " + Col5 + " = ?";
        String[] selectionArgs = {s1, s2};
        Cursor res = db.query(Tablename, columns, selection, selectionArgs, null, null, null);
        return res;
    }

    public Cursor getListContents(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + Tablename1,null);
        return data;
    }
}
