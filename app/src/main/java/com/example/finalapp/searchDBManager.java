package com.example.finalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class searchDBManager {
    private searchDBHelper searchhelper;
    private String TB_NAME;
    public searchDBManager(Context context){
        searchhelper=new searchDBHelper(context);
        TB_NAME=searchDBHelper.TB_NAME;
    }
    public void addRecord(String words){
        SQLiteDatabase db=searchhelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("words",words);
        db.insert(TB_NAME,null,values);
        db.close();
    }
    public Cursor getRecord(){
        Cursor cursor=searchhelper.getReadableDatabase().rawQuery(
                "select * from "+TB_NAME,null);
        return cursor;
    }
    public Cursor findRecord(String words){
        Cursor cursor=searchhelper.getReadableDatabase().rawQuery(
                "select * from "+TB_NAME+" where words like '%"+words+"%'",null);
        return cursor;
    }
    public void clearRecord(){
        SQLiteDatabase db = searchhelper.getWritableDatabase();
        db.delete(TB_NAME,null,null);
        db.close();
    }
}
