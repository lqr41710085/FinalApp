package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class searchdetail extends AppCompatActivity {
    DBmanager m;

    String TAG="searchdetailhhh";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchdetail);

        m=new DBmanager(this);
        Intent in=this.getIntent();
        String date=in.getStringExtra("date");
        Cursor cursor=m.findDetail(date);
        Log.i(TAG,"start ok::"+date);
        if(cursor.moveToNext()){
            TextView v=findViewById(R.id.datetext);
            v.setText(date);
            v=findViewById(R.id.notetext);
            v.setText("Notes: "+cursor.getString(2));
            v=findViewById(R.id.foodtext);
            v.setText("food: "+cursor.getString(3));
            v=findViewById(R.id.entertaintext);
            v.setText("entertainment: "+cursor.getString(4));
            v=findViewById(R.id.traffictext);
            v.setText("traffic: "+cursor.getString(5));
            v=findViewById(R.id.clothestext);
            v.setText("clothes: "+cursor.getString(6));
            v=findViewById(R.id.housetext);
            v.setText("house: "+cursor.getString(7));
            v=findViewById(R.id.studytext);
            v.setText("study: "+cursor.getString(8));
            v=findViewById(R.id.medicaltext);
            v.setText("medical: "+cursor.getString(9));
            v=findViewById(R.id.otherouttext);
            v.setText("other: "+cursor.getString(10));
            v=findViewById(R.id.allouttext);
            float all=cursor.getFloat(3)+cursor.getFloat(4)+cursor.getFloat(5)+
                cursor.getFloat(6)+cursor.getFloat(7)+cursor.getFloat(8)+cursor.getFloat(9)+cursor.getFloat(10);
            v.setText("all: "+all);

            v=findViewById(R.id.wagetext);
            v.setText("wage: "+cursor.getString(11));
            v=findViewById(R.id.parttext);
            v.setText("pattime: "+cursor.getString(12));
            v=findViewById(R.id.packettext);
            v.setText("redpacket: "+cursor.getString(13));
            v=findViewById(R.id.otherintext);
            v.setText("other: "+cursor.getString(14));
            float all2=cursor.getFloat(11)+cursor.getFloat(12)+cursor.getFloat(13)+cursor.getFloat(14);
            v=findViewById(R.id.allintext);
            v.setText("all: "+all2);

            v=findViewById(R.id.balancetext);
            v.setText("Balance: "+(all2-all));
        }

    }
}
