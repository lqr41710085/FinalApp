package com.example.finalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
        if(type.equals("in")){
            //(String date, String type, String note, float wage, float partime, float packet, float others)
        values.put("date",item.getDate());
        values.put("type",item.getType());
        values.put("note",item.getNote());
        values.put("wage",item.getWage());
        values.put("partime",item.getPartime());
        values.put("packet",item.getPacket());
        values.put("others",item.getOthers());
        values.put("count",item.getCount());
        db.insert(TBNAME,null,values);
        db.close();
        }
        if(type.equals("out")){
            //String date, String type, String note, float food, float entertain, float traffic, float clothes,
            // float house,float study, float medical, float others

        }
    }
}
