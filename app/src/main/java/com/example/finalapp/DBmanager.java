package com.example.finalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBmanager {
    private DBHelper dbhelper;
    private String TBNAME;
    public DBmanager(Context context){
        dbhelper=new DBHelper(context);
        TBNAME=DBHelper.TB_NAME;
    }
    public void add(Item item,String type){
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("date",item.getDate());
        values.put("type",item.getType());
        values.put("note",item.getNote());
        if(type.equals("in")){
            //(String date, String type, String note, float wage, float partime, float packet, float others)
        values.put("wage",item.getWage());
        values.put("partime",item.getPartime());
        values.put("packet",item.getPacket());
        }
        if(type.equals("out")){
            // float food, float entertain, float traffic, float clothes,
            // float house,float study, float medical, float others
            values.put("food",item.getFood());
            values.put("entertain",item.getEntertain());
            values.put("traffic",item.getTraffic());
            values.put("clothes",item.getClothes());
            values.put("house",item.getHouse());
            values.put("study",item.getStudy());
            values.put("medical",item.getMedical());
        }
        values.put("others",item.getOthers());
        values.put("count",item.getCount());
        db.insert(TBNAME,null,values);
        db.close();
    }
    public Cursor findRecord(String words){
        Cursor cursor=dbhelper.getReadableDatabase().rawQuery(
                "select * from "+TBNAME+" where date like '%"+words+"%' or note like '%"+words+"%'",null);
        return cursor;
    }
    public void deleteAll(){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.delete(TBNAME,null,null);
        db.close();
    }

}
