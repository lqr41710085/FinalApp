package com.example.finalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        SQLiteDatabase dbr=dbhelper.getReadableDatabase();
        //判断日期是否重复，进行合并
        Cursor cursor=dbr.rawQuery("select * from "+TBNAME+" where DATE='"+item.getDate()+"'",null);
        ContentValues values=new ContentValues();
        if(cursor.moveToNext()){
            values.put("note",cursor.getString(2)+";"+item.getNote());
            if(type.equals("in")){
                //(String date, String type, String note, float wage, float partime, float packet, float others)
                values.put("wage",cursor.getFloat(11)+item.getWage());
                values.put("partime",cursor.getFloat(12)+item.getPartime());
                values.put("packet",cursor.getFloat(13)+item.getPacket());
                values.put("otherin",cursor.getFloat(14)+item.getOtherin());
                values.put("balance",cursor.getFloat(15)+item.getWage()+item.getPartime()+item.getPacket()+item.getOtherin());
            }
            if(type.equals("out")){
                // float food, float entertain, float traffic, float clothes,
                // float house,float study, float medical, float others
                values.put("food",cursor.getFloat(3)+item.getFood());
                values.put("entertain",cursor.getFloat(4)+item.getEntertain());
                values.put("traffic",cursor.getFloat(5)+item.getTraffic());
                values.put("clothes",cursor.getFloat(6)+item.getClothes());
                values.put("house",cursor.getFloat(7)+item.getHouse());
                values.put("study",cursor.getFloat(8)+item.getStudy());
                values.put("medical",cursor.getFloat(9)+item.getMedical());
                values.put("otherout",cursor.getFloat(10)+item.getOtherout());
                values.put("balance",cursor.getFloat(15)-item.getFood()-item.getEntertain()-item.getTraffic()
                        -item.getClothes()-item.getHouse()-item.getStudy()-item.getMedical()-item.getOtherout());
            }
            db.update(TBNAME,values,"DATE=?",new String[]{item.getDate()});
            db.close();
        }else {
            values.put("date",item.getDate());
            values.put("note",item.getNote());
            if(type.equals("in")){
                //(String date, String type, String note, float wage, float partime, float packet, float others)
                values.put("food",0);
                values.put("entertain",0);
                values.put("traffic",0);
                values.put("clothes",0);
                values.put("house",0);
                values.put("study",0);
                values.put("medical",0);
                values.put("otherout",0);
                values.put("wage",item.getWage());
                values.put("partime",item.getPartime());
                values.put("packet",item.getPacket());
                values.put("otherin",item.getOtherin());
                values.put("balance",item.getWage()+item.getPartime()+item.getPacket()+item.getOtherin());
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
                values.put("otherout",item.getOtherout());
                values.put("wage",0);
                values.put("partime",0);
                values.put("packet",0);
                values.put("otherin",0);
                values.put("balance",-item.getFood()-item.getEntertain()-item.getTraffic()
                        -item.getClothes()-item.getHouse()-item.getStudy()-item.getMedical()-item.getOtherout());
            }
            db.insert(TBNAME,null,values);
            db.close();

        }
    }
    public Cursor findRecord(String words){
        Cursor cursor=dbhelper.getReadableDatabase().rawQuery(
                "select * from "+TBNAME+" where date like '%"+words+"%' or note like '%"+words+"%'",null);
        return cursor;
    }
    public Cursor findDetail(String date){
        Cursor cursor=dbhelper.getReadableDatabase().rawQuery("select * from "+TBNAME+" where date='"+date+"'",null);
        return cursor;
    }
    public Cursor findDetails(String date){

        Cursor cursor=dbhelper.getReadableDatabase().rawQuery("select * from "+TBNAME+" where date like '"+date+"%'",null);
        return cursor;
    }
}
