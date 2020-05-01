package com.demo.carrental;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "StudentTest.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "first";
    public static final String COL_3 = "last";
    public static final String COL_4 = "emailid";
    public static final String COL_5 = "password";
    SQLiteDatabase sqlitedb;

    public SqliteDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        sqlitedb=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "first TEXT NOT NULL,last TEXT NOT NULL,emailid TEXT NOT NULL,password TEXT NOT NULL)");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String fName,String lName,String emailId,String password) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,fName);
        contentValues.put(COL_3,lName);
        contentValues.put(COL_4,emailId);
        contentValues.put(COL_5,password);
        long result = sqlitedb.insert(TABLE_NAME,null ,contentValues);

        if(result == -1)
            return false;
        else
            return true;

    }


    public boolean Login(String username, String password) throws SQLException

    {

        Cursor mCursor = sqlitedb.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE emailid=? AND password=?", new String[]{username,password});

        if (mCursor != null) {

            if(mCursor.getCount() > 0)

            {

                return true;

            }

        }

        return false;

    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = sqlitedb.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
