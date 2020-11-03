package com.example.finalapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DB_NAME="mybook.db";
    public static final String TB_NAME="tb_mybook";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public DBHelper(Context context){
        super(context, DB_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {//ID,日期,备注,food，entertain,traffic,clothes,house,study,medical,其他
                                            // 工资、兼职、红包、其他
            db.execSQL("CREATE TABLE "+TB_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,NOTE TEXT,FOOD REAL,ENTERTAIN REAL,TRAFFIC REAL," +
                    "CLOTHES REAL,HOUSE REAL,STUDY REAL,MEDICAL REAL,OTHEROUT REAL,WAGE REAL,PARTIME REAL,PACKET REAL,OTHERIN REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
