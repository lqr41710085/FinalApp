package com.example.finalapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class searchDBHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DB_NAME="search_record.db";
    public static final String TB_NAME="my_search";
    public searchDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public searchDBHelper(Context context){
        super(context,DB_NAME,null,VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("create table "+TB_NAME+"(id integer primary key autoincrement,words text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
