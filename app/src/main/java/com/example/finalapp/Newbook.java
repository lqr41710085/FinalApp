package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import android.widget.Toast;


import java.util.Calendar;



public class Newbook extends AppCompatActivity {

    private static String TAG="Newbook";
    DatePicker datePicker;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newbook);
        datePicker=findViewById(R.id.date);
        Calendar cal=Calendar.getInstance();
        int y=cal.get(Calendar.YEAR),m=cal.get(Calendar.MONTH),d=cal.get(Calendar.DATE);//初始化为今天日期
        datePicker.init(y, m, d, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    date=year+"-"+monthOfYear+"-"+dayOfMonth;
                Log.i(TAG,"date::"+date);
            }
        });
        Toast.makeText(this,"please choose date",Toast.LENGTH_LONG);
    }
    public void newbook(View view){
        Intent in=new Intent();
        if(view.getId()==R.id.outbtn)
            in=new Intent(this, Newout.class);
        if(view.getId()==R.id.inbtn)
            in=new Intent(this, Newin.class);
        in.putExtra("date",date);
        startActivity(in);
    }
}
